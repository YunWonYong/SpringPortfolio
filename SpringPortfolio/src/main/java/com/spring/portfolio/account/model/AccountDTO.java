package com.spring.portfolio.account.model;

import java.io.Serializable;

public class AccountDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String m_id, m_password, autoLogin;

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
