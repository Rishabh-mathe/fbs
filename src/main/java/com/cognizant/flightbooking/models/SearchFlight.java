package com.cognizant.flightbooking.models;

import java.time.LocalDate;

//will use this when we will develop search flight fliter
public class SearchFlight {
	private long toCity;
	private long fromCity;
	private LocalDate journeyDate;
	private String bookingClass;
	public String getBookingClass() {
		return bookingClass;
	}
	public void setBookingClass(String bookingClass) {
		this.bookingClass = bookingClass;
	}
	public long getToCity() {
		return toCity;
	}
	public void setToCity(long toCity) {
		this.toCity = toCity;
	}
	public long getFromCity() {
		return fromCity;
	}
	public void setFromCity(long fromCity) {
		this.fromCity = fromCity;
	}
	public LocalDate getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(LocalDate journeyDate) {
		this.journeyDate = journeyDate;
	}
}
