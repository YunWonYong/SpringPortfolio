package com.spring.portfolio.account.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.portfolio.account.service.AccountService;

@Controller
@RequestMapping("account")
public class AccountController {
	@Resource(name="accountService")
	private  AccountService accountService;

}
