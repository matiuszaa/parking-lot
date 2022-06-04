package com.webapp.parkinglot.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webapp.parkinglot.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void registerUser(User registeredUser) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(registeredUser);
	}

}
