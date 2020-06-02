package com.example.demo.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.entities.EmailEntity;
import com.example.demo.repositories.EmailRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class EmailRepositoryIntegrationTest {

	@Autowired
	private EmailRepository emailRepository;

	@Test
	void findBySenderTest() {
		EmailEntity email = new EmailEntity("sender@gmail.com", "receiver@gmail.com", "Sample content");
		emailRepository.save(email);
		EmailEntity found = emailRepository.findBySender(email.getSender()).orElse(null);

		assertThat(found.getSender()).isEqualTo(email.getSender());

	}

	@Test
	void findByReceiver() {
		String recevierEmail = "receiver@gmail.com";
		
		EmailEntity email1 = new EmailEntity("sender_1@gmail.com", recevierEmail, "Sample content");
		EmailEntity email2 = new EmailEntity("sender_2@gmail.com", recevierEmail, "Sample content");
		EmailEntity email3 = new EmailEntity("sender_3@gmail.com", recevierEmail, "Sample content");
		emailRepository.save(email1);
		emailRepository.save(email2);
		emailRepository.save(email3);

		
		List<EmailEntity> found = emailRepository.findByReceiver(recevierEmail).orElse(null);

		assertThat(found.size()).isEqualTo(3);
	}

}
