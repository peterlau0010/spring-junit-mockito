package com.example.demo.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entities.EmailEntity;

@SpringBootTest
public class EmailServieTest {

	@Mock
	private EmailService emailService;

	@BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        emailService = new EmailService();
    }

	@Test
	void validSenderNReceiver() {
		EmailEntity email = new EmailEntity("@gmail.com", "@gmail.com", "Sample content");
		boolean result =emailService.sendEmail(email);
		Assertions.assertEquals(true, result);
		
	}
	
	@Test
	void invalidSender() {
		EmailEntity email = new EmailEntity("@jshdjskd.com", "@gmail.com", "Sample content");
		boolean result =emailService.sendEmail(email);
		Assertions.assertEquals(false, result);
		
	}
	
	@Test
	void invalidReceiver() {
		EmailEntity email = new EmailEntity("@gmail.com", "@adajhjdkshk.com", "Sample content");
		boolean result =emailService.sendEmail(email);
		Assertions.assertEquals(false, result);
		
	}
}
