package com.cognizant.flightbooking.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PassangerDtl implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String passangerName;
	private long passangerAge;
	private String foodType;
	private String gender;
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "ticket_id", nullable = false)
	private BookFlightTicket bookFlightTicket;
	private String ticketStatus;
	public String getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	@JsonIgnore
	public BookFlightTicket getBookFlightTicket() {
		return bookFlightTicket;
	}
	public void setBookFlightTicket(BookFlightTicket bookFlightTicket) {
		this.bookFlightTicket = bookFlightTicket;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
