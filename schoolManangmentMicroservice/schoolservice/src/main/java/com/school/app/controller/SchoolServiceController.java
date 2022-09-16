package com.school.app.controller;

import java.net.http.HttpHeaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/schooldetail")
public class SchoolServiceController {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping(value = "/{schoolName}")
	public String getStudent(@PathVariable("schoolName") String schoolName) {
		System.out.println("Getting schoole Detail for " + schoolName);
		String requesturl = "http://localhost:9091/getStudentDetailforSchool/" + schoolName;
		org.springframework.http.HttpHeaders httpHeaders = new org.springframework.http.HttpHeaders();
		HttpEntity<String> httpEntity = new HttpEntity<String>(httpHeaders);
		ResponseEntity<String> responseEntity = restTemplate.exchange(requesturl, HttpMethod.GET, httpEntity,
				String.class);
		String student = responseEntity.getBody();
		System.out.println("Responce received as" + student);

		return "School Name" + schoolName + " \n Student details" + student;
	}

}
