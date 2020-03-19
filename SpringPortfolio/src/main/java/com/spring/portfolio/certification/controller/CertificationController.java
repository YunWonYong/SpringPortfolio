package com.spring.portfolio.certification.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
		// TODO Auto-generated constructor stub
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

	@RequestMapping("inspection")
	public String insert(@RequestParam("m_email") String to) {
		try {
			CertificationVO vo = new CertificationVO(certificationUtil.setContent(to), to);
			if (certificationUtil.send(vo)) {
				CertificationDTO dto = new CertificationDTO();
				dto.setC_email(vo.getTo());
				dto.setC_inspection(certificationUtil.inspectionCode(vo.getTo()));
				certificationService.register(dto);
			}
		} catch (Exception e) {

		}
		return "/certification/inspection";
	}
}
