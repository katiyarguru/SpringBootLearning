package com.vlcc.app.service;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;

import com.vlcc.app.model.Login;
@Component
public interface LoginService  extends CassandraRepository<Login, String> {	
	@Query("Select * from login where username=?0")
	Login findByFirstName(String userName);
	
	
}
