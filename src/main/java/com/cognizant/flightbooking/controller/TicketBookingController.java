package com.cognizant.flightbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.flightbooking.dtos.BookFlightDto;
import com.cognizant.flightbooking.models.BookFlightTicket;
import com.cognizant.flightbooking.services.BookFlightService;

@RestController
@RequestMapping("book")
@CrossOrigin
public class TicketBookingController {
	
	@Autowired
	private BookFlightService bookingFlightService;

	@PostMapping
	public ResponseEntity<Boolean> bookTicket(@RequestBody BookFlightDto bookFlightDto){
		boolean aveBooking = bookingFlightService.aveBooking(bookFlightDto);
		if(aveBooking) {
			return new ResponseEntity<Boolean>(aveBooking,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping
	public List<BookFlightTicket> getBookings(String userName){
		return bookingFlightService.getBookings();
	}
	
	@GetMapping("/{id}")
	public BookFlightDto getTicketInfo(@PathVariable Long id){
		return bookingFlightService.getTicketInfo(id);
	}
}
