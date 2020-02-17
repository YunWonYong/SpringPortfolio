package com.spring.portfolio.member;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.portfolio.member.model.MemberDTO;
import com.spring.portfolio.member.service.MemberService;

@Controller
@RequestMapping("member")
public class MemberController {
	@Resource(name="memberService")
	private MemberService memberService;
	
	public MemberController() {
	}
	
	@RequestMapping("insert")
	public void insert()throws Exception{
		 
	}
	@RequestMapping(value="insert" , method = RequestMethod.POST)
	public ModelAndView insert(MemberDTO dto) throws Exception{
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	@RequestMapping("read")
	public ModelAndView read(String id)throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberDTO dto = null;
		try {
			dto = memberService.getOne(id);
			if(dto==null)throw new Exception();
			mv.addObject("dto", dto);
			mv.setViewName("member/member_read");
		} catch (Exception e) {
			mv.setViewName("fail");
		}
		return mv;
	}
}
