package com.cognizant.flightbooking.dtos;

import java.time.LocalDate;
import java.util.Set;

import com.cognizant.flightbooking.models.PassangerDtl;

public class BookFlightDto {
	private long id;
	private long numberOfBooking;
	private Set<PassangerDtlDto> passangerDlt;
	private long loggedInUserId;
	private long flightId;
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getNumberOfBooking() {
		return numberOfBooking;
	}
	public void setNumberOfBooking(long numberOfBooking) {
		this.numberOfBooking = numberOfBooking;
	}
	public Set<PassangerDtlDto> getPassangerDlt() {
		return passangerDlt;
	}
	public void setPassangerDlt(Set<PassangerDtlDto> passangerDlt) {
		this.passangerDlt = passangerDlt;
	}
	public long getLoggedInUserId() {
		return loggedInUserId;
	}
	public void setLoggedInUserId(long loggedInUserId) {
		this.loggedInUserId = loggedInUserId;
	}
	public long getFlightId() {
		return flightId;
	}
	public void setFlightId(long flightId) {
		this.flightId = flightId;
	}
}
