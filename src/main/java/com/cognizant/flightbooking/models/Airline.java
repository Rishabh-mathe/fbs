package com.cognizant.flightbooking.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Airline implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = true)
	private String airlineName;
	
	private String ownerName;
	
	private String ownerMobile;
	
	private String ownerEmail;
	
	@OneToMany(mappedBy = "airline", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private Set<Address> ownerAddress;
	
	@OneToMany(mappedBy = "airline", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private Set<FlightSchedule> flightSchedules;
	
	private String airlineLogo;
	
	private Long totFlights;
	
	private Long activeFlights;
	
	private String status;

	public String getOwnerEmail() {
		return ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

	public Set<FlightSchedule> getFlightSchedules() {
		return flightSchedules;
	}

	public void setFlightSchedules(Set<FlightSchedule> flightSchedules) {
		this.flightSchedules = flightSchedules;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Set<Address> getOwnerAddress() {
		return ownerAddress;
	}

	public void setOwnerAddress(Set<Address> ownerAddress) {
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
