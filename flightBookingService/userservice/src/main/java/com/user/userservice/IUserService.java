package com.user.userservice;

import java.util.List;
import java.util.Optional;

import com.user.entity.User;


public interface IUserService {

		Integer addUser(User user);

		public  List<User> getAllUsers();
			
		 Optional<User> getUser(Integer id);
		 
		 User updateUser(User user ,Integer id);
		 public void deleteUser(Integer id);
		 
	
		}

