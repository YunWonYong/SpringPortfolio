package com.spring.portfolio.member.repository;

import java.util.List;

import com.spring.portfolio.common.util.UtilityCommand;
import com.spring.portfolio.common.vo.DuplicateVO;
import com.spring.portfolio.common.vo.SearchVO;
import com.spring.portfolio.member.model.MemberDTO;

public interface MemberDAO extends UtilityCommand{
	
	public abstract int insert(MemberDTO dto)throws Exception;
	
	public abstract MemberDTO read(String m_id)throws Exception;
	
	public abstract int update(MemberDTO dto)throws Exception;
	
	public abstract int delete(String m_id)throws Exception;
	
	public abstract List<Object> list()throws Exception;

	public abstract List<Object> searchList(SearchVO searchVO)throws Exception;

	public abstract MemberDTO duplicate(DuplicateVO vo)throws Exception;

}
