package com.cognizant.flightbooking.dtos;

public class PassangerDtlDto {
	private long id;
	private String passangerName;
	private long passangerAge;
	private String foodType;
	private Character gender;
	private String ticketStatus;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	public String getPassangerName() {
		return passangerName;
	}
	public void setPassangerName(String passangerName) {
		this.passangerName = passangerName;
	}
	public long getPassangerAge() {
		return passangerAge;
	}
	public void setPassangerAge(long passangerAge) {
		this.passangerAge = passangerAge;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public Character getGender() {
		return gender;
	}
	public void setGender(Character gender) {
		this.gender = gender;
	}
}
