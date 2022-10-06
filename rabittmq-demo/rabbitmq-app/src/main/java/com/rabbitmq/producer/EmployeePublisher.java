package com.rabbitmq.producer;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import com.rabbitmq.config.MessagingConfig;
import com.rabbitmq.entity.Employee;
import com.rabbitmq.entity.EmployeeStatus;

@RestController
@RequestMapping("/Employee")
public class EmployeePublisher {

	@Autowired
	private RabbitTemplate template;

	@PostMapping("/{companyName}")
	public String saveEmployee(@RequestBody Employee employee, @PathVariable String companyName) {
		employee.setEmpId(UUID.randomUUID().toString());
		EmployeeStatus employeeStatus = new EmployeeStatus(employee, "joined",
				"Has recently joined the company and  is going through the onboarding ");
		template.convertAndSend(MessagingConfig.EXCHANGENAME, MessagingConfig.ROUTING_KEY, employeeStatus);
		return "Success!";
	}

}
