package com.spring.portfolio.member.repository;

import java.util.List;
import java.util.Map;

import com.spring.portfolio.account.model.AccountDTO;
import com.spring.portfolio.common.util.Utility;
import com.spring.portfolio.common.vo.DuplicateVO;
import com.spring.portfolio.member.model.MemberDTO;

public interface MemberDAO extends Utility {

	public abstract boolean insert(MemberDTO dto) throws Exception;

	public abstract MemberDTO read(String m_id) throws Exception;

	public abstract boolean update(MemberDTO dto) throws Exception;

	public abstract boolean delete(AccountDTO dto) throws Exception;

	public abstract List<Object> list(Map<String, Object> map) throws Exception;

	public abstract MemberDTO duplicate(DuplicateVO vo) throws Exception;

}
