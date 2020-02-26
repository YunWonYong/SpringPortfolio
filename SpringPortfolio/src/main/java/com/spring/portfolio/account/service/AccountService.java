package com.spring.portfolio.account.service;

import org.springframework.web.servlet.ModelAndView;
import com.spring.portfolio.service.MainService;

public interface AccountService extends MainService {

	public abstract boolean login(ModelAndView mv) throws Exception;

}
