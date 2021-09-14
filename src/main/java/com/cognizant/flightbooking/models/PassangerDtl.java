package com.cognizant.flightbooking.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PassangerDtl implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String passangerName;
	private long passangerAge;
	private String foodType;
	private Character gender;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "book_flight_fk", nullable = false)
	private BookFlightTicket bookFlightTicket;
	private String ticketStatus;
	public String getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	public BookFlightTicket getBookFlightTicket() {
		return bookFlightTicket;
	}
	public void setBookFlightTicket(BookFlightTicket bookFlightTicket) {
		this.bookFlightTicket = bookFlightTicket;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
