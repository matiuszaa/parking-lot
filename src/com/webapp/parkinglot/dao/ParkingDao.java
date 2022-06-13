package com.webapp.parkinglot.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.webapp.parkinglot.entity.Parking;
import com.webapp.parkinglot.entity.Reservation;
import com.webapp.parkinglot.entity.ReserveParking;

@Repository
public interface ParkingDao {
	
	public List<Parking> getParkingList();
	
	public List<Parking> showAvailableParkings();

	public void reserveParkingSpot(Parking theParking);

	public List<ReserveParking> getReservations();

	public void releaseSpace(String[] list);
}
