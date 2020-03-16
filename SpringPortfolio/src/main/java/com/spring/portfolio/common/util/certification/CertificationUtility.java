package com.spring.portfolio.common.util.certification;

import java.security.MessageDigest;
import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.spring.portfolio.certification.model.CertificationVO;
import com.spring.portfolio.common.namespaces.UtilNameSpaces;
import com.spring.portfolio.common.util.Utility;

@Component(UtilNameSpaces.CERTIFICATION)
public class CertificationUtility implements Utility {
	@Resource(name = "mailSender")
	private JavaMailSender mailSender;

	public CertificationUtility() {
	}

	public boolean send(CertificationVO vo) throws Exception {
		MimeMessage mimeMessage = null;
		MimeMessageHelper helper = null;
		boolean flag = false;
		try {
			mimeMessage = mailSender.createMimeMessage();
			helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			helper.setSubject(vo.getSubject());
			helper.setText(vo.getContent(), true);
			helper.setFrom(vo.getForm());
			helper.setTo(vo.getTo());
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			mailSender.send(mimeMessage);
		}
		return flag;
	}

	public String setContent(String to) throws Exception {
		StringBuffer text = new StringBuffer();
		text.append("안녕하세요. portfolio 기능 테스트입니다.");
		text.append("<br>");
		text.append("회원가입을 진행하기 전에 이메일 인증을 진행하겠습니다.");
		text.append("<br>");  
		text.append("<a href='http://192.168.0.25/certification/inspection_check?code=");
		text.append(inspectionCode(to));
		text.append("'>여기를 클릭해 주세요.</a>"); 
		return text.toString();
	}

	public String inspectionCode(String to) throws Exception {
		StringBuffer code = new StringBuffer();
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		digest.reset();
		digest.update("villainy no!".getBytes());
		for (byte b : digest.digest(to.getBytes("UTF-8"))) {
			code.append(Integer.toHexString(0xff & b));
		}
		return code.toString();
	}

}
