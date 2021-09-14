package com.cognizant.flightbooking.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class BookFlightTicket implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long numberOfBooking;
	@OneToMany(mappedBy = "bookFlightTicket", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<PassangerDtl> passangerDlt;
	private long loggedInUserId;
	private long flightId;
	private LocalDate dateOfJourney;
	private String bookingClass;
	private long totTickets;
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
	public LocalDate getDateOfJourney() {
		return dateOfJourney;
	}
	public void setDateOfJourney(LocalDate dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
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
	public Set<PassangerDtl> getPassangerDlt() {
		return passangerDlt;
	}
	public void setPassangerDlt(Set<PassangerDtl> passangerDlt) {
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
