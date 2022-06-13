package com.webapp.parkinglot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.parkinglot.dao.ParkingDao;
import com.webapp.parkinglot.entity.Parking;
import com.webapp.parkinglot.entity.Reservation;
import com.webapp.parkinglot.entity.ReserveParking;

@Service
public class ParkingServiceIMPL implements ParkingService {

	
	@Autowired
	private ParkingDao parkingDAO;
	
	@Override
	@Transactional
	public List<Parking> getParkingList() {
		
		return parkingDAO.getParkingList();
	}

	@Override
	@Transactional
	public List<String> showAvailableParkings() {
		List<Parking> parkings = parkingDAO.showAvailableParkings();
		List<String> parkingAdresses = new ArrayList<>();
		for (Parking parking : parkings) {
			parkingAdresses.add(parking.getAdress());
		}
		return parkingAdresses;
	}

	@Override
	@Transactional
	public void reserveParkingSpot(Parking theParking) {
		parkingDAO.reserveParkingSpot(theParking);
		
	}

	@Override
	@Transactional
	public List<ReserveParking> getReservations() {
		return parkingDAO.getReservations();
	}

	@Override
	@Transactional
	public void releaseSpace(String[] list) {
		parkingDAO.releaseSpace(list);
		
	}

}
