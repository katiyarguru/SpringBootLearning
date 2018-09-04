package com.pagination.serviceImpl;

import org.springframework.data.cassandra.repository.CassandraRepository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pagination.model.Login;
@Repository
public interface ClientRepository extends CassandraRepository<Login, String> {

}
