package com.servicebus.messaging.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "sbmessages")
public class Messages {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	  
	String textMessage;

	public Messages() {
		
	}

	public Messages(String textMessage) {
		this.textMessage = textMessage;
	}

	public Messages(int id, String textMessage) {
		this.id = id;
		this.textMessage = textMessage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTextMessage() {
		return textMessage;
	}

	public void setTextMessage(String textMessage) {
		this.textMessage = textMessage;
	}
}
