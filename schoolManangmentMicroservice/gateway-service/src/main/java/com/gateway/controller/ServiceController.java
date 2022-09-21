package com.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class ServiceController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping(value="/getSchoolDetails/{schoolname}",method = RequestMethod.GET)
	public String getStudent(@PathVariable String schoolname) {
		System.out.println("Getting School Details"+schoolname);
		String  response= restTemplate.exchange("http://school-service/schooldetail/{schoolname}", 
				HttpMethod.GET,null,new ParameterizedTypeReference<String>(){},schoolname).getBody();
		System.out.println("Responce Received as:  "+ response);
			
		return "School Name-"+ schoolname+ "\n Student Details:" +response;
				
		}
	

}
