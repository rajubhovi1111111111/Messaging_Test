package com.servicebus.messaging.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servicebus.messaging.entity.Messages;

@Repository
public interface MessagingRepo extends JpaRepository<Messages, Integer> {

}
