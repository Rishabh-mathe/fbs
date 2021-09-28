package com.cognizant.flightbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3Client;
import com.cognizant.flightbooking.dtos.AirlineDto;
import com.cognizant.flightbooking.services.AirlineService;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminAirlineController {
	
	@Autowired
	private AirlineService airlineService;
	
	@Autowired
	private AmazonClient amazonClient;
	
	@PostMapping("/saveAirline")
	@PreAuthorize("hasRole('ADMIN')")
	public AirlineDto saveAirline(@RequestBody AirlineDto airlineDto) {
		AirlineDto saveAirline = airlineService.saveAirline(airlineDto);
		return saveAirline;
	}
	
	@PostMapping("/saveAirlineLogo/{airlineName}")
	@PreAuthorize("hasRole('ADMIN')")
	public Boolean saveAirlineLogo(@PathVariable String airlineName , @RequestParam("filee") MultipartFile logo) {
		amazonClient.uploadLogo(airlineName,logo);
		//airlineService.saveAirlineLogo(airlineName,file);
		return true;
	}
	
	@PutMapping("/deleteAirline")
	@PreAuthorize("hasRole('ADMIN')")
	public Boolean deleteAirline(String airLineName) {
		Boolean deleteAirline = airlineService.deleteAirline(airLineName);
		return deleteAirline;
	}
	
	@GetMapping("/getAirline")
	public ResponseEntity<AirlineDto> getAirline(Long id) {
		return airlineService.getAirline(id);
	}
}
