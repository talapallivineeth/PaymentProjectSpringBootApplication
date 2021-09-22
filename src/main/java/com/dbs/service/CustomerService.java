package com.dbs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.entities.CustomerEntity;
import com.dbs.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;

	public CustomerEntity findByAccountNum(String accno) {
		Optional<CustomerEntity> optCust = customerRepository.findById(accno);
		if (optCust.isPresent()) {
			return optCust.get();
		} else {
			return null;
		}
	}

	public void updateClearBalance(String acc_num, double amt) {

		CustomerEntity customer = findByAccountNum(acc_num);
		customer.setClear_balance(customer.getClear_balance() - amt);
		CustomerEntity c1 = customerRepository.save(customer);

	}
}
