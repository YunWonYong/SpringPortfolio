package com.spring.portfolio.account.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.portfolio.account.model.AccountDTO;
import com.spring.portfolio.member.model.MemberDTO;
@Repository("accountDAO")
public class AccountDAOImpl implements AccountDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE ="com.spring.portfolio.account.";
	public AccountDAOImpl() {
	}
	@Override
	public MemberDTO login(AccountDTO dto) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"login",dto);
	}

}
