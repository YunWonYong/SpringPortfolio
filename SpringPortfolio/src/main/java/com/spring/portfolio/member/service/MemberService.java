package com.spring.portfolio.member.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.spring.portfolio.common.vo.DuplicateVO;
import com.spring.portfolio.member.model.MemberDTO;
import com.spring.portfolio.service.MainService;

public interface MemberService extends MainService {
	public abstract ModelAndView register(ModelAndView mv) throws Exception;

	public abstract MemberDTO getOne(String id) throws Exception;

	public abstract boolean modify(String id) throws Exception;
	
	public abstract List<MemberDTO> allList()throws Exception; 
	
	public abstract boolean checkDuplicate(DuplicateVO vo) throws Exception;
}
