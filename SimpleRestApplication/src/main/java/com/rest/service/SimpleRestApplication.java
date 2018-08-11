package com.rest.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.rest")
public class SimpleRestApplication {

	public static void main(String[] args) {
		ApplicationContext ctx= SpringApplication.run(SimpleRestApplication.class, args);
	}
}
