package com.spring.portfolio.member.controller;

import java.net.URLDecoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.portfolio.common.exception.ListSwitch;
import com.spring.portfolio.common.util.json.JsonParsing;
import com.spring.portfolio.common.util.member.MemberUtility;
import com.spring.portfolio.common.util.sql.SqlMultiObject;
import com.spring.portfolio.common.vo.DuplicateVO;
import com.spring.portfolio.common.vo.PagingVO;
import com.spring.portfolio.common.vo.SearchVO;
import com.spring.portfolio.member.model.MemberDTO;
import com.spring.portfolio.member.model.MemberVO;
import com.spring.portfolio.member.service.MemberService;

import oracle.net.aso.s;

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
		dto.setM_gender(util.setGender(vo.getGenderCheck()));
		dto.setM_age(util.getAge(vo.getYear()));
		dto.setM_birth(vo.getBirth());
		String id = dto.getM_id();
		String nickname = dto.getM_nickname();
		for(int i =0; i < 30;i++) {
			dto.setM_id(id+i);
			dto.setM_nickname(nickname+i);
			memberService.register(dto);
		} 
		mv.setViewName("redirect:/"); 
		return mv;
	}

	@RequestMapping(value = "duplicate", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String duplicate(String target, String value) throws Exception {
		return memberService.checkDuplicate(new DuplicateVO(target, value));
	}

	@RequestMapping("read")
	public ModelAndView read(String id, ModelAndView mv, HttpServletRequest request) {
		MemberDTO dto = null;
		try {
			if (id == null) {
				Object obj = request.getSession(false).getAttribute("login");
				if (obj instanceof MemberDTO)
					dto = (MemberDTO) obj;
				if (dto == null)
					throw new Exception();
				id = dto.getM_id();
			}
			dto = memberService.getOne(id);
			dto.setM_realGender(util.getGender(dto.getM_gender()));
			dto.setM_realGrant(util.getGrant(dto.getM_grant()));
			dto.setM_birth(dto.getM_birth().split(" ")[0]);
			dto.setM_registdate(dto.getM_registdate().split(" ")[0]);
		} catch (Exception e) {
			mv.setViewName("fail");
		} finally {
			mv.addObject("dto", dto);
			mv.setViewName("/member/read");
		}
		return mv;
	}

	@RequestMapping(value = "view/list", produces = "application/text; charset=utf8")
	@ResponseBody
	public String viewList(String target, String content, int currentPage) throws Exception {
		List<Object> list = null;
		Object value = null;
		String result = null;
		SearchVO searchVO = null;
		try {
			if (target.equals("null") && content.equals("null")) {
				throw new ListSwitch();
			}
			content = URLDecoder.decode(content, "UTF-8").split("\\=")[1];
			content = new MemberUtility().searchContentParse(target, content);
			value = target.equals("m_index") ? Integer.parseInt(content) : content;
			searchVO = new SearchVO(target, value);
		} catch (ListSwitch e) {
			searchVO = new SearchVO(null, null);
		} finally {
			list = memberService
					.allList(SqlMultiObject.add(new PagingVO("m_index", "portfolio_member", currentPage), searchVO));
			result = list != null ? new JsonParsing().parsingList(list) : null;
		}

		return result;
		// return null;
	}

	@RequestMapping("list")
	public ModelAndView list(ModelAndView mv) {
		mv.setViewName("/member/list");
		return mv;
	}
}
