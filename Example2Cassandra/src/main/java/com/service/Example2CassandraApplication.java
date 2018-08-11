package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import com.model.Employee;

@SpringBootApplication
@ComponentScan("com.repository")
public class Example2CassandraApplication implements CommandLineRunner {
	
	@Autowired
	private EmployeeRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Example2CassandraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.repository.deleteAll();
		// save a couple of Employee
		this.repository.save(new Employee(101, "Anuj", "Katiyar","Kanpur",8722));
		this.repository.save(new Employee(102, "Diksha", "Katiyar","Kanpur",8722));

		// fetch all customers
		System.out.println("Employee found with findAll():");
		System.out.println("-------------------------------");
		for (Employee employee : this.repository.findAll()) {
			System.out.println(employee);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Employee found with findByFirstName('Anuj'):");
		System.out.println("--------------------------------");
		System.out.println(this.repository.findByFirstName("Anuj"));
		
		System.out.println("Employee found with findByLastName('Katiyar'):");
		System.out.println("--------------------------------");
		for (Employee employee : this.repository.findByLastName("Katiyar")) {
			System.out.println(employee);
		}
		
	}
}
