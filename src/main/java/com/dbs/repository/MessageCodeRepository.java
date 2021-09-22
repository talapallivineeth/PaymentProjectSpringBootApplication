package com.dbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.entities.MessageCodeEntity;

public interface MessageCodeRepository extends JpaRepository<MessageCodeEntity, String> {

}
