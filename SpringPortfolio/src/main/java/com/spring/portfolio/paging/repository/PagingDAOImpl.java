package com.spring.portfolio.paging.repository;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.portfolio.common.namespace.NameSpace;

@Repository("pagingDAO")
public class PagingDAOImpl implements PagingDAO {
	@Autowired
	private SqlSession sqlSession;

	public PagingDAOImpl() {
	}

	@Override
	public int getAmmount(Map<String, Object> map) throws Exception {
		return sqlSession.selectOne(NameSpace.PAGING + "amount", map);
	}

}
