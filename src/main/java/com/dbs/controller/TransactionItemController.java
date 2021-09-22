package com.dbs.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.entities.ResponsePage;
import com.dbs.entities.TransactionItemEntity;
import com.dbs.entities.TransactionReqBody;
import com.dbs.service.BankBICService;
import com.dbs.service.CustomerService;
import com.dbs.service.MessageCodeService;
import com.dbs.service.SdnListChecker;
import com.dbs.service.TransactionItemService;

@RestController
@CrossOrigin
public class TransactionItemController {

	@Autowired
	CustomerService customerService;

	@Autowired
	BankBICService bankBICService;

	@Autowired
	MessageCodeService messageCodeService;

	@Autowired
	TransactionItemService transactionItemService;

	

	@PostMapping(value = "transaction")
	public ResponseEntity<Object> processingTransaction(@RequestBody TransactionReqBody transactionBody) {
		if (customerService.findByAccountNum(transactionBody.getCustomer_id()) != null) {
			if (bankBICService.findByBIC(transactionBody.getReceiver_bic()) != null) {
				try {
					SdnListChecker sdnListChecker = new SdnListChecker();
					if (sdnListChecker.checker(transactionBody.getReceiver_account_name())) {
							if (transactionItemService.checkBalance(transactionBody.getCustomer_id(),
									transactionBody.getAmount())) {
								double total_money_deduct = transactionBody.getAmount()
										+ (0.25 / 100) * transactionBody.getAmount();
								customerService.updateClearBalance(transactionBody.getCustomer_id(),
										total_money_deduct);
								TransactionItemEntity transactionItemEntity = new TransactionItemEntity();
								transactionItemEntity.setCustomer(
										customerService.findByAccountNum(transactionBody.getCustomer_id()));
								if(customerService.findByAccountNum(transactionBody.getCustomer_id()).isIsbank())
									transactionItemEntity.setTransfer_type("o");
								else
									transactionItemEntity.setTransfer_type("c");
								transactionItemEntity.setMessagecode(
										messageCodeService.findbyMsgcode(transactionBody.getMessage_code()));
								transactionItemEntity
										.setBank(bankBICService.findByBIC(transactionBody.getReceiver_bic()));
								transactionItemEntity.setAmount(total_money_deduct);
								transactionItemEntity.setReceiver_name(transactionBody.getReceiver_account_name());
								transactionItemEntity
										.setReceiver_account_number(transactionBody.getReceiver_account_number());
								transactionItemEntity.setTimestamp(LocalDateTime.now());
								TransactionItemEntity t1 = transactionItemService
										.insertTransaction(transactionItemEntity);
								return new ResponseEntity<>(t1, HttpStatus.OK);

							} else {
								return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponsePage("failure",
										"Transaction failed!! You don't have enough account balance"));
							}
						} 

					else {
						return ResponseEntity.status(HttpStatus.NOT_FOUND)
								.body(new ResponsePage("failure", "Danger!! Receiver account is blacklisted"));
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body(new ResponsePage("failure", "Danger!! Receiver Bank name not found"));
			}
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponsePage("failure", "Customer does not exist"));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponsePage("failure", "Transaction failed"));
	}
	

}
