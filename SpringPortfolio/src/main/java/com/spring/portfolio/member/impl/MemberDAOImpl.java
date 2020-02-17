package com.spring.portfolio.member.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.portfolio.common.vo.DuplicateVO;
import com.spring.portfolio.member.model.MemberDTO;
import com.spring.portfolio.member.repository.MemberDAO;
@Repository
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String namespace = "com.spring.portfolio.member.";
	
	
	public MemberDAOImpl() {
	}


	@Override
	public int insert(MemberDTO dto) throws Exception {
		return sqlSession.insert(namespace+"insert", dto);
		
	}


	@Override
	public MemberDTO read(String m_id) throws Exception {
		return sqlSession.selectOne(namespace+"read",m_id);
	}


	@Override
	public int update(MemberDTO dto) throws Exception {
		return sqlSession.update(namespace+"update",dto);
	}


	@Override
	public int delete(String m_id) throws Exception {
		return sqlSession.delete(namespace+"delete", m_id);
	}


	@Override
	public List<MemberDTO> list() throws Exception {
		return sqlSession.selectList(namespace+"list");
	}

 
	@Override
	public boolean duplicate(DuplicateVO vo) throws Exception {
		return sqlSession.selectOne(namespace+"duplicate",vo);
	}
	

}
