package com.example.demo.services;

import com.example.demo.entities.EmailEntity;

public class EmailService {

	public boolean sendEmail(EmailEntity email) {
		boolean result = true;
		
		
		if (!email.getSender().contains("@gmail.com")) {
			result = false;
		}
		
		if (!email.getReceiver().contains("@gmail.com")) {
			result = false;
		}		

		return result;
	}
}
