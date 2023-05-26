package com.servicebus.messaging;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.jms.core.JmsTemplate;
import com.servicebus.messaging.repo.MessagingRepo;

import com.servicebus.messaging.controller.ServiceBusController;
import com.servicebus.messaging.entity.Messages;

@ExtendWith(MockitoExtension.class)
class MessagingUnitTests {

	@InjectMocks
	ServiceBusController controller;
	
	@Mock
	JmsTemplate jmsTemplate;
	
	@Mock
	MessagingRepo messageRepo;
	
	@Test
	void newMessageToSBTest() {
		assertEquals("index", controller.newMessageToSB());
	}
	
	@Test
	void sendMessageToSBTest() {
		assertEquals("Message sent successfully to Service bus", controller.sendMessageToSB("Hi Ria"));
	}
	
	@Test
	void fetchDataFromDBTest() {
		List<Messages> messages = new ArrayList<Messages>();
		Messages message = new Messages();
		messages.add(message);
		when(messageRepo.findAll()).thenReturn(messages);
		assertEquals(1, controller.fetchAllDatafromDB().size());
	}
}
