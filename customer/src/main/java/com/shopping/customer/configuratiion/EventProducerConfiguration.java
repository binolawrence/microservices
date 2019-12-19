/**
 * 
 */
package com.shopping.customer.configuratiion;

import java.util.TimeZone;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import com.shopping.customer.eventproducer.CustomerEventProducer;

/**
 * @author 146374
 *
 */

@Configuration
@EnableScheduling
public class EventProducerConfiguration {

 @Bean
  public TopicExchange eventExchange() {
   return new TopicExchange("eventExchange");
 }

 @Bean
 public CustomerEventProducer customerEventProducer(RabbitTemplate rabbitTemplate, TopicExchange eventExchange) {
   return new CustomerEventProducer(rabbitTemplate, eventExchange);
 }
 
  @LoadBalanced	
  @Bean
  org.springframework.web.client.RestTemplate restTemplate(){
    return new org.springframework.web.client.RestTemplate();
  }

  @Bean
  public Jackson2ObjectMapperBuilderCustomizer jacksonObjectMapperCustomization() {
      return jacksonObjectMapperBuilder -> 
          jacksonObjectMapperBuilder.timeZone(TimeZone.getDefault());
  }


	
}