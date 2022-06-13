package com.webapp.parkinglot.dao;

import java.util.List;

import com.webapp.parkinglot.entity.Parking;
import com.webapp.parkinglot.entity.User;

public interface UserDao {
	
	public void registerUser(User registeredUser);
	
	public User validateUser(User loggingUser);
	
	public List<String> showAvailableCities();
}
