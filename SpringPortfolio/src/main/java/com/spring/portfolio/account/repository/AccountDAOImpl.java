package com.spring.portfolio.account.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.spring.portfolio.account.model.AccountDTO;
import com.spring.portfolio.common.namespaces.MapperNameSpaces;
import com.spring.portfolio.common.namespaces.RepositoryNameSpaces;

@Repository(RepositoryNameSpaces.ACCOUNT)
public class AccountDAOImpl implements AccountDAO {
	@Autowired
	private SqlSession sqlSession;
	@Value(MapperNameSpaces.ACCOUNT)
	private String ns;

	public AccountDAOImpl() {
	}

	@Override
	public AccountDTO login(AccountDTO dto) throws Exception {
		return sqlSession.selectOne(ns + "login", dto);
	}

	@Override
	public AccountDTO read(String a_jsession_id) throws Exception {
		return sqlSession.selectOne(ns + "autologin", a_jsession_id);
	}

	@Override
	public void insert(AccountDTO dto) throws Exception {
		sqlSession.insert(ns + "insert", dto);

	}

	@Override
	public int delete(AccountDTO dto) throws Exception {
		return sqlSession.delete(ns + "delete", dto);
	}

	@Override
	public int update(AccountDTO dto) throws Exception {
		return sqlSession.update(ns + "update", dto);
	}

}
