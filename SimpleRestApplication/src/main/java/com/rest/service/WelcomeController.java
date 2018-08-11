package com.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.impl.WelcomeService;

@RestController
public class WelcomeController {
	
	//Auto wiring
	@Autowired
	private WelcomeService service;
	
	@RequestMapping("/welcome")
	public String welcome() {
		return service.getWelcomemessage();
	}

}

