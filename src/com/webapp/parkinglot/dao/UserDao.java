package com.webapp.parkinglot.dao;

import com.webapp.parkinglot.entity.User;

public interface UserDao {
	
	public void registerUser(User registeredUser);
	
	public User validateUser(User loggingUser);
}
