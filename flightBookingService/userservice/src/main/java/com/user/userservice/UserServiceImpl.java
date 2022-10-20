package com.user.userservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entity.User;
import com.user.exception.ResourceNotFoundException;
import com.user.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserRepository iUserRepository;

	@Override
	public Integer addUser(User user) {
		User addUser = iUserRepository.save(user);
		return addUser.getId();
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return iUserRepository.findAll();
	}

	@Override
	public Optional<User> getUser(Integer id) {
		// TODO Auto-generated method stub
		return iUserRepository.findById(id);
	}

	@Override
	public User updateUser(User user, Integer id) {
		User exsitingUser = iUserRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		exsitingUser.setFirstName(user.getFirstName());
		exsitingUser.setLastName(user.getLastName());
		exsitingUser.setEmail(user.getEmail());
		exsitingUser.setPhoneNumber(user.getPhoneNumber());
		exsitingUser.setAddress(user.getAddress());
		exsitingUser.setUserName(user.getUserName());
		exsitingUser.setPassword(user.getPassword());
		return exsitingUser;
	}

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		iUserRepository.deleteById(id);
	}

}
