package com.webapp.parkinglot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webapp.parkinglot.entity.Parking;
import com.webapp.parkinglot.service.ParkingService;

@Controller
@RequestMapping("/parking")
public class ParkingController {
	
	@Autowired
	private ParkingService parkingService;
	
	@RequestMapping("/menu")
	public String parkingMenu(Model theModel) {
		return "parking-menu-for-users";
	}
	
	@GetMapping("/list")
	public String listParking(Model theModel) {
		
		// get customers from the service
		List<Parking> theParkings = parkingService.getParkingList();
				
		// add the customers to the model
		theModel.addAttribute("parkings", theParkings);
		
		return "parking-list";
	}
	
}
