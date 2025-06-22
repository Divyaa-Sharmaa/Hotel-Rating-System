package com.user.service.UserService.service;

import java.util.List;

import com.user.service.UserService.entities.User;

public interface UserService {
	
	//user operations
	
	//create User
	User saveUser(User user);
	
	// get all users
	List<User> findAllUsers();
	
	//get user by Id
	User findUserById(String userId);
	
	//delete user by id
	void deleteUser(String id);
	
	
	//update user by id
	User updateUserById(User user, String userId);

}
