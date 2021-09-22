package com.dbs.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="message_code")
public class MessageCodeEntity {
	@Id
	String message_code;
	String description;
	public MessageCodeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MessageCodeEntity(String message_code, String description) {
		super();
		this.message_code = message_code;
		this.description = description;
	}
	public String getMessage_code() {
		return message_code;
	}
	public void setMessage_code(String message_code) {
		this.message_code = message_code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "MessageCodeEntity [message_code=" + message_code + ", description=" + description + "]";
	}
	
}
