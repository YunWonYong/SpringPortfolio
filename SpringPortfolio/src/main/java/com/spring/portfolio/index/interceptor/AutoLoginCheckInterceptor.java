package com.spring.portfolio.index.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.spring.portfolio.account.model.AccountDTO;
import com.spring.portfolio.account.service.AccountService;

public class AutoLoginCheckInterceptor extends HandlerInterceptorAdapter {
	@Resource(name = "accountService")
	private AccountService accountService;

	public AutoLoginCheckInterceptor() {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession sess = request.getSession(false);
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				AccountDTO dto = accountService.getOne(cookie.getValue());
				if(dto != null) {
					sess = request.getSession();
					sess.setAttribute("login",dto);
				}
			}
		}
		return true;
	}
}
