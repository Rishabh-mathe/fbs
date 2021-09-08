package com.cognizant.flightbooking.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.flightbooking.models.Address;

public interface AddressRepo extends JpaRepository<Address, Long> {

}
