package com.vlcc.app.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.stereotype.Component;
@Component
@Table
public class Login {
	
	@PrimaryKey
	private String userName;
	
	private String password;
	
	
	public Login(String userName, String password) {
		
		this.setUserName(userName);
		this.setPassword(password);
	}
	public Login() {
		
		
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
