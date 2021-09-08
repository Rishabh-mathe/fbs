package com.cognizant.flightbooking.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.flightbooking.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	User findByUserName(String username);
}
