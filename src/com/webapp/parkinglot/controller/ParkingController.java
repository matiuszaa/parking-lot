package com.webapp.parkinglot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webapp.parkinglot.entity.Parking;
import com.webapp.parkinglot.entity.Reservation;
import com.webapp.parkinglot.entity.ReserveParking;
import com.webapp.parkinglot.entity.User;
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
	
	@RequestMapping("/reserve")
	public String reserveParkingSpot(Model theModel) {
		Parking theParking = new Parking();
		List<String> parkingsy = parkingService.showAvailableParkings();
		theModel.addAttribute("theParking", theParking);
		theModel.addAttribute("parkingsy", parkingsy);
				
		return "reserve-spot";
	}
	
	@PostMapping("/getParkingSpot")
	public String getParkingSpot(@ModelAttribute("theParking") Parking theParking) {
		parkingService.reserveParkingSpot(theParking);
		
		return "redirect:/parking/menu";
	}
	
	@GetMapping("/reserve-list")
	public String getReservationList(Model theModel) {
		List<ReserveParking> reservations = parkingService.getReservations();
		ReserveParking reserved = new ReserveParking();
		theModel.addAttribute("reservations", reservations);
		theModel.addAttribute("reserved", reserved);
		return "reserve-list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("tempReservations") String reserved) {
		String[] list = reserved.split(";");
		parkingService.releaseSpace(list);
		return "redirect:/parking/menu";
	}
}
