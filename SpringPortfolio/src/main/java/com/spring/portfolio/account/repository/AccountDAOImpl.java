package com.spring.portfolio.account.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.portfolio.account.model.AccountDTO;
import com.spring.portfolio.common.namespace.NameSpace;
import com.spring.portfolio.member.model.MemberDTO;

@Repository("accountDAO")
public class AccountDAOImpl implements AccountDAO {
	@Autowired
	private SqlSession sqlSession;

	public AccountDAOImpl() {
	}

	@Override
	public MemberDTO login(AccountDTO dto) throws Exception {
		return sqlSession.selectOne(NameSpace.ACCOUNT + "login", dto);
	}

}
