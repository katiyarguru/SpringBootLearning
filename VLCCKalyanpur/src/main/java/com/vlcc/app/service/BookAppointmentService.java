package com.vlcc.app.service;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Component;

import com.vlcc.app.model.Login;
@Component
public interface BookAppointmentService extends CassandraRepository<Login, String> {	

}
