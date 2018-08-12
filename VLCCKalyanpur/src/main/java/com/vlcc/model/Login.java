package com.vlcc.model;

import org.springframework.data.cassandra.core.mapping.Table;


public class Login {
	
	private String userName;
	private String password;
	
	
	public Login(String userName, String password) {
		
		this.setUserName(userName);
		this.setPassword(password);
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	

}
