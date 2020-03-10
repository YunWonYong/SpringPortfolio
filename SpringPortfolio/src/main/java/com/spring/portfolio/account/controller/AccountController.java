package com.spring.portfolio.account.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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

	@RequestMapping("login_form")
	public ModelAndView login(ModelAndView mv) {
		mv.setViewName("/account/login");
		return mv;
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView login(ModelAndView mv, AccountDTO dto) {
		System.out.println("autoLogin:"+dto.getAutoLogin());
		try {
			dto = accountService.login(dto);
			if (dto == null) {
				throw new Exception();
			}
			mv.addObject("dto", dto);
		} catch (Exception e) {
			mv.addObject("m_id", dto.getM_id());
			mv.addObject("msg", "아이디와 비빌번호를 확인해 주세요.");
		}
		return mv;
	}

	@RequestMapping("logout")
	public ModelAndView logout(ModelAndView mv, HttpSession sess) {
		if (sess.getAttribute("login") != null) {
			sess.invalidate();
		}
		mv.setViewName("redirect:/");
		return mv;
	}
}
