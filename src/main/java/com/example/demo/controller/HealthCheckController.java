package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {
	
	@GetMapping("/healthcheck")
	public String getHealthcheck() {
		return "Food Management Service is UP!!";
	}

}
