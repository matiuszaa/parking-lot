package com.webapp.parkinglot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.parkinglot.dao.UserDao;
import com.webapp.parkinglot.entity.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDAO;
	
	@Override
	@Transactional
	public void registerUser(User theUser) {
		userDAO.registerUser(theUser);

	}

	@Override
	@Transactional
	public User validateUser(User loggingUser) {
		return userDAO.validateUser(loggingUser);
		
	}

}
