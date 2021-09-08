package com.cognizant.flightbooking.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.flightbooking.models.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role,Long> {
	Role findRoleByName(String name);
}
