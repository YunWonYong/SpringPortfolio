package com.spring.portfolio.account.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.spring.portfolio.account.model.AccountDTO;
import com.spring.portfolio.common.namespace.NameSpaces;

@Repository("accountDAO")
public class AccountDAOImpl implements AccountDAO {
	@Autowired
	private SqlSession sqlSession;
	@Value(NameSpaces.ACCOUNT)
	private String ns;

	public AccountDAOImpl() {
	}

	@Override
	public AccountDTO login(AccountDTO dto) throws Exception {
		return sqlSession.selectOne(ns + "login", dto);
	}

	@Override
	public AccountDTO read(String jsessionID) throws Exception {
		return sqlSession.selectOne(ns + "autologin", jsessionID);
	}

	@Override
	public void insert(AccountDTO dto) throws Exception {
		sqlSession.insert(ns + "insert", dto);

	}

}
