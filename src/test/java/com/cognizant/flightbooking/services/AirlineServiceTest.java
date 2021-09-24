package com.cognizant.flightbooking.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.cognizant.flightbooking.dtos.AirlineDto;
import com.cognizant.flightbooking.mapper.AirlineMapper;
import com.cognizant.flightbooking.models.Airline;
import com.cognizant.flightbooking.repos.AddressRepo;
import com.cognizant.flightbooking.repos.AirlineRepo;
import com.cognizant.flightbooking.repos.FlightScheduleRepo;
@ExtendWith(MockitoExtension.class)
class AirlineServiceTest {

	@InjectMocks
	AirlineService service;
	@Mock 
	private AirlineRepo airlineRepo;
	
	@Mock
	private AddressRepo addressRepo;
	
	@Mock
	private AirlineMapper airlineMapper;

	@Mock
	private FlightScheduleRepo flightScheduleRepo;

	@Test
	void testSaveAirline() {
		//AirlineDto airlineDto = new AirlineDto();
		//service.saveAirline(airlineDto);
	}

	@Test
	void testDeleteAirline() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAirline() {
		Airline airline =new Airline();
		airline.setActiveFlights(20L);
		when(airlineRepo.findById(1L)).thenReturn( Optional.of(airline ));
		AirlineDto airlineDto = new AirlineDto();
		airlineDto.setActiveFlights(airline.getActiveFlights());
		when(airlineMapper.map(airline, AirlineDto.class)).thenReturn(airlineDto);
		ResponseEntity<AirlineDto> result = service.getAirline(1L);
		assertEquals(20L, result.getBody().getActiveFlights());
	}

}
