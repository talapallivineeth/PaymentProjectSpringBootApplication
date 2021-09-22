package com.dbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.entities.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, String> {

}
