package com.cognizant.flightbooking.models;

import java.sql.Time;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class FlightSchedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flight_sch_gen")
	@SequenceGenerator(name = "flight_sch_gen", sequenceName = "flight_sch_seq")
	private long flightCode;
	
	private Time takeOff;
	
	private Time landingTime;
	
	private long weekId;
		
	private long planeId;
	
	private Long bussinessClassSeats;
	
	private Long firstClassSeats;
	
	private Long secondClassSeats;
	
	private Long thirdClassSeats;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getFlightCode() {
		return flightCode;
	}
	public void setFlightCode(long flightCode) {
		this.flightCode = flightCode;
	}
	public Time getTakeOff() {
		return takeOff;
	}
	public void setTakeOff(Time takeOff) {
		this.takeOff = takeOff;
	}
	public Time getLandingTime() {
		return landingTime;
	}
	public void setLandingTime(Time landingTime) {
		this.landingTime = landingTime;
	}
	public long getWeekId() {
		return weekId;
	}
	public void setWeekId(long weekId) {
		this.weekId = weekId;
	}

	public long getPlaneId() {
		return planeId;
	}
	public void setPlaneId(long planeId) {
		this.planeId = planeId;
	}
	public Long getBussinessClassSeats() {
		return bussinessClassSeats;
	}
	public void setBussinessClassSeats(Long bussinessClassSeats) {
		this.bussinessClassSeats = bussinessClassSeats;
	}
	public Long getFirstClassSeats() {
		return firstClassSeats;
	}
	public void setFirstClassSeats(Long firstClassSeats) {
		this.firstClassSeats = firstClassSeats;
	}
	public Long getSecondClassSeats() {
		return secondClassSeats;
	}
	public void setSecondClassSeats(Long secondClassSeats) {
		this.secondClassSeats = secondClassSeats;
	}
	public Long getThirdClassSeats() {
		return thirdClassSeats;
	}
	public void setThirdClassSeats(Long thirdClassSeats) {
		this.thirdClassSeats = thirdClassSeats;
	}
}
