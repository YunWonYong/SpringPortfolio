package com.spring.portfolio.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.spring.portfolio.common.vo.DuplicateVO;
import com.spring.portfolio.member.model.MemberDTO;
import com.spring.portfolio.member.repository.MemberDAO;
import com.spring.portfolio.member.service.MemberService;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO dao;
	
	public MemberServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void transaction() throws Exception {
	}

	@Override
	public ModelAndView register(ModelAndView mv) throws Exception {
		MemberDTO dto =(MemberDTO)mv.getModel().get("dto");
		if(dao.insert(dto)!=0) {
			mv.setViewName("redirect:continu/fail");
			transaction();
		}
		mv.setViewName("redirect:account/login");
		return mv;
	}

	@Override
	public MemberDTO getOne(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modify(String id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<MemberDTO> allList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkDuplicate(DuplicateVO vo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
