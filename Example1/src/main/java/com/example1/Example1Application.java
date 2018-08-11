package com.example1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Example1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Example1Application.class, args);
		
		Alien a1= context.getBean(Alien.class);
		//Alien a2= context.getBean(Alien.class);
		
		a1.show();
		//a2.show();
	}
}
