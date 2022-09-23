package com.security.controller;

import static org.assertj.core.api.Assertions.catchException;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.reset;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Base64;

import org.apache.logging.log4j.util.Base64Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.Base64Utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.security.data.Employee;

@RunWith(SpringRunner.class)
@WebMvcTest({ AppController.class })
@ActiveProfiles(value = "true")
public class AppControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Value("${employee.get.url}")
	String geturl;

	@Value("${employee.post.url}")
	String posturl;

	@Value("${employee.put.url}")
	String puturl;

	@Value("${employee.delete.url}")
	String deleteurl;

	@Value("${employee.user1.username}")
	String username1;

	@Value("${employee.user1.password}")
	String password1;

	@Value("${employee.user1.username}")
	String admin_name1;

	@Value("${employee.user1.password}")
	String admin_password1;

	@Test
	public void testEmployeeGet() throws Exception {
		ResultActions responseEntity = processApiRequest(geturl, HttpMethod.GET, null, null, username1, password1);
		responseEntity.andExpect(status().isOk());
		ObjectMapper mapper = new ObjectMapper();
		String result = responseEntity.andReturn().getResponse().getContentAsString();
		assertEquals("get Rmployee", result);

	}

	

	@Test
	public void testEmployeePost() throws Exception {
		Employee employee = createEmployee("test", "dev");
		ResultActions responseEntity = processApiRequest(posturl, HttpMethod.POST, null, employee, admin_name1,
				admin_password1);
		responseEntity.andExpect(status().isOk());
		ObjectMapper mapper = new ObjectMapper();

		Employee result = mapper.readValue(responseEntity.andReturn().getResponse().getContentAsString(),
				new TypeReference<Employee>() {
				});

		assertEquals("test", result.getName());
		assertEquals("dev", result.getRole());
	}

	private Employee createEmployee(String string1, String String2) {
		return null;
	}

	private ResultActions processApiRequest(String api, HttpMethod methodType, String name, Employee employee,
			String username, String password) {
		ResultActions response = null;
		String secret = "Basic" + Base64Utils.encodeToString((username + ":" + password).getBytes());
		try {
			switch (methodType) {
			case GET:
				response = mockMvc.perform(get(api).header(HttpHeaders.AUTHORIZATION, secret));
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		return response;

	}
}
