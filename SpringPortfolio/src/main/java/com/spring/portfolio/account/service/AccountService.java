package com.spring.portfolio.account.service;

import com.spring.portfolio.account.model.AccountDTO;
import com.spring.portfolio.service.MainService;

public interface AccountService extends MainService {

	public abstract boolean login(AccountDTO dto)throws Exception;

}
