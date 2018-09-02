package com.pagination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.pagination.serviceImpl.ClientRepository;

@SpringBootApplication
@ComponentScan( "com.pagination")

public class SpringBootPaginationApplication {
	@Autowired
	ClientRepository clientrepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootPaginationApplication.class, args);
	}
}
