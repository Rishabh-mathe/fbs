package com.cognizant.flightbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.flightbooking.dtos.AirlineDto;
import com.cognizant.flightbooking.services.AirlineService;

@RestController
@RequestMapping("/admin")
public class AdminAirlineController {
	
	@Autowired
	private AirlineService airlineService;
	
	@PostMapping("/saveAirline")
	@PreAuthorize("hasRole('ADMIN')")
	public AirlineDto saveAirline(@RequestBody AirlineDto airlineDto) {
		AirlineDto saveAirline = airlineService.saveAirline(airlineDto);
		return saveAirline;
	}
	
	@PutMapping("/editAirline")
	@PreAuthorize("hasRole('ADMIN')")
	public AirlineDto editAirline(@RequestBody AirlineDto airlineDto) {
		AirlineDto editedAirline = airlineService.editAirline(airlineDto);
		return editedAirline;
	}
	
	@PutMapping("/deleteAirline")
	@PreAuthorize("hasRole('ADMIN')")
	public Boolean deleteAirline(String airLineName) {
		Boolean deleteAirline = airlineService.deleteAirline(airLineName);
		return deleteAirline;
		
	}
}
