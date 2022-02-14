package com.in28min.microservices.limitssevice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28min.microservices.limitssevice.bean.Limits;
import com.in28min.microservices.limitssevice.configuration.Configuration;

@RestController
public class LimitsController {
	 
	@Autowired
	private Configuration configuration;
	
	@GetMapping("/limits")
	public Limits retriveLimits() {
		return new Limits(configuration.getMinimum(), configuration.getMaximum()); 
//		return new Limits(1, 5000);
//		return "toto";
	}
	

}
