package com.dbs.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.entities.BankBICEntity;
import com.dbs.entities.ResponsePage;
import com.dbs.service.BankBICService;

@RestController
@CrossOrigin
public class BankController {
	
	@Autowired
	BankBICService bankBICService;
	
	@GetMapping(value="bank/{bic}")
	public ResponseEntity<Object> findBankNamerByBIC(@PathVariable("bic") String bic)
	{ 
			BankBICEntity bankbic= bankBICService.findByBIC(bic);
			if(bankbic!=null) {
				return new ResponseEntity<>(bankbic,HttpStatus.OK);
			}
			else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponsePage("failure","Bank BIC Not Found"));
		}
	}
}
