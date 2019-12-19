/**
 * 
 */
package com.shopping.customer.service;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.shopping.customer.entity.Customer;
import com.shopping.customer.eventproducer.CustomerEventProducer;
import com.shopping.customer.repository.CustomerRepository;

/**
 * @author 146374
 *
 */
@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	//@Autowired
	//CustomerEventProducer customerEventProducer;
	
	private final RabbitTemplate rabbitTemplate;

	@Autowired
	private final TopicExchange topicExchange;

	public CustomerService(RabbitTemplate rabbitTemplate, TopicExchange eventExchange) {
		this.rabbitTemplate = rabbitTemplate;
		this.topicExchange = eventExchange;
	}
	
	public Customer getCustomer(Long id) {
		return customerRepository.getOne(id);
	}
	
	public Customer registerCustomer(@RequestBody Customer newCustomer) {
		Customer cust= customerRepository.save(newCustomer);
		String routingKey = "customer.created";
		String message = String.valueOf(cust.getId());
		rabbitTemplate.convertAndSend(topicExchange.getName(), routingKey, message);
		//customerEventProducer.createCustomer(String.valueOf(cust.getId()));
		return cust;
	}
}
