package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.EmailEntity;

@Repository
public interface EmailRepository extends JpaRepository<EmailEntity, Long> {

	public Optional<EmailEntity> findBySender(String sender);

	public Optional<List<EmailEntity>> findByReceiver(String receiver);
}
