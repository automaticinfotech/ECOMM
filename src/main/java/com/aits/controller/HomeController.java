package com.aits.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aits.dto.StateMasterDto;

@Controller
public class HomeController {
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String homePage() {
		System.out.println("Inside Controller");
		
		return "index";
		
	}
	
	@RequestMapping(value="/adminLogin", method = RequestMethod.GET)
	public String adminLogin() {
		
		
		return "admin/adminLogin";
		
	}
	
	

}
