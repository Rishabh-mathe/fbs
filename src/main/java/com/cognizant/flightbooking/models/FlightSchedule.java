package com.cognizant.flightbooking.models;

import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "flightCode")
@Table(name = "flight_schedule")
public class FlightSchedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long flightCode;
	
	private LocalTime takeOff;
	
	private LocalTime landingTime;
	
	private Long airCraft;
	
	private String days;
	
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
	
//	@JsonBackReference
//	@ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "airline_fk", insertable = false, updatable = false)
	private Airline airline;
	
	private long airline_fk;

	public long getAirlineFk() {
		return airline_fk;
	}

	public void setAirlineFk(long airlineFk) {
		this.airline_fk = airlineFk;
	}
	
	public Long getDiscount() {
		return discount;
	}
	public void setDiscount(Long discount) {
		this.discount = discount;
	}
	public void setAirCraft(Long airCraft) {
		this.airCraft = airCraft;
	}
	public Long getAirCraft() {
		return airCraft;
	}
	public void setAirCraft(long airCraft) {
		this.airCraft = airCraft;
	}
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public Double getBussinessClassSeatCost() {
		return bussinessClassSeatCost;
	}
	public void setBussinessClassSeatCost(Double bussinessClassSeatCost) {
		this.bussinessClassSeatCost = bussinessClassSeatCost;
	}
	public Double getFirstClassSeatCost() {
		return firstClassSeatCost;
	}
	public void setFirstClassSeatCost(Double firstClassSeatCost) {
		this.firstClassSeatCost = firstClassSeatCost;
	}
	public Double getSecondClassSeatCost() {
		return secondClassSeatCost;
	}
	public void setSecondClassSeatCost(Double secondClassSeatCost) {
		this.secondClassSeatCost = secondClassSeatCost;
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
	public Airline getAirline() {
		return airline;
	}
	public void setAirline(Airline airline) {
		this.airline = airline;
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
	public long getFlightCode() {
		return flightCode;
	}
	public void setFlightCode(long flightCode) {
		this.flightCode = flightCode;
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
