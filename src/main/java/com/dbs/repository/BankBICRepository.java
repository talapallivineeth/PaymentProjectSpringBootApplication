package com.dbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.entities.BankBICEntity;

public interface BankBICRepository extends JpaRepository<BankBICEntity, String> {

}
