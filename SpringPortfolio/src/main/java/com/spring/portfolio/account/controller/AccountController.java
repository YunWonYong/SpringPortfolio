package com.spring.portfolio.account.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.portfolio.account.model.AccountDTO;
import com.spring.portfolio.account.service.AccountService;

@Controller
@RequestMapping("account")
public class AccountController {
	@Resource(name = "accountService")
	private AccountService accountService;

	@RequestMapping("login")
	public ModelAndView login(ModelAndView mv) {
		mv.setViewName("account/account_login");
		return mv;
	}

	@RequestMapping(value="login",method = RequestMethod.POST)
	public ModelAndView login(ModelAndView mv, AccountDTO dto,HttpServletRequest request,HttpServletResponse response) {
		mv.addObject("request",request);
		mv.addObject("response", response);
		mv.addObject("dto",	dto);
		try { 
			if(!accountService.login(mv)) {
				throw new Exception();
			}
			request.getSession().setAttribute("test","TESt");
			mv.setViewName("redirect:/");
		} catch (Exception e) {
			mv.clear();
			mv.addObject("m_id", dto.getM_id());
			mv.addObject("msg","아이디와 비빌번호를 확인해 주세요.");
			mv.setViewName("/account/account_login");
		}
		return mv;
	}
}
