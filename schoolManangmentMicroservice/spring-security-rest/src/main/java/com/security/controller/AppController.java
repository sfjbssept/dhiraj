package com.security.controller;

import java.time.ZonedDateTime;
import java.util.List;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;
import org.springframework.http.HttpHeaders;

import com.security.data.Employee;

@RestController
public class AppController {

	@GetMapping("/get")
	public String getDetails() {
		return "Get Employee";
	}

	@PostMapping("/post")
	public Employee postEmployee(@RequestBody Employee newEmployee) {
		return newEmployee;
	}

	@PutMapping("/put/{name}")
	String putEmployee(@RequestBody Employee newEmployee, @PathVariable String name) {
		return newEmployee.toString() + "Updated with name " + name;
	}

	@DeleteMapping("delete/{name}")
	String deleteEmployee(@PathVariable String name) {
		return name;

	}

	@GetMapping("/path/{name}")
	public String getPathVar(@PathVariable("name") String name)

	{
		return "Path Variable" + name;
	}

	@GetMapping("/request")
	public String geRequestParam(@RequestParam(name = "name", required = true, defaultValue = "dhiraj") String name) {
		return "Request Param :" + name;
	}

	@GetMapping("/request/params")
	public String geRequestParams(@RequestParam List<String> id) {
		return "Request Param :" + id;
	}

	@GetMapping("/headers")
	public ResponseEntity<String> geRequestParam(@RequestHeader HttpHeaders header) {
		if (isHeaderMissing(header, "name")) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		HttpHeaders responseHeader = new HttpHeaders();
		responseHeader.setExpires(ZonedDateTime.now().plusDays(1));
		String response = "Valid Heaser";
		return ResponseEntity.ok().headers(responseHeader).body(response);
	}

	private boolean isHeaderMissing(final HttpHeaders header, final String headerKey) {
		if (!header.containsKey(headerKey)) {
			return true;

		} else {
			return false;
		}
	}
}
