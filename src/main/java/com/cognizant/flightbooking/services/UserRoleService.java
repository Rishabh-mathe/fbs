package com.cognizant.flightbooking.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.flightbooking.dtos.UserDto;
import com.cognizant.flightbooking.models.Role;
import com.cognizant.flightbooking.models.User;
import com.cognizant.flightbooking.repos.RoleRepo;
import com.cognizant.flightbooking.repos.UserRepo;

@Service(value = "userService")
public class UserRoleService implements UserDetailsService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RoleRepo roleRepo;
	
	@Autowired
    private BCryptPasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),getAuthority(user));
	}

	private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRole().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        });
        return authorities;
    }
	
	public List<User> findAll() {
        List<User> list = new ArrayList<>();
        userRepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }
	
	@Transactional
	public ResponseEntity<String> saveUser(UserDto user) {
		//UserDto userDtoFromUSer = null;
		try {
			User nUser = user.getUserFromDto();
			Role role = roleRepo.findRoleByName("USER");
			//nUser.setRole(user.getRole());
	        nUser.setPassword(bcryptEncoder.encode(user.getPassword()));
	        HashSet<Role> userRole = new HashSet<Role>();
	        userRole.add(role);
	        userRepo.save(nUser);
	        nUser.setRole(userRole);
	        User savedUser = userRepo.save(nUser);
	        return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
        
		
	}

	public String getUserName() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}
