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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class BookFlightTicket implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@OneToMany(targetEntity = BookFlightTicket.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    @JoinColumn(name ="id",referencedColumnName = "id")
	@OneToMany(mappedBy = "id", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
	private Set<PassangerDtl> passangerDtl;
	private String loggedInUserId;
	private String flightId;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<PassangerDtl> getPassangerDtl() {
		return passangerDtl;
	}
	public void setPassangerDtl(Set<PassangerDtl> passangerDlt) {
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
