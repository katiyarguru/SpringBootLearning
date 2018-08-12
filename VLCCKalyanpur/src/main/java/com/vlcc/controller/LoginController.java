package com.vlcc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model){
	    return "index";
	}
	@RequestMapping(value="/login")
	public ModelAndView showWelcomePage(ModelMap model){
		ModelAndView modelAndView = new ModelAndView();  
		modelAndView.setViewName("welcome");      
		return modelAndView; 
	}

}
