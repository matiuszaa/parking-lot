package com.webapp.parkinglot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.parkinglot.dao.ParkingDao;
import com.webapp.parkinglot.entity.Parking;

@Service
public class ParkingServiceIMPL implements ParkingService {

	
	@Autowired
	private ParkingDao parkingDAO;
	
	@Override
	@Transactional
	public List<Parking> getParkingList() {
		
		return parkingDAO.getParkingList();
	}

}
