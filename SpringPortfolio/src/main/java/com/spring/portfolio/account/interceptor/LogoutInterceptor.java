package com.spring.portfolio.account.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.spring.portfolio.account.model.AccountDTO;
import com.spring.portfolio.account.service.AccountService;
import com.spring.portfolio.common.exception.account.AutoLoginOffException;
import com.spring.portfolio.common.namespaces.ServiceNameSpaces;
import com.spring.portfolio.common.namespaces.UtilNameSpaces;
import com.spring.portfolio.common.util.account.AccountUtility;

public class LogoutInterceptor extends HandlerInterceptorAdapter {
	@Resource(name = UtilNameSpaces.ACCOUNT)
	private AccountUtility accountUtil;
	@Resource(name = ServiceNameSpaces.ACCOUNT)
	private AccountService accountService;

	public LogoutInterceptor() {
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv)
			throws Exception {
		Cookie cookie = accountUtil.getCookie(request.getCookies());
		AccountDTO dto = null;
		HttpSession sess = null;
		try {
			sess = request.getSession();
			dto = accountUtil.loginCheck(sess.getAttribute("login"));
			if (cookie == null) {
				throw new AutoLoginOffException();
			}
			cookie.setPath("/");
			accountService.remove(dto); 
			accountUtil.cookieDelete(response, cookie);
		} catch (AutoLoginOffException e) {
		} finally {
			mv.setViewName("redirect:/");
			sess.invalidate();
		}
		super.postHandle(request, response, handler, mv);
	}

}
