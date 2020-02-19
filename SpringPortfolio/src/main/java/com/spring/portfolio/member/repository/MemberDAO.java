package com.spring.portfolio.member.repository;

import java.util.List;

import com.spring.portfolio.common.vo.DuplicateVO;
import com.spring.portfolio.member.model.MemberDTO;

public interface MemberDAO {
	
	public abstract int insert(MemberDTO dto)throws Exception;
	
	public abstract MemberDTO read(String m_id)throws Exception;
	
	public abstract int update(MemberDTO dto)throws Exception;
	
	public abstract int delete(String m_id)throws Exception;
	
	public abstract List<MemberDTO> list()throws Exception;

	public abstract MemberDTO duplicate(DuplicateVO vo)throws Exception;
}
