package com.webapp.parkinglot.service;

import com.webapp.parkinglot.entity.User;

public interface UserService {
	
	public void registerUser(User theUser);

	public User validateUser(User loggingUser);
}
