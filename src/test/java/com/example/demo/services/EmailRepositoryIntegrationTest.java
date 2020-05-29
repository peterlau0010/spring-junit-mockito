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
	private TestEntityManager entityManager;

	@Autowired
	private EmailRepository emailRepository;

	@Test
	void findBySenderTest() {
		EmailEntity email = new EmailEntity("sender@gmail.com", "receiver@gmail.com", "Sample content");
		entityManager.persist(email);
		entityManager.flush();
		EmailEntity found = emailRepository.findBySender(email.getSender()).orElse(null);

		assertThat(found.getSender()).isEqualTo(email.getSender());

	}

	@Test
	void findByReceiver() {
		String recevierEmail = "receiver@gmail.com";
		
		EmailEntity email1 = new EmailEntity("sender_1@gmail.com", recevierEmail, "Sample content");
		EmailEntity email2 = new EmailEntity("sender_2@gmail.com", recevierEmail, "Sample content");
		EmailEntity email3 = new EmailEntity("sender_3@gmail.com", recevierEmail, "Sample content");
		entityManager.persist(email1);
		entityManager.persist(email2);
		entityManager.persist(email3);
		entityManager.flush();
		
		List<EmailEntity> found = emailRepository.findByReceiver(recevierEmail).orElse(null);

		assertThat(found.size()).isEqualTo(3);
	}

}
