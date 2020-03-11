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
import com.spring.portfolio.common.namespace.ServiceNameSpaces;
import com.spring.portfolio.common.namespace.UtilNameSpaces;
import com.spring.portfolio.common.util.account.AccountUtility;

public class LogoutInterceptor extends HandlerInterceptorAdapter {
	@Resource(name = UtilNameSpaces.ACCOUN)
	private AccountUtility accountUtil;
	@Resource(name = ServiceNameSpaces.ACCOUNT)
	private AccountService accountService;

	public LogoutInterceptor() {
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv)
			throws Exception {
		Object obj = mv.getModel().get("cookie");
		Cookie cookie = obj != null ? obj instanceof Cookie ? (Cookie) obj : null : null;
		obj = mv.getModel().get("session");
		HttpSession sess = obj != null ? obj instanceof HttpSession ? (HttpSession) obj : null : null;
		AccountDTO dto = sess != null ? accountUtil.loginChekc(sess.getAttribute("login")) : null;
		System.out.println("sds:" + dto);
		System.out.println("sds:" + cookie);
		String jsession = null;
		if (dto != null) {
			jsession = dto.getA_jsession_id();
		}
		if (sess != null) {
			try {
				if (jsession == null || dto == null && cookie == null) {
					throw new AutoLoginOffException();
				}
				accountService.remove(dto);
				accountUtil.cookieDelete(response, cookie);
			} catch (AutoLoginOffException e) {
			} finally {
				sess.invalidate();
				mv.setViewName("redirect:/");
			}
		}
		super.postHandle(request, response, handler, mv);
	}

}
