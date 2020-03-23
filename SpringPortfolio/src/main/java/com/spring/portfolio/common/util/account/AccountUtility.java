package com.spring.portfolio.common.util.account;

import java.util.Calendar;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.spring.portfolio.account.model.AccountDTO;
import com.spring.portfolio.common.namespaces.UtilNameSpaces;
import com.spring.portfolio.common.util.Utility;

@Component(UtilNameSpaces.ACCOUNT)
public class AccountUtility implements Utility {

	public AccountUtility() {
	} 

	public String getHoldingTime() {
		return String.valueOf(Long.parseLong(getRealTime()) + (60 * 60 * 24 * 1000));

	}

	public String injectJsessionID(Cookie[] cookies, String autoCheck) {
		if (cookies != null && autoCheck.equals("on")) {
			for (Cookie c : cookies) {
				if (c.getName().equals("JSESSIONID")) {
					return c.getValue();
				}
			}
		}
		return null;
	}

	public AccountDTO loginCheck(Object obj) {
		return obj != null ? obj instanceof AccountDTO ? (AccountDTO) obj : null : null;
	}

	public boolean cookieCheck(Cookie cookie) {
		return cookie != null ? cookie.getName().equals("a_jsession_id") : false;
	}

	public String getA_jsession_id(Cookie[] cookies) {
		Cookie cookie = getCookie(cookies);
		if (cookie != null) {
			return cookie.getValue();
		}
		return null;

	}

	public boolean lifeTimeCheck(String a_holding_time) {
		return Long.parseLong(a_holding_time) - Long.parseLong(getRealTime()) > 0;
	}

	public Cookie getCookie(Cookie[] cookies) {
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("a_jsession_id")) {
					return c;
				} 
			}
		}
		return null;
	}

	public void cookieDelete(HttpServletResponse response, Cookie cookie) {
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}

	private String getRealTime() {
		Calendar c = Calendar.getInstance();
		String realTime = String.valueOf(c.getTimeInMillis());
		return realTime;
	}
}
