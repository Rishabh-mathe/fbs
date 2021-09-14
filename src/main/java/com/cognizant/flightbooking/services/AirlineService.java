package com.cognizant.flightbooking.services;

import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.flightbooking.dtos.AirlineDto;
import com.cognizant.flightbooking.mapper.AirlineMapper;
import com.cognizant.flightbooking.models.Address;
import com.cognizant.flightbooking.models.Airline;
import com.cognizant.flightbooking.models.FlightSchedule;
import com.cognizant.flightbooking.repos.AddressRepo;
import com.cognizant.flightbooking.repos.AirlineRepo;
import com.cognizant.flightbooking.repos.FlightScheduleRepo;

@Service
public class AirlineService {
	
	@Autowired
	private AirlineRepo airlineRepo;
	
	@Autowired
	private AddressRepo addressRepo;
	
	@Autowired
	private AirlineMapper airlineMapper;

	@Autowired
	private FlightScheduleRepo flightScheduleRepo;

	
	public AirlineDto saveAirline(AirlineDto airlineDto) {
		airlineDto.setStatus("active");
		Airline airline = airlineMapper.map(airlineDto, Airline.class);
		Airline findByAirlineName = airlineRepo.findByAirlineName(airline.getAirlineName());
		if(findByAirlineName != null) {
			airline.setId(findByAirlineName.getId());
		}
		Set<Address> ownerAddress = airline.getOwnerAddress().stream().collect(Collectors.toSet());
		Set<FlightSchedule> flights = airline.getFlightSchedules().stream().collect(Collectors.toSet());
		airline.getOwnerAddress().clear();
		airline.getFlightSchedules().clear();
		Airline airlineSaved = airlineRepo.save(airline);
		ownerAddress.stream().forEach(ownerAddr->{
			ownerAddr.setAirline(airlineSaved);
			addressRepo.save(ownerAddr);
		});
		flights.stream().forEach(flight->{
			flight.setAirline(airlineSaved);
			flightScheduleRepo.save(flight);
		});
		AirlineDto airlineDtoSaved = airlineMapper.map(airlineSaved, AirlineDto.class);
		return airlineDtoSaved;
	}

	@Transactional
	public Boolean deleteAirline(String airLineName) {
		System.out.println(airLineName);
		airlineRepo.updateByName(airLineName,"inActive");
		return true;
	}

}
