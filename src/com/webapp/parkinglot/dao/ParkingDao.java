package com.webapp.parkinglot.dao;

import java.util.List;

import com.webapp.parkinglot.entity.Parking;

public interface ParkingDao {
	
	public List<Parking> getParkingList();
}
