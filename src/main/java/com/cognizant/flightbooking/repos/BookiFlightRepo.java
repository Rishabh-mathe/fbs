package com.cognizant.flightbooking.repos;

import java.time.LocalDate;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.flightbooking.models.BookFlightTicket;

@Repository
public interface BookiFlightRepo extends JpaRepository<BookFlightTicket, Long> {

	@Query("select sum(b.totTickets) from BookFlightTicket b where b.flightId = :flightId and b.dateOfJourney = :dateOfJourney and b.bookingClass = :bookingClass")
	Long findByFlightIdAndDateOfJourneyAndBookingClass(@Param("flightId") String flightId,@Param("dateOfJourney")  LocalDate dateOfJourney,@Param("bookingClass")String bookingClass);

	@Query("select bt from BookFlightTicket bt where bt.loggedInUserId =:username")
	ArrayList<BookFlightTicket> getMytickets(@Param("username") String userName);

}
