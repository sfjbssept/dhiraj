package com.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.User;
import com.user.userservice.IUserService;

@RestController
public class UserController {
	@Autowired
	IUserService userService;

	@PostMapping("/addUser")
	Integer addUser(@RequestBody User user) {
		Integer id = userService.addUser(user);
		System.out.println("iD---" + id);
		return id;
	}

	@GetMapping("/allUsers")
	List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/user/{id}")
	Optional<User> getUserById(@PathVariable Integer id) {
		return userService.getUser(id);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
		return new ResponseEntity<User>(userService.updateUser(user, id), HttpStatus.OK);
	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable Integer id) {
		System.out.println(id);
		ResponseEntity<User> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try {
			userService.deleteUser(id);

		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
		return responseEntity;
	}

}
