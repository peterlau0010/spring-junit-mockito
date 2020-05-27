package com.example.demo.entities;

public class EmailEntity {
	String sender;
	String receiver;
	String content;
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public EmailEntity(String sender, String receiver, String content) {
		super();
		this.sender = sender;
		this.receiver = receiver;
		this.content = content;
	}
	@Override
	public String toString() {
		return "EmailEntity [sender=" + sender + ", receiver=" + receiver + ", content=" + content + "]";
	}
	
	

}
