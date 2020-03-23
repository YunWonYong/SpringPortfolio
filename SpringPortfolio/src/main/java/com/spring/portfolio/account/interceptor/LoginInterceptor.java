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
import com.spring.portfolio.common.exception.account.LoginFailException;
import com.spring.portfolio.common.namespaces.ServiceNameSpaces;
import com.spring.portfolio.common.namespaces.UtilNameSpaces;
import com.spring.portfolio.common.util.account.AccountUtility;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	@Resource(name = ServiceNameSpaces.ACCOUNT)
	private AccountService accountService;
	@Resource(name = UtilNameSpaces.ACCOUN)
	private AccountUtility accountUtil;

	public LoginInterceptor() {
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv)
			throws Exception {
		AccountDTO dto = null;
		try {
			dto = accountUtil.loginCheck(mv.getModel().get("dto"));
			if (dto == null)
				throw new LoginFailException();
			HttpSession sess = request.getSession();
			sess.setAttribute("login", dto); 
			System.out.println("interceptor:"+dto.getM_grant()); 
			String jsessionID = accountUtil.injectJsessionID(request.getCookies(), dto.getA_autologin_check());
			if (jsessionID != null) {
				dto.setA_holding_time(accountUtil.getHoldingTime());
				dto.setA_jsession_id(jsessionID);
				accountService.register(dto);
				Cookie cookie = new Cookie("a_jsession_id", dto.getA_jsession_id());
				cookie.setPath("/");
				cookie.setMaxAge(24 * 60 * 60);
				response.addCookie(cookie);
			}
			mv.clear();
			mv.setViewName("redirect:/");
		} catch (Exception e) {
			mv.addObject("msg", "아이디와 비빌번호를 확인해 주세요.");
			mv.setViewName("/account/login/로그인");
		} finally {
			super.postHandle(request, response, handler, mv);
		}

	}

}
