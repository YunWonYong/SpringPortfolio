package com.spring.portfolio.index.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * Handles requests for the application home page.
 */
@Controller
public class IndexController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request, ModelAndView mv) {
		mv.setViewName("/");
		return mv; 
	}
}
