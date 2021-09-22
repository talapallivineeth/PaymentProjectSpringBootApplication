package com.dbs.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.entities.TransactionItemEntity;
import com.dbs.repository.TransactionItemRepository;

@Service
public class TransactionItemService {
	
	@Autowired
	TransactionItemRepository transactionItemRepository;

	@Autowired
	CustomerService customerService;
	
	@Autowired
	BankBICService bankBICService;
	
	@Autowired
	MessageCodeService messageCodeService;
	
	public boolean checkBalance(String act_num,double amt)
	{
		double transaction_fee = (0.25/100)*amt;
		double total_amt_transfer = amt + transaction_fee;
		double clear_balance=customerService.findByAccountNum(act_num).getClear_balance();
		
		String check_overdraft = customerService.findByAccountNum(act_num).getOverdraft();
		
		if(total_amt_transfer < clear_balance)
		{
			return true;
		}
		else
		{
			if(check_overdraft.equals("yes"))
				return true;
			else
				return false;
		}
	}
		
	
	public TransactionItemEntity insertTransaction(TransactionItemEntity transaction)
	{
		return transactionItemRepository.save(transaction);
	}
	
}
