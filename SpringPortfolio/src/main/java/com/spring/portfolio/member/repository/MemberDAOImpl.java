package com.spring.portfolio.member.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.spring.portfolio.account.model.AccountDTO;
import com.spring.portfolio.common.namespaces.MapperNameSpaces;
import com.spring.portfolio.common.namespaces.RepositoryNameSpaces;
import com.spring.portfolio.common.vo.DuplicateVO;
import com.spring.portfolio.member.model.MemberDTO;

@Repository(value = RepositoryNameSpaces.MEMBER)
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private SqlSession sqlSession;
	@Value(MapperNameSpaces.MEMBER)
	private String ns;

	public MemberDAOImpl() {
	}

	@Override
	public boolean insert(MemberDTO dto) throws Exception {
		return sqlSession.insert(ns + "insert", dto) == 1;

	}

	@Override
	public MemberDTO read(String m_id) throws Exception {
		return sqlSession.selectOne(ns + "read", m_id);
	}

	@Override
	public boolean update(MemberDTO dto) throws Exception {
		return sqlSession.update(ns + "update", dto) == 1;
	}

	@Override
	public boolean delete(AccountDTO dto) throws Exception {
		return sqlSession.delete(ns + "delete", dto) == 1;
	}

	@Override
	public List<Object> list(Map<String, Object> map) throws Exception {
		return sqlSession.selectList(ns + "list", map);
	}

	@Override
	public MemberDTO duplicate(DuplicateVO vo) throws Exception {

		return sqlSession.selectOne(ns + "duplicate", vo);
	}

	@Override
	public MemberDTO passwordCheck(MemberDTO dto) throws Exception {
		return sqlSession.selectOne(ns+"passwordCheck",dto);
	}

}
