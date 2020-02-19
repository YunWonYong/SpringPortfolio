package com.spring.portfolio.member.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.portfolio.common.util.member.MemberUtility;
import com.spring.portfolio.common.vo.DuplicateVO;
import com.spring.portfolio.member.model.MemberDTO;
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
	public ModelAndView insert(MemberDTO dto, ModelAndView mv) throws Exception {
		return mv;
	}

	@RequestMapping(value = "duplicate", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String duplicate(DuplicateVO vo) {
		StringBuffer result = new StringBuffer();
		boolean flag =false;
		result.append(vo.getTarget().equals("m_id") ? "#idcheck" : "#nicknamecheck");
		result.append(",");
		String msg = vo.getTarget().equals("m_id") ? "아이디" : "닉네임";
		try {
			flag = memberService.checkDuplicate(vo);
			if (!flag)
				throw new Exception();
			result.append("사용하셔도 좋은 ");
			result.append(msg);
			result.append(" 입니다.");
		} catch (Exception e) {
			result.append("사용중인 ");
			result.append(msg);
			result.append(" 입니다.");
		}finally {
			result.append(",");
			result.append(!flag?"0":"1");
			
		}
		return result.toString();

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
