package com.cognizant.flightbooking.dtos;

import java.util.Set;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MultipartFilter;

public class AirlineDto {
	private Long id;
	private String airlineName;
	private String airLineShortName;
	private String ownerName;
	private String ownerMobile;
	private String ownerEmail;
	private Set<AddressDto> ownerAddress;
	private Set<FlightScedulDto> flightSchedules;
	private String airlineLogo;
	private Long totFlights;
	private Long activeFlights;
	private String status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAirLineShortName() {
		return airLineShortName;
	}
	public void setAirLineShortName(String airLineShortName) {
		this.airLineShortName = airLineShortName;
	}
	public String getOwnerEmail() {
		return ownerEmail;
	}
	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}
	public Set<FlightScedulDto> getFlightSchedules() {
		return flightSchedules;
	}
	public void setFlightSchedules(Set<FlightScedulDto> flightSchedules) {
		this.flightSchedules = flightSchedules;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerMobile() {
		return ownerMobile;
	}
	public void setOwnerMobile(String ownerMobile) {
		this.ownerMobile = ownerMobile;
	}
	public Set<AddressDto> getOwnerAddress() {
		return ownerAddress;
	}
	public void setOwnerAddress(Set<AddressDto> ownerAddress) {
		this.ownerAddress = ownerAddress;
	}
	public String getAirlineLogo() {
		return airlineLogo;
	}
	public void setAirlineLogo(String airlineLogo) {
		this.airlineLogo = airlineLogo;
	}
	public Long getTotFlights() {
		return totFlights;
	}
	public void setTotFlights(Long totFlights) {
		this.totFlights = totFlights;
	}
	public Long getActiveFlights() {
		return activeFlights;
	}
	public void setActiveFlights(Long activeFlights) {
		this.activeFlights = activeFlights;
	}
	
}
