package com.spring.portfolio.member.controller;

import java.net.URLDecoder;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.portfolio.account.model.AccountDTO;
import com.spring.portfolio.common.exception.ListSwitch;
import com.spring.portfolio.common.namespaces.ControllerNameSpaces;
import com.spring.portfolio.common.namespaces.ServiceNameSpaces;
import com.spring.portfolio.common.namespaces.UtilNameSpaces;
import com.spring.portfolio.common.util.json.JsonParsing;
import com.spring.portfolio.common.util.member.MemberUtility;
import com.spring.portfolio.common.util.sql.SqlMultiObject;
import com.spring.portfolio.common.vo.DuplicateVO;
import com.spring.portfolio.common.vo.PagingVO;
import com.spring.portfolio.common.vo.SearchVO;
import com.spring.portfolio.member.model.MemberDTO;
import com.spring.portfolio.member.model.MemberVO;
import com.spring.portfolio.member.service.MemberService;

@Controller
@RequestMapping(ControllerNameSpaces.MEMBER)
public class MemberController {
	@Resource(name = ServiceNameSpaces.MEMBER)
	private MemberService memberService;
	@Resource(name = UtilNameSpaces.MEMBER)
	private MemberUtility memberUtil;

	public MemberController() {
	}

	@RequestMapping("insert")
	public ModelAndView insert(ModelAndView mv) throws Exception {
		mv.addObject("util", memberUtil.getBirth());
		mv.setViewName("/member/insert/회원가입");
		return mv;
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public ModelAndView insert(MemberDTO dto, MemberVO vo, ModelAndView mv) throws Exception {
		dto.setM_gender(memberUtil.setGender(vo.getGenderCheck()));
		dto.setM_age(memberUtil.getAge(vo.getYear()));
		dto.setM_birth(vo.getBirth());
		memberService.register(dto);
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
		AccountDTO adto = null;
		MemberDTO dto = null;
		try {
			if (id == null) {
				Object obj = request.getSession(false).getAttribute("login");
				if (obj instanceof AccountDTO)
					adto = (AccountDTO) obj;
				if (adto == null)
					throw new Exception();
				id = adto.getM_id();
			}
			dto = memberService.getOne(id);
			dto.setM_realGender(memberUtil.getGender(dto.getM_gender()));
			dto.setM_realGrant(memberUtil.getGrant(dto.getM_grant()));
			dto.setM_birth(dto.getM_birth().split(" ")[0]);
			dto.setM_registdate(dto.getM_registdate().split(" ")[0]);
			mv.setViewName("/member/read/회원조회");
		} catch (Exception e) {
			mv.setViewName("/error/fail");
		} finally {
			mv.addObject("dto", dto);
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
			list = memberService.allList(SqlMultiObject.add(new PagingVO("m_index", "portfolio_member", currentPage), searchVO));
			result = list != null ? new JsonParsing().parsingList(list) : null;
		}
		return result;
	}

	@RequestMapping("list")
	public ModelAndView list(ModelAndView mv) {
		mv.setViewName("/member/list/회원목록");
		return mv;
	}

	@RequestMapping("update/{key}")
	public ModelAndView updateui(@PathVariable String key, ModelAndView mv, HttpServletRequest request) {
		Object obj = request.getSession().getAttribute("login");
		AccountDTO adto = null;
		String inputElement = null;
		try {
			adto = obj instanceof AccountDTO ? (AccountDTO) obj : null;
			if (adto == null) {
				throw new Exception();
			}
			inputElement = memberUtil.setUpdateForm(key, memberService.getOne(adto.getM_id()));
			mv.addObject("input", inputElement); 
			mv.addObject("title", memberUtil.getLogo(key));
			mv.setViewName("/member/update/회원수정");
		} catch (Exception e) {
			mv.setViewName("/error/fail");
		} finally {

		}
		return mv;
	}
}
