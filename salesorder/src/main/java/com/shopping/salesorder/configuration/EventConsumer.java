package com.shopping.salesorder.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class EventConsumer {

	  private Logger logger = LoggerFactory.getLogger(EventConsumer.class);

	  @RabbitListener(queues="orderServiceQueue")
	  public void receive(String message) {
	    logger.info("Received message '{}'", message);
	  }

	}