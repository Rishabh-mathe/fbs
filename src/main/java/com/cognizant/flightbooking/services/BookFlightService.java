package com.cognizant.flightbooking.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.flightbooking.dtos.BookFlightDto;
import com.cognizant.flightbooking.mapper.FlightBookingMapper;
import com.cognizant.flightbooking.models.BookFlightTicket;
import com.cognizant.flightbooking.models.PassangerDtl;
import com.cognizant.flightbooking.repos.BookiFlightRepo;
import com.cognizant.flightbooking.repos.FlightScheduleRepo;
import com.cognizant.flightbooking.repos.PassangerDtlRepo;

@Service
public class BookFlightService {

	@Autowired
	private BookiFlightRepo bookiFlightRepo;
	
	@Autowired
	private PassangerDtlRepo passangerDtlRepo;
	
	@Autowired
	private FlightBookingMapper flightBookingMapper;
	
	@Autowired
	private FlightScheduleRepo flightScheduleRepo;
	
	@Autowired
    private UserRoleService userRoleService;
	
	@Transactional
	public boolean aveBooking(BookFlightDto bookFlightDto) {
		String userName = userRoleService.getUserName();
		bookFlightDto.setLoggedInUserId(userName);
		BookFlightTicket flightTicket = flightBookingMapper.map(bookFlightDto, BookFlightTicket.class);
		Set<PassangerDtl> passangers = flightTicket.getPassangerDtl().stream().collect(Collectors.toSet());
		flightTicket.getPassangerDtl().clear();
		Long selFlight = null;
		if(flightTicket.getBookingClass().equals("FC")) {
			selFlight = flightScheduleRepo.findByFlightCode(flightTicket.getFlightId()).get().getFirstClassSeats();
		}
		else if(flightTicket.getBookingClass().equals("SC")) {
			selFlight = flightScheduleRepo.findByFlightCode(flightTicket.getFlightId()).get().getSecondClassSeats();
		}
		else if(flightTicket.getBookingClass().equals("TC")) {
			selFlight = flightScheduleRepo.findByFlightCode(flightTicket.getFlightId()).get().getThirdClassSeats();
		}
		else if(flightTicket.getBookingClass().equals("BC")) {
			selFlight = flightScheduleRepo.findByFlightCode(flightTicket.getFlightId()).get().getBussinessClassSeats();
		}
		Long bookedTkts = bookiFlightRepo.findByFlightIdAndDateOfJourneyAndBookingClass(flightTicket.getFlightId(),flightTicket.getDateOfJourney(),flightTicket.getBookingClass());
		Long availableSeats = selFlight - (bookedTkts==null?0:bookedTkts);
		if(availableSeats >= flightTicket.getTotTickets() || flightTicket.getId() != 0) {
			BookFlightTicket bookedFlight = bookiFlightRepo.save(flightTicket);
			passangers.stream().forEach(passanger-> {
				passanger.setBookFlightTicket(bookedFlight);
				passangerDtlRepo.save(passanger);
			});
			return true;
		}
		return false;
	}

	public List<BookFlightTicket> getBookings() {
		String userName = userRoleService.getUserName();
		ArrayList<BookFlightTicket> mybookings = bookiFlightRepo.getMytickets(userName);
		return mybookings;
	}

	public BookFlightDto getTicketInfo(Long id) {
		BookFlightTicket mybookings = bookiFlightRepo.findById(id).get();
		BookFlightDto myticket = flightBookingMapper.map(mybookings, BookFlightDto.class);
		return myticket;
	}
}
