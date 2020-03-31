package com.rabbitmqsend.service;

import java.util.Map;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Configuration
@Component
@PropertySource("classpath:application.properties")
public class RabbitMQSender {

	
	@Value("${rabbitmqsend.queue}")
	private String queueName;
	
	/*
	 * @Value("${rabbitmqsend.queue}") private String queue;
	 */
	
	@Value("${rabbitmqsend.routingkey}")
	private String routingkey;	
	
	@RabbitListener(queues = "${rabbitmqsend.queue}")
	public void send(Map<String,Object>  company) {
		System.out.println("Send msg = " + company+" "+queueName);
		//rabbitMqTemplate.convertAndSend(queueName, company);
		
	    
	}
}
