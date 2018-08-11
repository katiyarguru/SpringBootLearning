package com.service;
import java.util.List;
import com.model.Employee;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component

public interface EmployeeRepository extends CrudRepository<Employee, String> {

	@Query("Select * from employee where emp_first_name=?0")
	Employee findByFirstName(String firstName);

	@Query("Select * from employee where emp_last_name=?0")
	List<Employee> findByLastName(String lastName);

}