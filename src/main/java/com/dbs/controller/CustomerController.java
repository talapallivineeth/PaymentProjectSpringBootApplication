package com.dbs.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.entities.CustomerEntity;
import com.dbs.entities.ResponsePage;
import com.dbs.service.CustomerService;

@RestController
@CrossOrigin
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping(value="customer/{customerid}")
	public ResponseEntity<Object> findCustomerById(@PathVariable("customerid") String customerid)
	{
		
			CustomerEntity cust = customerService.findByAccountNum(customerid);
			if(cust!=null) {
			return new ResponseEntity<>(cust,HttpStatus.OK);
			}
			else{
			System.out.println("error");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponsePage("failure","Customer Not Found"));
		}
	}
}
