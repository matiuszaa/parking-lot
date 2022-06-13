package com.webapp.parkinglot.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webapp.parkinglot.entity.Parking;
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
		Query updQuery = currentSession.createQuery("update User u set isLogged=0");
		updQuery.executeUpdate();
		TypedQuery<User> query = currentSession.createQuery("select u from User u where u.email = :email AND"
				+ " u.password = :password", User.class);
		User foundUser = query.
				setParameter("email", loggingUser.getEmail()).
				setParameter("password", loggingUser.getPassword()).getSingleResult();
		Query upQuery = currentSession.createQuery("update User u set isLogged=1 where u.email = :email");
		upQuery.setParameter("email", foundUser.getEmail());
		upQuery.executeUpdate();
		return foundUser;
	}


	@Override
	public List<String> showAvailableCities() {
		Session currentSession = sessionFactory.getCurrentSession();
		TypedQuery<String> theQuery = currentSession.createQuery("select distinct(cityName) from Parking order by city",
				String.class);
		
		List<String> cities = theQuery.getResultList();

		return cities;
	}

}
