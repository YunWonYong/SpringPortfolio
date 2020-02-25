package com.spring.portfolio.member.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.spring.portfolio.common.util.member.MemberUtility;
import com.spring.portfolio.common.vo.DuplicateVO;
import com.spring.portfolio.member.model.MemberDTO;
import com.spring.portfolio.member.model.MemberVO;
import com.spring.portfolio.member.repository.MemberDAO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	@Resource(name = "memberDAO")
	private MemberDAO dao;
	@Resource(name = "memberUtil")
	private MemberUtility util;

	public MemberServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void transaction() throws Exception {
	}

	@Override
	public ModelAndView register(ModelAndView mv) throws Exception {
		MemberDTO dto = (MemberDTO) mv.getModel().get("dto");
		MemberVO vo = (MemberVO)mv.getModel().get("vo");
		dto.setM_gender(util.setGender(vo.getGenderCheck()));
		dto.setM_age(util.getAge(vo.getYear()));
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
	public String checkDuplicate(DuplicateVO vo) throws Exception {
		return util.booleanTransform(dao.duplicate(vo))?"true":"false";
	}

}
