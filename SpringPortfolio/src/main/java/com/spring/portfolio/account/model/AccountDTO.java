package com.spring.portfolio.account.model;

import java.io.Serializable;

public class AccountDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String m_id, m_password, autoLogin, m_nickname, m_grant, a_jsession_id;
	private int a_holding_time;

	public AccountDTO() {
		// TODO Auto-generated constructor stub
	}

	public AccountDTO(String m_id, String m_password, String autoLogin) {
		this.m_id = m_id;
		this.m_password = m_password;
		this.autoLogin = autoLogin;
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

	public String getAutoLogin() {
		return autoLogin;
	}

	public void setAutoLogin(String autoLoin) {
		this.autoLogin = autoLoin;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getM_nickname() {
		return m_nickname;
	}

	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	}

	public String getM_grant() {
		return m_grant;
	}

	public void setM_grant(String m_grant) {
		this.m_grant = m_grant;
	}

	public String getA_jsession_id() {
		return a_jsession_id;
	}

	public void setA_jsession_id(String a_jsession_id) {
		this.a_jsession_id = a_jsession_id;
	}

	public int getA_holding_time() {
		return a_holding_time;
	}

	public void setA_holding_time(int a_holding_time) {
		this.a_holding_time = a_holding_time;
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
		AccountDTO other = (AccountDTO) obj;
		if (m_id == null) {
			if (other.m_id != null)
				return false;
		} else if (!m_id.equals(other.m_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AccountDTO [m_id=" + m_id + ", m_password=" + m_password + ", autoLoin=" + autoLogin + "]";
	}

}
