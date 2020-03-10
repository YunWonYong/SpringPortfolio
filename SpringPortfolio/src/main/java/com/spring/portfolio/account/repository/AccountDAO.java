package com.spring.portfolio.account.repository;

import com.spring.portfolio.account.model.AccountDTO;
public interface AccountDAO{
	public abstract AccountDTO login(AccountDTO dto)throws Exception;

	public abstract AccountDTO read(String jsessionID)throws Exception;

	public abstract void insert(AccountDTO dto)throws Exception;
}
