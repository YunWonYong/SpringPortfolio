package com.spring.portfolio.account.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.spring.portfolio.account.model.AccountDTO;
import com.spring.portfolio.account.repository.AccountDAO;
import com.spring.portfolio.common.namespaces.RepositoryNameSpaces;
import com.spring.portfolio.common.namespaces.ServiceNameSpaces;
import com.spring.portfolio.common.util.member.MemberUtility;

@Service(ServiceNameSpaces.ACCOUNT)
public class AccountServiceImpl implements AccountService {
	@Resource(name = RepositoryNameSpaces.ACCOUNT)
	private AccountDAO dao;

	public AccountServiceImpl() {
	}

	@Override
	public void transaction() throws Exception {
	}

	@Override
	public AccountDTO login(AccountDTO dto) throws Exception {
		String autoChekc = dto.getA_autologin_check() == null ? "off" : "on";
		dto = dao.login(dto);
		if (dto != null) {
			dto.setA_autologin_check(autoChekc);
			dto.setM_grant(new MemberUtility().getGrant(dto.getM_grant().charAt(0)));
		}
		return dto;
	}

	@Override
	public AccountDTO getOne(String a_jsession_id) throws Exception {
		return dao.read(a_jsession_id);
	}

	@Override
	public void register(AccountDTO dto) throws Exception {
		dao.insert(dto);
	}

	@Override
	public int remove(AccountDTO dto) throws Exception {
		return dao.delete(dto) == 1 ? 2 : 0;
	}

	@Override
	public int modify(AccountDTO dto) throws Exception {
		return dao.update(dto);
	}

}
