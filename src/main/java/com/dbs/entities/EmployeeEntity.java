package com.dbs.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="employee")
public class EmployeeEntity {
	@Id
	String username;
	String password;
	public EmployeeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeEntity(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "EmployeeEntity [username=" + username + ", password=" + password + "]";
	}
	
}
