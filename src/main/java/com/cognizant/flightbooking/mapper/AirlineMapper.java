package com.cognizant.flightbooking.mapper;

import org.springframework.stereotype.Component;

import com.cognizant.flightbooking.dtos.AddressDto;
import com.cognizant.flightbooking.dtos.AirlineDto;
import com.cognizant.flightbooking.models.Address;
import com.cognizant.flightbooking.models.Airline;

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
			address.setCity(addressDto.getCity());
			address.setPinCode(addressDto.getPinCode());
			address.setStreet(addressDto.getStreet());
			address.setState(addressDto.getState());
			airline.getOwnerAddress().add(address);
		});
	}

	@Override
	public void mapBtoA(final Airline airline,final AirlineDto airlineDto, MappingContext context) {
		airlineDto.getOwnerAddress().clear();
		airline.getOwnerAddress().forEach(address->{
			AddressDto addressDto = new AddressDto();
			addressDto.setCity(address.getCity());
			addressDto.setPinCode(address.getPinCode());
			addressDto.setStreet(address.getStreet());
			addressDto.setState(address.getState());
			airlineDto.getOwnerAddress().add(addressDto);
		});
	}
}
