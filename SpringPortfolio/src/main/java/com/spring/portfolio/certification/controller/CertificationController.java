package com.spring.portfolio.certification.controller;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.portfolio.account.model.AccountDTO;
import com.spring.portfolio.certification.model.CertificationDTO;
import com.spring.portfolio.certification.model.CertificationVO;
import com.spring.portfolio.certification.service.CertificationService;
import com.spring.portfolio.common.namespaces.ControllerNameSpaces;
import com.spring.portfolio.common.namespaces.ServiceNameSpaces;
import com.spring.portfolio.common.namespaces.UtilNameSpaces;
import com.spring.portfolio.common.util.account.AccountUtility;
import com.spring.portfolio.common.util.certification.CertificationUtility;

@Controller
@RequestMapping(ControllerNameSpaces.CERTIFICATION)
public class CertificationController {
	@Resource(name = ServiceNameSpaces.CERTIFICATION)
	private CertificationService certificationService;
	@Resource(name = UtilNameSpaces.CERTIFICATION)
	private CertificationUtility certificationUtil;
	@Resource(name = UtilNameSpaces.ACCOUNT)
	private AccountUtility accountUtil;

	public CertificationController() {
	}

	@RequestMapping(value = "read", produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String read(String to, HttpSession sess) {
		String msg = "";
		try {
			CertificationDTO dto = new CertificationDTO();
			AccountDTO login = accountUtil.loginCheck(sess.getAttribute("login"));
			dto.setC_email(to);
			if (login != null) {
				dto.setC_id(login.getM_id());
			}
			dto = certificationService.getOne(dto);
			if (dto == null) {
				throw new NullPointerException();
			} else if (dto.getC_inspection_check().equals("0")) {
				throw new Exception();
			} 
			msg = "ok";
		} catch (NullPointerException e) {
			msg = "stay";
		} catch (Exception e) {
			msg = "no";
		}
		return msg;
	}

	@RequestMapping(value = "inspection_check", produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String check(String code) throws Exception {
		StringBuffer script = new StringBuffer();
		CertificationDTO dto = null;
		String result = "한글 테스트";
		script.append("<script type='text/javascript' src='/resources/js/certification/inspection.js'></script>");
		script.append("<script>");
		script.append("inspection_check('");
		try {
			dto = new CertificationDTO();
			dto.setC_inspection(code);
			if (!certificationService.inspectionCheck(dto)) {
				throw new Exception();
			}
			result = "인증이 성공적으로 끝낫습니다. 회원가입을 진행해 주세요.";
		} catch (Exception e) {
			result = "인증에 실패하였습니다. 다시 한번 시도해 주세요.";
		} finally {
			script.append(result);
			script.append("');");
			script.append("</script>");
		}
		return script.toString();
	}

	@RequestMapping(value = "inspection", produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String insert(String to, String from, HttpSession sess) throws Exception {
		String msg = "";
		boolean isSend = false;
		CertificationVO vo = null;
		CertificationDTO dto = null;
		try {
			vo = new CertificationVO(certificationUtil.setContent(to), to);
			dto = new CertificationDTO();
			dto.setC_email(vo.getTo());
			dto.setC_inspection(certificationUtil.inspectionCode(vo.getTo()));
			CertificationDTO duplicateDTO = certificationService.getOne(dto);
			if (duplicateDTO != null) {
				if (duplicateDTO.getC_id() == null) {
					certificationService.remove();
				} else if (duplicateDTO.getC_inspection_check().equals("0")) {
					from = "update";
				} else {
					throw new SQLException();
				}
			}
			Object obj = from.equals("insert") ? certificationService.register(dto) : certificationService.getOne(dto);
			boolean flag = obj instanceof Integer ? true : false;
			dto = !flag ? (CertificationDTO) obj : null;
			msg = flag ? "이메일이 발송 되었습니다. 인증확인해 주세요." : null;
			msg = msg == null
					? dto == null ? "이메일이 발송 되었습니다. 인증확인해 주세요."
							: dto.getC_inspection_check().equals("1") ? "인증이 완료된 이메일입니다." : "이메일이 발송 되었습니다. 인증확인해 주세요."
					: msg;
			if (msg != null ? msg.equals("이메일이 발송 되었습니다. 인증확인해 주세요.") : false) {
				if (from.equals("update")) {
					AccountDTO login = accountUtil.loginCheck(sess.getAttribute("login"));
					if (login != null) {
						dto = new CertificationDTO();
						dto.setC_email(vo.getTo());
						dto.setC_inspection(certificationUtil.inspectionCode(vo.getTo()));
						dto.setC_id(login.getM_id());
						dto.setC_inspection_check("0");
						certificationService.modify(dto);
					}
				}
				isSend = true;
			}
		} catch (SQLException e) {
			msg = "다른 사람이 인증한 아이디 입니다.";
		} catch (Exception e) {
			e.printStackTrace();
			msg = "이메일 발송이 실패되었습니다.";
		} finally {
			if (isSend) {
				certificationUtil.send(vo);
			}
		}
		return msg;
	}
}
