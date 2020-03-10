package com.spring.portfolio.account.service;


import com.spring.portfolio.account.model.AccountDTO;
import com.spring.portfolio.service.MainService;

public interface AccountService extends MainService {

	public abstract AccountDTO login(AccountDTO dto) throws Exception;

	public abstract AccountDTO getOne(String jsessionID)throws Exception ;

	public abstract void register(AccountDTO dto)throws Exception;

}
