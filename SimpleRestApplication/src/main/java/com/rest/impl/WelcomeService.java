package com.rest.impl;

import org.springframework.stereotype.Component;

@Component
public class WelcomeService{
	
	public String getWelcomemessage() {
		
		return "Calling welcome Service";
	}
}
