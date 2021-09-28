package com.cognizant.flightbooking.mapper;

import org.springframework.stereotype.Component;

import com.cognizant.flightbooking.dtos.AddressDto;
import com.cognizant.flightbooking.dtos.AirlineDto;
import com.cognizant.flightbooking.dtos.FlightScedulDto;
import com.cognizant.flightbooking.models.Address;
import com.cognizant.flightbooking.models.Airline;
import com.cognizant.flightbooking.models.FlightSchedule;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.ConfigurableMapper;

@Component
public class AirlineMapper extends ConfigurableMapper{

	@Override
	protected void configure(MapperFactory factory) {
		super.configure(factory);
		factory.registerClassMap(
				factory.classMap(AirlineDto.class, Airline.class)
						.byDefault()
						.customize(new AddressCustomMapper())
						.toClassMap()
				);
	}
}

class AddressCustomMapper extends CustomMapper<AirlineDto, Airline>{
	@Override
	public void mapAtoB(final AirlineDto airlineDto,final Airline airline, MappingContext context) {
		airline.getOwnerAddress().clear();
		airlineDto.getOwnerAddress().forEach(addressDto->{
			Address address = new Address();
			address.setId(addressDto.getId());
			address.setCity(addressDto.getCity());
			address.setPinCode(addressDto.getPinCode());
			address.setStreet(addressDto.getStreet());
			address.setState(addressDto.getState());
			airline.getOwnerAddress().add(address);
		});
		airline.getFlightSchedules().clear();
		airlineDto.getFlightSchedules().forEach(flightsDto->{
			FlightSchedule flightSchedule = new FlightSchedule();
			flightSchedule.setTakeOff(flightsDto.getTakeOff());
			flightSchedule.setFlightCode(flightsDto.getFlightCode());
			flightSchedule.setLandingTime(flightsDto.getTakeOff());
			flightSchedule.setDays(String.join(",",flightsDto.getDaysDto()));
			flightSchedule.setBussinessClassSeats(flightsDto.getBussinessClassSeats());
			flightSchedule.setBussinessClassSeatCost(flightsDto.getBussinessClassSeatCost());
			flightSchedule.setFirstClassSeats(flightsDto.getFirstClassSeats());
			flightSchedule.setFirstClassSeatCost(flightsDto.getFirstClassSeatCost());
			flightSchedule.setSecondClassSeats(flightsDto.getSecondClassSeats());
			flightSchedule.setSecondClassSeatCost(flightsDto.getSecondClassSeatCost());
			flightSchedule.setThirdClassSeats(flightsDto.getThirdClassSeats());
			flightSchedule.setThirdClassSeatCost(flightsDto.getThirdClassSeatCost());
			flightSchedule.setMeal(flightsDto.getMeal());
			flightSchedule.setFromCity(flightsDto.getFromCity());
			flightSchedule.setToCity(flightsDto.getToCity());
			flightSchedule.setDiscount(flightsDto.getDiscount());
			airline.getFlightSchedules().add(flightSchedule);
		});
	}

	@Override
	public void mapBtoA(final Airline airline,final AirlineDto airlineDto, MappingContext context) {
		airlineDto.getOwnerAddress().clear();
		airline.getOwnerAddress().forEach(address->{
			AddressDto addressDto = new AddressDto();
			addressDto.setId(address.getId());
			addressDto.setCity(address.getCity());
			addressDto.setPinCode(address.getPinCode());
			addressDto.setStreet(address.getStreet());
			addressDto.setState(address.getState());
			airlineDto.getOwnerAddress().add(addressDto);
		});
		
		
		airlineDto.getFlightSchedules().clear();
		airline.getFlightSchedules().forEach(flightSchedule->{
			FlightScedulDto flightScheduleDto = new FlightScedulDto();
			flightScheduleDto.setId(flightSchedule.getId());
			flightScheduleDto.setTakeOff(flightSchedule.getTakeOff());
			flightScheduleDto.setFlightCode(flightSchedule.getFlightCode());
			flightScheduleDto.setLandingTime(flightSchedule.getTakeOff());
			flightScheduleDto.setDaysDto(flightSchedule.getDays().split(","));
			flightScheduleDto.setBussinessClassSeats(flightSchedule.getBussinessClassSeats());
			flightScheduleDto.setBussinessClassSeatCost(flightSchedule.getBussinessClassSeatCost());
			flightScheduleDto.setFirstClassSeats(flightSchedule.getFirstClassSeats());
			flightScheduleDto.setFirstClassSeatCost(flightSchedule.getFirstClassSeatCost());
			flightScheduleDto.setSecondClassSeats(flightSchedule.getSecondClassSeats());
			flightScheduleDto.setSecondClassSeatCost(flightSchedule.getSecondClassSeatCost());
			flightScheduleDto.setThirdClassSeats(flightSchedule.getThirdClassSeats());
			flightScheduleDto.setThirdClassSeatCost(flightSchedule.getThirdClassSeatCost());
			flightScheduleDto.setMeal(flightSchedule.getMeal());
			flightScheduleDto.setFromCity(flightSchedule.getFromCity());
			flightScheduleDto.setToCity(flightSchedule.getToCity());
			flightSchedule.setDiscount(flightSchedule.getDiscount());
			airlineDto.getFlightSchedules().add(flightScheduleDto);
		});
	}
}

