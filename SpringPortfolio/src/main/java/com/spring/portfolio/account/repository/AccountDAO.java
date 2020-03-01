package com.spring.portfolio.account.repository;

import com.spring.portfolio.account.model.AccountDTO;
import com.spring.portfolio.member.model.MemberDTO;

public interface AccountDAO{
	public abstract MemberDTO login(AccountDTO dto)throws Exception;
}
