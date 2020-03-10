package com.spring.portfolio.account.service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.spring.portfolio.account.model.AccountDTO;
import com.spring.portfolio.account.repository.AccountDAO;
import com.spring.portfolio.common.util.member.MemberUtility;
import com.spring.portfolio.member.model.MemberDTO;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
	@Resource(name = "accountDAO")
	private AccountDAO dao;

	public AccountServiceImpl() {
	}

	@Override
	public void transaction() throws Exception {
	}

	@Override
	public AccountDTO login(AccountDTO dto) throws Exception {
		String autoLogin = dto.getAutoLogin();
		dto = dao.login(dto);
		dto.setAutoLogin(autoLogin); 
		dto.setM_grant(new MemberUtility().getGender(dto.getM_grant().charAt(0)));
		return dto;
	}

	@Override
	public AccountDTO getOne(String jsessionID) throws Exception {
		return dao.read(jsessionID);
	}

	@Override
	public void register(AccountDTO dto) throws Exception {
		dao.insert(dto);
	}
	
}
