package com.dbs.entities;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="transaction_item")
public class TransactionItemEntity {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	Integer tid;
	double amount;
	String transfer_type;
	LocalDateTime timestamp;
	String receiver_name;
	String receiver_account_number;
	@ManyToOne
	@JoinColumn(name="customer_id")
	CustomerEntity customer;
	@ManyToOne
	@JoinColumn(name="receiver_bic")
	BankBICEntity bank;
	@ManyToOne
	@JoinColumn(name="message_code")
	MessageCodeEntity messagecode;
	public TransactionItemEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TransactionItemEntity(Integer tid, double amount, String transfer_type, LocalDateTime timestamp, String receiver_name,
			String receiver_account_number, CustomerEntity customer, BankBICEntity bank,
			MessageCodeEntity messagecode) {
		super();
		this.tid = tid;
		this.amount = amount;
		this.transfer_type = transfer_type;
		this.timestamp = timestamp;
		this.receiver_name = receiver_name;
		this.receiver_account_number = receiver_account_number;
		this.customer = customer;
		this.bank = bank;
		this.messagecode = messagecode;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getTransfer_type() {
		return transfer_type;
	}
	public void setTransfer_type(String transfer_type) {
		this.transfer_type = transfer_type;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getReceiver_name() {
		return receiver_name;
	}
	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}
	public String getReceiver_account_number() {
		return receiver_account_number;
	}
	public void setReceiver_account_number(String receiver_account_number) {
		this.receiver_account_number = receiver_account_number;
	}
	public CustomerEntity getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}
	public BankBICEntity getBank() {
		return bank;
	}
	public void setBank(BankBICEntity bank) {
		this.bank = bank;
	}
	public MessageCodeEntity getMessagecode() {
		return messagecode;
	}
	public void setMessagecode(MessageCodeEntity messagecode) {
		this.messagecode = messagecode;
	}
	@Override
	public String toString() {
		return "TransactionItemEntity [tid=" + tid + ", amount=" + amount + ", transfer_type=" + transfer_type
				+ ", timestamp=" + timestamp + ", receiver_name=" + receiver_name + ", receiver_account_number="
				+ receiver_account_number + ", customer=" + customer + ", bank=" + bank + ", messagecode=" + messagecode
				+ "]";
	}
	
	
}
