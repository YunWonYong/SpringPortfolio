package com.spring.portfolio.member.model;

import java.io.Serializable;

public class MemberVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String year, month, date, genderCheck, emailAdrress;

	public MemberVO() {
		// TODO Auto-generated constructor stub
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getGenderCheck() {
		return genderCheck;
	}

	public void setGenderCheck(String genderCheck) {
		this.genderCheck = genderCheck;
	}

	public String getEmailAdrress() {
		return emailAdrress;
	}

	public void setEmailAdrress(String emailAdrress) {
		this.emailAdrress = emailAdrress;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getBirth() {
		return year + "-" + month + "-" + date;
	}

	@Override
	public String toString() {
		return "MemberVO [year=" + year + ", genderCheck=" + genderCheck + ", emailAdrress=" + emailAdrress + "]";
	}

}
