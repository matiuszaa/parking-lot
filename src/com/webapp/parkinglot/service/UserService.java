package com.webapp.parkinglot.service;

import java.util.List;

import com.webapp.parkinglot.entity.Parking;
import com.webapp.parkinglot.entity.User;

public interface UserService {
	
	public void registerUser(User theUser);

	public User validateUser(User loggingUser);
	
	public List<String> showAvailableCities();
}
