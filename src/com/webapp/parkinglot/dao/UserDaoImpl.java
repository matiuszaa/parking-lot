package com.webapp.parkinglot.dao;

import javax.persistence.TypedQuery;

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


	@Override
	public User validateUser(User loggingUser) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		TypedQuery<User> query = currentSession.createQuery("select u from User u where u.email = :email AND"
				+ " u.password = :password", User.class);
		User foundUser = query.
				setParameter("email", loggingUser.getEmail()).
				setParameter("password", loggingUser.getPassword()).getSingleResult();
		
		return foundUser;
	}

}
