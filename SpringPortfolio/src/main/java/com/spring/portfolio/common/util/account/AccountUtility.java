package com.spring.portfolio.common.util.account;

import java.util.Calendar;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.spring.portfolio.account.model.AccountDTO;
import com.spring.portfolio.common.util.UtilityCommand;

@Component("accountUtil")
public class AccountUtility implements UtilityCommand {

	public AccountUtility() {
	}

	public int getHoldingTime() {
		return getRealTime() + (60 * 60 * 24);

	}

	public String injectJsessionID(Cookie[] cookies, String autoCheck) {
		Cookie cookie = checkJsessionID(cookies, autoCheck);
		return cookie != null ? cookie.getValue() : null;
	}

	public AccountDTO loginChekc(Object obj) {
		System.out.println(obj instanceof AccountDTO);
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

	public boolean lifeTimeCheck(int a_holding_time) {
		return a_holding_time - getRealTime() > 0;
	}

	public Cookie getCookie(Cookie[] cookies) {
		return tergetCookie(cookies, "a_jsession_id");
	}

	public void cookieDelete(HttpServletResponse response, Cookie cookie) {
		System.out.println("cookie delete:" + cookie.getName());
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		System.out.println("cookie delete!");
	}

	private Cookie checkJsessionID(Cookie[] cookies, String autoCheck) {
		return autoCheck.equals("on") ? tergetCookie(cookies, "JSESSIONID") : null;
	}

	private Cookie tergetCookie(Cookie[] cookies, String target) {
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				System.out.println(cookie.getName());
				System.out.println(cookie.getValue());
				return cookie.getName().equals(target) ? cookie : null;
			}
		}
		return null;
	}

	private int getRealTime() {
		Calendar c = Calendar.getInstance();
		String realTime = String.valueOf(c.getTimeInMillis());
		return Integer.parseInt(realTime.substring(4, realTime.length()));
	}
}
