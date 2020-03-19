package com.spring.portfolio.certification.repository;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.spring.portfolio.certification.model.CertificationDTO;
import com.spring.portfolio.common.namespaces.MapperNameSpaces;
import com.spring.portfolio.common.namespaces.RepositoryNameSpaces;

@Repository(RepositoryNameSpaces.CERTIFICATION)
public class CertificationDAOImpl implements CertificationDAO {
	@Inject
	private SqlSession sqlSession;
	@Value(MapperNameSpaces.CERTIFICATION)
	private String ns;

	public CertificationDAOImpl() {
	}

	@Override
	public void insert(CertificationDTO dto) throws Exception {
		sqlSession.insert(ns + "insert", dto);
	}

	@Override
	public CertificationDTO read(CertificationDTO dto) throws Exception {
		return sqlSession.selectOne(ns + "read", dto);
	}

	@Override
	public boolean check(CertificationDTO dto) throws Exception {
		return sqlSession.update(ns + "check", dto) != 0;
	}

}
