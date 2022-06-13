package com.webapp.parkinglot.service;

import java.util.List;

import  com.webapp.parkinglot.entity.Parking;
import com.webapp.parkinglot.entity.Reservation;
import com.webapp.parkinglot.entity.ReserveParking;

public interface ParkingService {

	public List<Parking> getParkingList();
	public List<String> showAvailableParkings();
	public void reserveParkingSpot(Parking theParking);
	public List<ReserveParking> getReservations();
	public void releaseSpace(String[] list);
}
