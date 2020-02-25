package com.spring.portfolio.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.portfolio.common.util.member.MemberUtility;
import com.spring.portfolio.common.vo.DuplicateVO;
import com.spring.portfolio.member.model.MemberDTO;
import com.spring.portfolio.member.model.MemberVO;
import com.spring.portfolio.member.service.MemberService;

@Controller
@RequestMapping("member")
public class MemberController {

	@Resource(name = "memberService")
	private MemberService memberService;
	@Resource(name = "memberUtil")
	private MemberUtility util;

	public MemberController() {
	}

	@RequestMapping("insert")
	public ModelAndView insert(ModelAndView mv) throws Exception {
		mv.addObject("util", util.getBirth());
		mv.setViewName("member/member_insert_form");
		return mv;
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public ModelAndView insert(MemberDTO dto,MemberVO vo, ModelAndView mv) throws Exception {
		mv.addObject("dto",dto);
		mv.addObject("vo", vo);
		memberService.register(mv);
		mv.setViewName("redirect:/");
		return mv;
	}

	@RequestMapping(value = "duplicate", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String duplicate(DuplicateVO vo)throws Exception {
		return memberService.checkDuplicate(vo);
	}

	@RequestMapping("read")
	public ModelAndView read(String id, ModelAndView mv) {
		MemberDTO dto = null;
		try {
			dto = memberService.getOne(id);
			if (dto == null)
				throw new Exception();
			mv.addObject("dto", dto);
			mv.setViewName("member/member_read");
		} catch (Exception e) {
			mv.setViewName("fail");
		}
		return mv;
	}
}
