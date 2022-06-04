package com.webapp.parkinglot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webapp.parkinglot.entity.User;
import com.webapp.parkinglot.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		return "list-customers";
	}
	
	@GetMapping("/showFormForRegistry")
	public String showFormForRegistry(Model theModel) {
		User theUser = new User();
		
		theModel.addAttribute("user", theUser);
		return "user-registry";
	}
	
	@PostMapping("/registerUser")
	public String registerUser(@ModelAttribute("user") User theUser) {
		
		userService.registerUser(theUser);
		
		return "redirect:/user/list";
	}
	
	@GetMapping("/showFormForLogin")
	public String showFormForLogin(Model theModel) {
		
		User theUser = new User();
		theModel.addAttribute("user-login", theUser);
		
		return "user-login";
	}
	
	@PostMapping("/loginUser")
	public String loginUser(@ModelAttribute("user") User loggingUser) {
		
		if (userService.validateUser(loggingUser) == null) {
			System.out.println("Not found");
		} else {
			System.out.println("Found");
		}
		
		return "redirect:/user/list";
	}
}
