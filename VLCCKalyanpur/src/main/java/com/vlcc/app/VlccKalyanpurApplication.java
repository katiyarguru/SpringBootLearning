package com.vlcc.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

@SpringBootApplication
@ComponentScan( "com.vlcc.app")
public class VlccKalyanpurApplication {
	
public static void main(String[] args) {
		SpringApplication.run(VlccKalyanpurApplication.class, args);
	}



}
