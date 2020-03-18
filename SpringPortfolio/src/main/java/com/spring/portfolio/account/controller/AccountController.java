package com.spring.portfolio.account.controller;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.portfolio.account.model.AccountDTO;
import com.spring.portfolio.account.service.AccountService;
import com.spring.portfolio.common.namespaces.ControllerNameSpaces;
import com.spring.portfolio.common.namespaces.ServiceNameSpaces;

@Controller
@RequestMapping(ControllerNameSpaces.ACCOUNT)
public class AccountController {
	@Resource(name = ServiceNameSpaces.ACCOUNT)
	private AccountService accountService;

	@RequestMapping("login_form")
	public ModelAndView login(ModelAndView mv) {
		mv.setViewName("/account/login");
		return mv;
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView login(ModelAndView mv, AccountDTO dto) throws Exception {
		mv.addObject("dto", accountService.login(dto));
		mv.addObject("m_id", dto.getM_id());
		return mv;
	}

	@RequestMapping("logout")
	public ModelAndView logout(ModelAndView mv) {
		return mv;
	}
}
