package com.vlcc.app.controller;

import java.util.List;

import org.mockito.internal.matchers.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vlcc.app.model.Login;
import com.vlcc.app.service.LoginService;

@Controller
public class LoginController {
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model){
	    return "index";
	}
	
	@Autowired
    LoginService service;
	@Autowired
	private Login loginDetails;
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView showWelcomePage(ModelMap model, @RequestParam String username, @RequestParam String password){
		
		ModelAndView modelAndView = new ModelAndView();  
		loginDetails=service.findByFirstName(username);
		if (loginDetails.getUserName().equalsIgnoreCase(username) && loginDetails.getPassword().equals(password)) {
            
            modelAndView.setViewName("welcome");   
            
        }
		else {
		        modelAndView.setViewName("index"); 
		}
		System.out.println("Username Trying to login " + username);
		System.out.println("Username is " + loginDetails.getUserName());
		System.out.println("Password is " + loginDetails.getPassword());
		return modelAndView; 
	}

}


