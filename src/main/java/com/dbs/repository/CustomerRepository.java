package com.dbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.entities.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {

}
