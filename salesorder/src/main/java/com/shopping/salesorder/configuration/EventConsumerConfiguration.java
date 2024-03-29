/**
 * 
 */
package com.shopping.salesorder.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author 146374
 *
 */
@Profile("subscriber")
@Configuration
public class EventConsumerConfiguration implements ApplicationListener<ApplicationReadyEvent> {

	private Logger logger = LoggerFactory.getLogger(EventConsumerConfiguration.class);

	  @Value("${subscriber.queue}")
	  private String queueName;

	  @Value("${subscriber.routingKey}")
	  private String routingKey;

	  @Bean
	  public TopicExchange receiverExchange() {
	    return new TopicExchange("eventExchange");
	  }
	  

	  @Bean
	  public Queue queue() {
	    return new Queue(queueName,false);
	   }

	  @Bean
	  public Binding binding(Queue queue, TopicExchange receiverExchange) {
		  if (routingKey == null) {
		      throw new IllegalStateException("No events to listen to! Please specify the routing key for the events to listen to with the property 'subscriber.routingKey' (see EventPublisher for available routing keys).");
		    }
	    return BindingBuilder
	            .bind(queue)
	            .to(receiverExchange)
	            .with(routingKey);
	  }

  @Bean
  public EventConsumer eventReceiver() {
    return new EventConsumer();
  }
  
  @Bean
  public MessageConverter jsonMessageConverter() {
     return new Jackson2JsonMessageConverter();
  }

  
  @Bean
  public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
     final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
     rabbitTemplate.setMessageConverter(jsonMessageConverter());
     return rabbitTemplate;
  }

   @Bean
  public Queue eventReceivingQueue() {
    if (queueName == null) {
      throw new IllegalStateException("No queue to listen to! Please specify the name of the queue to listen to with the property 'subscriber.queue'");
    }
    return new Queue(queueName);
  }



  @Bean
  public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                                  MessageListenerAdapter listenerAdapter) {
    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
    container.setConnectionFactory(connectionFactory);
    container.setQueueNames(queueName);
    container.setMessageListener(listenerAdapter);
    return container;
  }

  @Bean
  public MessageListenerAdapter listenerAdapter(EventConsumer eventConsumer) {
    return new MessageListenerAdapter(eventConsumer, "receive");
  }


  @Override
  public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
    logger.info("SUBSCRIBING TO EVENTS MATCHING KEY '{}' FROM QUEUE '{}'!", routingKey, queueName);
  }
  
	
  @Bean
  org.springframework.web.client.RestTemplate restTemplate(){
    return new org.springframework.web.client.RestTemplate();
  }


}
