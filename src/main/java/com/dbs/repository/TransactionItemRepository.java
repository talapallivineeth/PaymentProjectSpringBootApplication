package com.dbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.entities.TransactionItemEntity;

public interface TransactionItemRepository extends JpaRepository<TransactionItemEntity, Integer> {

}
