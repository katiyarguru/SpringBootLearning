package com.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import java.util.UUID;

@Table
public class Employee {
	@PrimaryKey
	private int emp_id; 
	
	private String emp_first_name; 
	private String emp_last_name;
	private String emp_address;
	private int emp_mob_number;
	
	public Employee(int emp_id, String emp_first_name, String emp_last_name, String emp_address, int emp_mob_number) {
		this.emp_id = emp_id;
		this.emp_first_name = emp_first_name;
		this.emp_last_name = emp_last_name;
		this.emp_address = emp_address;
		this.emp_mob_number = emp_mob_number;
	}
	
	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_first_name=" + emp_first_name + ", emp_last_name=" + emp_last_name
				+ ", emp_address=" + emp_address + ", emp_mob_number=" + emp_mob_number + "]";
	}
	

}
