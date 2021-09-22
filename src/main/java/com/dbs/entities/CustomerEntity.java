package com.dbs.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="customer")
public class CustomerEntity {
	@Id
	String account_number;
	String name;
	double clear_balance;
	String overdraft;
	boolean isbank;
	public CustomerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerEntity(String account_number, String name, double clear_balance, String overdraft, boolean isbank) {
		super();
		this.account_number = account_number;
		this.name = name;
		this.clear_balance = clear_balance;
		this.overdraft = overdraft;
		this.isbank = isbank;
	}
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getClear_balance() {
		return clear_balance;
	}
	public void setClear_balance(double clear_balance) {
		this.clear_balance = clear_balance;
	}
	public String getOverdraft() {
		return overdraft;
	}
	public void setOverdraft(String overdraft) {
		this.overdraft = overdraft;
	}
	public boolean isIsbank() {
		return isbank;
	}
	public void setIsbank(boolean isbank) {
		this.isbank = isbank;
	}
	@Override
	public String toString() {
		return "CustomerEntity [account_number=" + account_number + ", name=" + name + ", clear_balance="
				+ clear_balance + ", overdraft=" + overdraft + ", isbank=" + isbank + "]";
	}
		
}
