package com.spring.portfolio.member.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.spring.portfolio.common.vo.DuplicateVO;
import com.spring.portfolio.member.model.MemberDTO;

@Repository(value = "memberDAO")
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private SqlSession sqlSession;
	@Value("#{namespace['member.namespace']}")
	private final String NAMESPACE;

	public MemberDAOImpl() {
		NAMESPACE=null;
	}

	@Override
	public int insert(MemberDTO dto) throws Exception {
		return sqlSession.insert(NAMESPACE+ "insert", dto);

	}

	@Override
	public MemberDTO read(String m_id) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "read", m_id);
	}
 
	@Override
	public int update(MemberDTO dto) throws Exception {
		return sqlSession.update(NAMESPACE + "update", dto);
	}

	@Override
	public int delete(String m_id) throws Exception {
		return sqlSession.delete(NAMESPACE + "delete", m_id);
	}

	@Override
	public List<Object> list(Map<String, Object> map) throws Exception {
		return sqlSession.selectList(NAMESPACE + "list", map);
	}

	@Override
	public MemberDTO duplicate(DuplicateVO vo) throws Exception {

		return sqlSession.selectOne(NAMESPACE + "duplicate", vo);
	}
 
}
