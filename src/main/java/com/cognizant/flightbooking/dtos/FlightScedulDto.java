package com.cognizant.flightbooking.dtos;

import java.time.LocalTime;
import java.util.Set;

public class FlightScedulDto {
	private Long id;
	
	private String flightCode;
	
	private LocalTime takeOff;
	
	private LocalTime landingTime;
		
	private String[] daysDto;
	
	private Long bussinessClassSeats;
	
	private Double bussinessClassSeatCost;
	
	private Long firstClassSeats;
	
	private Double firstClassSeatCost;
	
	private Long secondClassSeats;
	
	private Double secondClassSeatCost;
	
	private Long thirdClassSeats;
	
	private Double thirdClassSeatCost;
	
	private String meal;
	
	private Long fromCity;
	
	private Long toCity;
	
	private Long discount;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

	public String[] getDaysDto() {
		return daysDto;
	}

	public void setDaysDto(String[] daysDto) {
		this.daysDto = daysDto;
	}

	public Long getDiscount() {
		return discount;
	}

	public void setDiscount(Long discount) {
		this.discount = discount;
	}

	public LocalTime getTakeOff() {
		return takeOff;
	}

	public void setTakeOff(LocalTime takeOff) {
		this.takeOff = takeOff;
	}

	public LocalTime getLandingTime() {
		return landingTime;
	}

	public void setLandingTime(LocalTime landingTime) {
		this.landingTime = landingTime;
	}

	public Long getBussinessClassSeats() {
		return bussinessClassSeats;
	}

	public void setBussinessClassSeats(Long bussinessClassSeats) {
		this.bussinessClassSeats = bussinessClassSeats;
	}

	public Double getBussinessClassSeatCost() {
		return bussinessClassSeatCost;
	}

	public void setBussinessClassSeatCost(Double bussinessClassSeatCost) {
		this.bussinessClassSeatCost = bussinessClassSeatCost;
	}

	public Long getFirstClassSeats() {
		return firstClassSeats;
	}

	public void setFirstClassSeats(Long firstClassSeats) {
		this.firstClassSeats = firstClassSeats;
	}

	public Double getFirstClassSeatCost() {
		return firstClassSeatCost;
	}

	public void setFirstClassSeatCost(Double firstClassSeatCost) {
		this.firstClassSeatCost = firstClassSeatCost;
	}

	public Long getSecondClassSeats() {
		return secondClassSeats;
	}

	public void setSecondClassSeats(Long secondClassSeats) {
		this.secondClassSeats = secondClassSeats;
	}

	public Double getSecondClassSeatCost() {
		return secondClassSeatCost;
	}

	public void setSecondClassSeatCost(Double secondClassSeatCost) {
		this.secondClassSeatCost = secondClassSeatCost;
	}

	public Long getThirdClassSeats() {
		return thirdClassSeats;
	}

	public void setThirdClassSeats(Long thirdClassSeats) {
		this.thirdClassSeats = thirdClassSeats;
	}

	public Double getThirdClassSeatCost() {
		return thirdClassSeatCost;
	}

	public void setThirdClassSeatCost(Double thirdClassSeatCost) {
		this.thirdClassSeatCost = thirdClassSeatCost;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public Long getFromCity() {
		return fromCity;
	}

	public void setFromCity(Long fromCity) {
		this.fromCity = fromCity;
	}

	public Long getToCity() {
		return toCity;
	}

	public void setToCity(Long toCity) {
		this.toCity = toCity;
	}
}
