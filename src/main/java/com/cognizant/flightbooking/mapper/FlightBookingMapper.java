package com.cognizant.flightbooking.mapper;

import org.springframework.stereotype.Component;

import com.cognizant.flightbooking.dtos.BookFlightDto;
import com.cognizant.flightbooking.dtos.PassangerDtlDto;
import com.cognizant.flightbooking.models.BookFlightTicket;
import com.cognizant.flightbooking.models.PassangerDtl;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.ConfigurableMapper;

@Component
public class FlightBookingMapper extends ConfigurableMapper {
	
	@Override
	public void configure(MapperFactory mapperFactory) {
		super.configure(mapperFactory);
		mapperFactory.registerClassMap(
					mapperFactory.classMap(BookFlightDto.class, BookFlightTicket.class)
								 .byDefault()
								 .customize(new customPassangerMapper())
								 .toClassMap()
				);
	}
}

class customPassangerMapper extends CustomMapper<BookFlightDto, BookFlightTicket>{
	@Override
	public void mapAtoB(final BookFlightDto bookFlightDto,final BookFlightTicket bookFlightTicket, MappingContext context) {
		bookFlightTicket.getPassangerDtl().clear();
		bookFlightDto.getPassangerDtl().stream().forEach(passanger->{
			PassangerDtl passangerDtl = new PassangerDtl();
			passangerDtl.setId(passanger.getId());
			passangerDtl.setFoodType(passanger.getFoodType());
			passangerDtl.setGender(passanger.getGender());
			passangerDtl.setPassangerAge(passanger.getPassangerAge());
			passangerDtl.setPassangerName(passanger.getPassangerName());
			passangerDtl.setTicketStatus(passanger.getTicketStatus());
			bookFlightTicket.getPassangerDtl().add(passangerDtl);
		});
	}
	
	@Override
	public void mapBtoA(final BookFlightTicket bookFlightTicket,final BookFlightDto bookFlightDto, MappingContext context) {
		bookFlightDto.getPassangerDtl().clear();
		bookFlightTicket.getPassangerDtl().stream().forEach(passanger->{
			PassangerDtlDto passangerDtl = new PassangerDtlDto();
			passangerDtl.setId(passanger.getId());
			passangerDtl.setFoodType(passanger.getFoodType());
			passangerDtl.setGender(passanger.getGender());
			passangerDtl.setPassangerAge(passanger.getPassangerAge());
			passangerDtl.setPassangerName(passanger.getPassangerName());
			passangerDtl.setTicketStatus(passanger.getTicketStatus());
			bookFlightDto.getPassangerDtl().add(passangerDtl);
		});
	}
}
