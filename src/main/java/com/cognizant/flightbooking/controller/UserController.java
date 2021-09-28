package com.cognizant.flightbooking.controller;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.flightbooking.config.TokenProvider;
import com.cognizant.flightbooking.dtos.UserDto;
import com.cognizant.flightbooking.models.AuthToken;
import com.cognizant.flightbooking.models.LoginUser;
import com.cognizant.flightbooking.repos.RoleRepo;
import com.cognizant.flightbooking.repos.UserRepo;
import com.cognizant.flightbooking.services.UserRoleService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
	@Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;

    @Autowired
    private UserRoleService userRoleService;
    
    @Autowired
    private UserRepo userRepo;
    
    @Autowired
    private RoleRepo roleRepo;
    
    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginUser loginUser) throws AuthenticationException{
    	final Authentication authenticate = authenticationManager.authenticate(
    				new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword())
    			);
    	SecurityContextHolder.getContext().setAuthentication(authenticate);
    	final String generateToken = jwtTokenUtil.generateToken(authenticate);
    	return ResponseEntity.ok(new AuthToken(generateToken));
    }
    
    @GetMapping("/username")
    public String currentUserNameSimple() {
        
        String username = userRoleService.getUserName();
        return username;
    }
    
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDto user) {
    	user.setUsername(user.getEmail());
    	return userRoleService.saveUser(user);
    }
    
    @GetMapping("/userRole")
	@PreAuthorize("hasRole('ADMIN')")
    public boolean checkUserRole() {
    	return true;
    }
    
    @GetMapping("/test")
    public String test() {
    	return "testing";
    }
}
