package com.spring.portfolio.paging.repository;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.spring.portfolio.common.namespace.NameSpaces;


@Repository("pagingDAO")
public class PagingDAOImpl implements PagingDAO {
	@Autowired
	private SqlSession sqlSession;
	@Value(NameSpaces.PAGING)
	private String ns;
	public PagingDAOImpl() {
	}

	@Override
	public int getAmmount(Map<String, Object> map) throws Exception {
		return sqlSession.selectOne(ns + "amount", map);
	}

}
