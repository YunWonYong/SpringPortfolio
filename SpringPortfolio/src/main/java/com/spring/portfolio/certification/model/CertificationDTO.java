package com.spring.portfolio.certification.model;

import java.io.Serializable;

public class CertificationDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String c_inspection, c_inspection_check, c_email, c_date, c_id;
	private int c_index;

	public CertificationDTO() {
	}

	public CertificationDTO(String c_inspection, String c_inspection_check, String c_email, String c_date, String c_id,
			int c_index) {
		this.c_inspection = c_inspection;
		this.c_inspection_check = c_inspection_check;
		this.c_email = c_email;
		this.c_date = c_date;
		this.c_id = c_id;
		this.c_index = c_index;
	}

	public String getC_inspection() {
		return c_inspection;
	}

	public void setC_inspection(String c_inspection) {
		this.c_inspection = c_inspection;
	}

	public String getC_inspection_check() {
		return c_inspection_check;
	}

	public void setC_inspection_check(String c_inspection_check) {
		this.c_inspection_check = c_inspection_check;
	}

	public String getC_email() {
		return c_email;
	}

	public void setC_email(String c_email) {
		this.c_email = c_email;
	}

	public String getC_date() {
		return c_date;
	}

	public void setC_date(String c_date) {
		this.c_date = c_date;
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public int getC_index() {
		return c_index;
	}

	public void setC_index(int c_index) {
		this.c_index = c_index;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
