package com.spring.portfolio.paging.repository;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;


@Repository("pagingDAO")
public class PagingDAOImpl implements PagingDAO {
	@Autowired
	private SqlSession sqlSession;
	@Value("#{namespace['paging.namespace']}")
	private final String NAMESPACE;
	public PagingDAOImpl() {
		NAMESPACE=null;
	}

	@Override
	public int getAmmount(Map<String, Object> map) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "amount", map);
	}

}
