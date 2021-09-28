package com.cognizant.flightbooking.dtos;

import java.time.LocalDate;
import java.util.Set;

import com.cognizant.flightbooking.models.PassangerDtl;

public class BookFlightDto {
	private Long id;
	private Set<PassangerDtlDto> passangerDtl;
	private String loggedInUserId;
	private String flightId;
	private LocalDate dateOfJourney;
	private String bookingClass;
	private long totTickets;
	public LocalDate getDateOfJourney() {
		return dateOfJourney;
	}
	public void setDateOfJourney(LocalDate dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}
	public String getBookingClass() {
		return bookingClass;
	}
	public void setBookingClass(String bookingClass) {
		this.bookingClass = bookingClass;
	}
	public long getTotTickets() {
		return totTickets;
	}
	public void setTotTickets(long totTickets) {
		this.totTickets = totTickets;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<PassangerDtlDto> getPassangerDtl() {
		return passangerDtl;
	}
	public void setPassangerDtl(Set<PassangerDtlDto> passangerDlt) {
		this.passangerDtl = passangerDlt;
	}
	public String getLoggedInUserId() {
		return loggedInUserId;
	}
	public void setLoggedInUserId(String loggedInUserId) {
		this.loggedInUserId = loggedInUserId;
	}
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
}
