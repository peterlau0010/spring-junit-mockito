package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.EmailEntity;
import com.example.demo.repositories.EmailRepository;

public class EmailService {
	
	@Autowired
	private EmailRepository emailRepository;

	public boolean sendEmail(EmailEntity email) {
		boolean result = true;
		
		
		if (!email.getSender().contains("@gmail.com")) {
			result = false;
		}
		
		if (!email.getReceiver().contains("@gmail.com")) {
			result = false;
		}		
		
		if(!emailRepository.findByReceiver(email.getReceiver()).isPresent()){
			result = false;
		}else {
			emailRepository.findByReceiver(email.getReceiver()).ifPresent((consumer) -> System.out.println(consumer));
		}

		return result;
	}
}
