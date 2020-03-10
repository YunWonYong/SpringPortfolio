package com.spring.portfolio.account.interceptor;

import java.util.Calendar;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.spring.portfolio.account.model.AccountDTO;
import com.spring.portfolio.account.service.AccountService;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter {
	@Resource(name = "accountService")
	private AccountService accountService;

	public LoginCheckInterceptor() {
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv)
			throws Exception {
		mv.setViewName("/account/login");
		Object obj = mv.getModel().get("dto");
		if (obj != null ? obj instanceof AccountDTO : false) {
			AccountDTO dto = (AccountDTO) obj;
			HttpSession sess = request.getSession();
			sess.setAttribute("login", dto);
			if (dto.getAutoLogin().equals("on")) {
				Cookie[] cookies = request.getCookies();
				if (cookies != null) {
					Calendar c = Calendar.getInstance();
					int holdingTime = Integer.parseInt(String.valueOf(c.getTimeInMillis()).substring(0, 7));
					dto.setA_holding_time(holdingTime+(60*60*24));
					dto.setA_jsession_id(cookies[0].getValue());
					accountService.register(dto);
					Cookie cookie = new Cookie("jsession_id",cookies[0].getValue());
					cookie.setPath("/"); 
					response.addCookie(cookie); 
					System.out.println("account interceptor jsession ID:"+cookies[0].getValue());
				}
			}
			mv.clear();
			mv.setViewName("redirect:/");

		}
		super.postHandle(request, response, handler, mv);
	}

}
