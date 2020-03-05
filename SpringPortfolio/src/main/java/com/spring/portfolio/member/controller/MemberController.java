package com.spring.portfolio.member.controller;

import java.net.URLDecoder;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.portfolio.common.exception.ListSwitch;
import com.spring.portfolio.common.util.json.JsonParsing;
import com.spring.portfolio.common.util.member.MemberUtility;
import com.spring.portfolio.common.vo.DuplicateVO;
import com.spring.portfolio.common.vo.SearchVO;
import com.spring.portfolio.common.vo.TargetAndValueAbstractVO;
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
		mv.setViewName("/member/insert");
		return mv; 
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public ModelAndView insert(MemberDTO dto, MemberVO vo, ModelAndView mv) throws Exception {
		mv.addObject("dto", dto);
		mv.addObject("vo", vo);
		memberService.register(mv);
		mv.setViewName("redirect:/");
		return mv;
	}

	@RequestMapping(value = "duplicate", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String duplicate(DuplicateVO vo) throws Exception {
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
			mv.setViewName("/member/read");
		} catch (Exception e) {
			mv.setViewName("fail");
		}
		return mv;
	}
	@RequestMapping(value = "view/list" ,produces = "application/text; charset=utf8")
	@ResponseBody
	public String viewList(String target, String content) throws Exception{
		List<Object> list = null;
		Object value = null;
		try {
			if(target.equals("null") && content.equals("null")) {
				throw new ListSwitch();
			}
			content = URLDecoder.decode(content,"UTF-8").split("\\=")[1];
			content =new MemberUtility().searchContentParse(target,content);
			System.out.println(content); 
			value =  target.equals("m_index")?Integer.parseInt(content):content;
			list = memberService.searchList(new SearchVO(target,value));
		} catch (ListSwitch e) {
			list = memberService.allList();
		}finally {
			if(list!=null) {
				return new JsonParsing().parsingList(list);
			}
		}
		return "회원을 조회할수 없습니다.";
	}
	
	@RequestMapping("list")
	public ModelAndView list(ModelAndView mv) {
		mv.setViewName("/member/list");
		return mv;
	}
}
