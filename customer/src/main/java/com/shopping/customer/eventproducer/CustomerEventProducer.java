/**
 * 
 */
package com.shopping.customer.eventproducer;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 146374
 *
 */
//@Component
public class CustomerEventProducer {

	private final RabbitTemplate rabbitTemplate;

	private final TopicExchange topicExchange;

	@Autowired
	public CustomerEventProducer(RabbitTemplate rabbitTemplate, TopicExchange eventExchange) {
		this.rabbitTemplate = rabbitTemplate;
		this.topicExchange = eventExchange;
	}

	public void createCustomer(String customerId) {
		// ... do some database stuff
		String routingKey = "customer.created";
		String message = customerId;
		rabbitTemplate.convertAndSend(topicExchange.getName(), routingKey, message);
	}

}