package com.webapp.parkinglot.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webapp.parkinglot.entity.Parking;

@Repository
public class ParkingDaoIMPL implements ParkingDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Parking> getParkingList() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Parking> theQuery = 
				currentSession.createQuery("from Parking order by spacesInTotal",
											Parking.class);
		
		List<Parking> parkings = theQuery.getResultList();
		
		return parkings;
	}

}
