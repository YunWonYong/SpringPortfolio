package com.spring.portfolio.account.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.portfolio.account.model.AccountDTO;
import com.spring.portfolio.account.repository.AccountDAO;
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

	@Override
	public boolean login(AccountDTO dto) throws Exception {
		return false;
	}

}
