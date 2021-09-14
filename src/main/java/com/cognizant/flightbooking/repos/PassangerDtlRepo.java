package com.cognizant.flightbooking.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.flightbooking.models.PassangerDtl;

@Repository
public interface PassangerDtlRepo extends JpaRepository<PassangerDtl, Long>{

}
