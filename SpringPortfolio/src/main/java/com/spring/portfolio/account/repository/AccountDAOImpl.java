package com.spring.portfolio.account.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class AccountDAOImpl implements AccountDAO {
	@Autowired
	private SqlSession sqlSession;
	public AccountDAOImpl() {
		// TODO Auto-generated constructor stub
	}

}
