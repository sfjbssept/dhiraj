package com.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.rabbitmq.config.MessagingConfig;
import com.rabbitmq.entity.EmployeeStatus;

@Component
public class User {
	
	@RabbitListener(queues= MessagingConfig.QUEUENAME)
	public void consumeMessageFromQueue(EmployeeStatus employeeStatus) {
		System.out.println("Message Received"+ employeeStatus);
		
	}

}
