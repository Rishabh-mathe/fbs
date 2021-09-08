package com.cognizant.flightbooking.models;

public class AuthToken {
    public AuthToken(String generateToken) {
		this.token = generateToken;
	}

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}