package com.spring.portfolio.account.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.portfolio.account.repository.AccountDAO;
import com.spring.portfolio.account.service.AccountService;
@Service("accountService")
public class AccountServiceImpl implements AccountService {
	@Inject
	private AccountDAO dao;	
	public AccountServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void transaction() throws Exception {
	}

}
