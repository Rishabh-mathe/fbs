package com.cognizant.flightbooking.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.flightbooking.models.Planes;

public interface PlaneRepo extends JpaRepository<Planes, Long> {
	
}
