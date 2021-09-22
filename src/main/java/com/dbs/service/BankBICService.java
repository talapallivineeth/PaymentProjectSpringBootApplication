package com.dbs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.entities.BankBICEntity;
import com.dbs.repository.BankBICRepository;

@Service
public class BankBICService {
	@Autowired
	BankBICRepository bankBICRepository;
	
	public BankBICEntity findByBIC(String bankbic) {
		Optional<BankBICEntity> optBIC=bankBICRepository.findById(bankbic);
		if(optBIC.isPresent()) {
			return optBIC.get();
		}
		else {
			return null;
		}
	}
}
