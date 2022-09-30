package com.publish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.publish.entity.User;

@RestController
@SpringBootApplication
public class KafkaPublisharApplication {

	@Autowired
	private KafkaTemplate<String , Object> template;
	
	private String topic="string-kafka1";
	
	@GetMapping("/publish/{name}")
     public String publishMassage(@PathVariable String name) {
		template.send(topic,"Hi"+ name+ "This is to informthat the message is comming from your kafka publisher");
		return "Data has ben published";
	}
	
	@GetMapping("/publishjson")
    public String publishMassage() {
		User user=new User(101,"Dhiraj Gupta", new String[] {"Banglore","white Field","Prestige Tech park"});
		template.send(topic,user);
		
		return "JSON Data has ben published";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(KafkaPublisharApplication.class, args);
	}
	
	

}
