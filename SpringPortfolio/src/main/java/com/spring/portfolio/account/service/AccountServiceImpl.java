package com.spring.portfolio.account.service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.spring.portfolio.account.model.AccountDTO;
import com.spring.portfolio.account.repository.AccountDAO;
import com.spring.portfolio.member.model.MemberDTO;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
	@Resource(name = "accountDAO")
	private AccountDAO dao;

	public AccountServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void transaction() throws Exception {
	}

	@Override
	public boolean login(ModelAndView mv) throws Exception {
		boolean flag = false;
		try {
			System.out.println("call");
			ModelMap map = mv.getModelMap();
			HttpServletRequest request = (HttpServletRequest) map.get("request");
			HttpServletResponse response = (HttpServletResponse) map.get("response");
			AccountDTO dto = (AccountDTO) map.get("dto");
			MemberDTO login = dao.login(dto); 
			System.out.println(dto.getAutoLogin());
			System.out.println(login);
			if(login!=null) {
				request.getSession().setAttribute("login", login);
				System.out.println(((MemberDTO)request.getSession().getAttribute("login")).getM_id()); 
				if(dto.getAutoLogin()!=null) {
//				Cookie cookie = new Cookie("asd",dto.getM_id());
//				cookie.setPath("/");
//				cookie.setMaxAge(60*60);
//				response.addCookie(cookie);
				}
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(flag);
		return flag;
	}

}
