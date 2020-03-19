package com.spring.portfolio.certification.model;

public class CertificationVO {
	private final String subject = "portfolio 이메일 인증 입니다.", form = "portfolioemail0215@gmail.com";
	private String content, to;

	@SuppressWarnings("unused")
	private CertificationVO() {
	}

	public CertificationVO(String content, String to) {
		this.content = content;
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getForm() {
		return form;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

}
