package com.consumer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;

import com.consumer.entity.User;

@SpringBootApplication
public class KafkaConsumerApplication {

	List<String> messages = new ArrayList<>();
	User userFromTopic = null;

	@GetMapping("/consumerString")
	public List<String> consumerMassages() {
		return messages;
	}

	@KafkaListener(groupId = "groupid-1", topics = "spring-kafka1", containerFactory = "kafkaListenerContainerFactory")
	public List<String> getMessageFromTopic(String data) {
		messages.add(data);
		return messages;

	}

	
	@GetMapping("/consumejson")
	public User consumeJsonMassages() {
		return userFromTopic;
	}

	@KafkaListener(groupId = "groupid-2", topics = "spring-kafka1", containerFactory = "userKafkaListenerContainerFactory")
	public User getJsonMessageFromTopic(User user) {
		userFromTopic=user;
		return userFromTopic;

	}

	public static void main(String[] args) {
		SpringApplication.run(KafkaConsumerApplication.class, args);
	}

}
