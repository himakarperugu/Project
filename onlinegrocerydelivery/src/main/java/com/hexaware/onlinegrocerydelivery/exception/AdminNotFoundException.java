package com.hexaware.onlinegrocerydelivery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AdminNotFoundException  extends ResponseStatusException{
	public AdminNotFoundException(HttpStatus status,String message) {
		super(status,message); }
}
