package com.cognizant.flightbooking.repos;

import java.time.LocalTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.flightbooking.models.FlightSchedule;

@Repository
public interface FlightScheduleRepo extends JpaRepository<FlightSchedule, Long>{

	FlightSchedule findByTakeOffAndToCity(LocalTime takeOff, Long toCity);


	Optional<FlightSchedule> findByFlightCode(String flightId);

}
