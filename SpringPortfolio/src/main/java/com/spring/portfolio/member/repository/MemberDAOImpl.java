package com.spring.portfolio.member.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.portfolio.common.namespace.NameSpace;
import com.spring.portfolio.common.vo.DuplicateVO;
import com.spring.portfolio.common.vo.SearchVO;
import com.spring.portfolio.member.model.MemberDTO;

@Repository(value = "memberDAO")
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private SqlSession sqlSession;

	public MemberDAOImpl() {
	}

	@Override
	public int insert(MemberDTO dto) throws Exception {
		return sqlSession.insert(NameSpace.MEMBER + "insert", dto);

	}

	@Override
	public MemberDTO read(String m_id) throws Exception {
		return sqlSession.selectOne(NameSpace.MEMBER + "read", m_id);
	}

	@Override
	public int update(MemberDTO dto) throws Exception {
		return sqlSession.update(NameSpace.MEMBER + "update", dto);
	}

	@Override
	public int delete(String m_id) throws Exception {
		return sqlSession.delete(NameSpace.MEMBER + "delete", m_id);
	}

	@Override
	public List<Object> list(Map<String, Object> map) throws Exception {
		return sqlSession.selectList(NameSpace.MEMBER + "list", map);
	}

	@Override
	public MemberDTO duplicate(DuplicateVO vo) throws Exception {

		return sqlSession.selectOne(NameSpace.MEMBER + "duplicate", vo);
	}

	@Override
	public int allRow() throws Exception {
		return sqlSession.selectOne(NameSpace.MEMBER + "allrow");
	}
}
