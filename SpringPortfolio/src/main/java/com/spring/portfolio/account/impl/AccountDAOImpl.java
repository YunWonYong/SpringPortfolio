package com.spring.portfolio.account.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.portfolio.account.repository.AccountDAO;
@Repository
public class AccountDAOImpl implements AccountDAO {
	@Autowired
	private SqlSession sqlSession;
	public AccountDAOImpl() {
		// TODO Auto-generated constructor stub
	}

}
