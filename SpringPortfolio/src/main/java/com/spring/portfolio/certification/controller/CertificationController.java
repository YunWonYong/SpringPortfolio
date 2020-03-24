package com.spring.portfolio.certification.controller;

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
import com.spring.portfolio.common.util.certification.CertificationUtility;

@Controller
@RequestMapping(ControllerNameSpaces.CERTIFICATION)
public class CertificationController {
	@Resource(name = ServiceNameSpaces.CERTIFICATION)
	private CertificationService certificationService;
	@Resource(name = UtilNameSpaces.CERTIFICATION)
	private CertificationUtility certificationUtil;

	public CertificationController() {
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
			e.printStackTrace();
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
			Object obj = from.equals("insert") ? certificationService.register(dto) : certificationService.getOne(dto);
			boolean flag = obj instanceof Integer ? true : false;
			dto = (CertificationDTO) obj;
			msg = flag ? "이메일이 발송 되었습니다. 인증해 주세요." : null;

			msg = msg == null
					? dto == null ? "이메일이 발송 되었습니다. 인증해 주세요."
							: dto.getC_inspection_check().equals("1")? "인증이 완료된 이메일입니다." : "인증이 안된 이메일입니다."
					: null;
			if (msg.equals("이메일이 발송 되었습니다. 인증해 주세요.")|| msg.equals("인증이 안된 이메일입니다.")) {
				if (from.equals("update")) {
					Object sessObject = sess.getAttribute("login");
					AccountDTO accountDTO = null;
					if (sessObject != null ? sessObject instanceof AccountDTO : false) {
						accountDTO = (AccountDTO) sessObject;
					}
					if (accountDTO != null) {
						dto = new CertificationDTO();
						dto.setC_email(vo.getTo());
						dto.setC_inspection(certificationUtil.inspectionCode(vo.getTo()));
						dto.setC_id(accountDTO.getM_id());
						dto.setC_inspection_check("0");
						certificationService.modify(dto);
					}
				}
				isSend = true;
			}
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
