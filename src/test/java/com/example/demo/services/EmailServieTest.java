package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entities.EmailEntity;
import com.example.demo.repositories.EmailRepository;

@SpringBootTest
public class EmailServieTest {

	@InjectMocks
	private EmailService emailService;

	@Mock
	private EmailRepository emailRepository;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		String recevierEmail = "receiver@gmail.com";

		EmailEntity email1 = new EmailEntity("sender_1@gmail.com", recevierEmail, "Sample content");
		List<EmailEntity> list = new ArrayList<EmailEntity>();
		list.add(email1);

		Mockito.when(emailRepository.findByReceiver(Mockito.anyString())).thenReturn(Optional.of(list));

	}

	@Test
	void validSenderNReceiver() {

		EmailEntity email = new EmailEntity("@gmail.com", "@gmail.com", "Sample content");
		boolean result = emailService.sendEmail(email);
		Assertions.assertEquals(true, result);

	}

	@Test
	void invalidSender() {
		EmailEntity email = new EmailEntity("@jshdjskd.com", "@gmail.com", "Sample content");
		boolean result = emailService.sendEmail(email);
		Assertions.assertEquals(false, result);

	}

	@Test
	void invalidReceiver() {
		EmailEntity email = new EmailEntity("@gmail.com", "@adajhjdkshk.com", "Sample content");
		boolean result = emailService.sendEmail(email);
		Assertions.assertEquals(false, result);

	}
}
