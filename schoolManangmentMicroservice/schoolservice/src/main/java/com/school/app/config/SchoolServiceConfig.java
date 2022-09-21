	package com.school.app.config;
	
	import org.springframework.beans.factory.annotation.Configurable;
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.web.client.RestTemplate;
	import org.springframework.cloud.client.loadbalancer.*;
	
	
	@Configuration
	public class SchoolServiceConfig {
	
		@LoadBalanced
		@Bean
		public RestTemplate restTemplate() {
			return new RestTemplate();
		}
	
	}
