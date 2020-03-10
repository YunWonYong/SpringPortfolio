package com.spring.portfolio.index.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutoLoginCheckInterceptor extends HandlerInterceptorAdapter {

	public AutoLoginCheckInterceptor() {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				System.out.print("cookieName:"+cookie.getName()+"\t"); 
				System.out.print("cookieValue:"+cookie.getValue()+"\t");
				System.out.println("cookieMaxAge:"+cookie.getMaxAge());
			} 
		}
		return true;
	}
}
