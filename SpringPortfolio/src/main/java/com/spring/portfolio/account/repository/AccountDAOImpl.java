package com.spring.portfolio.account.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.spring.portfolio.account.model.AccountDTO;

@Repository("accountDAO")
public class AccountDAOImpl implements AccountDAO {
	@Autowired
	private SqlSession sqlSession;
	@Value("#{namespace['account.namespace']}")
	private final String NAMESPACE;

	public AccountDAOImpl() {
		NAMESPACE = null;
	}

	@Override
	public AccountDTO login(AccountDTO dto) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "login", dto);
	}

	@Override
	public AccountDTO read(String jsessionID) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "autologin", jsessionID);
	}

	@Override
	public void insert(AccountDTO dto) throws Exception {
		System.out.println(NAMESPACE + "insert");
		sqlSession.insert(NAMESPACE + "insert", dto);

	}

}
