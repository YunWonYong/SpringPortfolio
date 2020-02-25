package com.spring.portfolio.member.model;

import java.io.Serializable;

public class MemberDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int m_index, m_age;
	private char m_grant, m_gender;
	private String m_id, m_password, m_name, m_birth, m_zipcode, m_address1, m_address2, m_email, m_phone, m_registdate,
			m_nickname;

	public MemberDTO() {
	}

	/**
	 * @param m_index
	 * @param m_id
	 * @param m_password
	 * @param m_name
	 * @param m_grant
	 * @param m_birth
	 * @param m_age
	 * @param m_zipcode
	 * @param m_address1
	 * @param m_address2
	 * @param m_email
	 * @param m_phone
	 * @param m_gender
	 * @param m_registdate
	 * @param m_nickname
	 */
	public MemberDTO(int m_index, String m_id, String m_password, String m_name, char m_grant, String m_birth,
			int m_age, String m_zipcode, String m_address1, String m_address2, String m_email, String m_phone,
			char m_gender, String m_registdate, String m_nickname) {
		this.m_index = m_index;
		this.m_id = m_id;
		this.m_password = m_password;
		this.m_name = m_name;
		this.m_grant = m_grant;
		this.m_birth = m_birth;
		this.m_age = m_age;
		this.m_zipcode = m_zipcode;
		this.m_address1 = m_address1;
		this.m_address2 = m_address2;
		this.m_email = m_email;
		this.m_phone = m_phone;
		this.m_gender = m_gender;
		this.m_registdate = m_registdate;
		this.m_nickname = m_nickname;
	}

	public int getM_index() {
		return m_index;
	}

	public void setM_index(int m_index) {
		this.m_index = m_index;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_password() {
		return m_password;
	}

	public void setM_password(String m_password) {
		this.m_password = m_password;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public char getM_grant() {
		return m_grant;
	}

	public void setM_grant(char m_grant) {
		this.m_grant = m_grant;
	}

	public String getM_birth() {
		return m_birth;
	}

	public void setM_birth(String m_birth) {
		this.m_birth = m_birth;
	}

	public int getM_age() {
		return m_age;
	}

	public void setM_age(int m_age) {
		this.m_age = m_age;
	}

	public String getM_zipcode() {
		return m_zipcode;
	}

	public void setM_zipcode(String m_zipcode) {
		this.m_zipcode = m_zipcode;
	}

	public String getM_address1() {
		return m_address1;
	}

	public void setM_address1(String m_address1) {
		this.m_address1 = m_address1;
	}

	public String getM_address2() {
		return m_address2;
	}

	public void setM_address2(String m_address2) {
		this.m_address2 = m_address2;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public String getM_phone() {
		return m_phone;
	}

	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}

	public char getM_gender() {
		return m_gender;
	}

	public void setM_gender(char m_gender) {
		this.m_gender = m_gender;
	}

	public String getM_registdate() {
		return m_registdate;
	}

	public void setM_registdate(String m_registdate) {
		this.m_registdate = m_registdate;
	}

	public String getM_nickname() {
		return m_nickname;
	}

	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((m_id == null) ? 0 : m_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberDTO other = (MemberDTO) obj;
		if (m_id == null) {
			if (other.m_id != null)
				return false;
		} else if (!m_id.equals(other.m_id))
			return false;
		return true;
	}

}
