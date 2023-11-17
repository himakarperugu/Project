package com.hexaware.onlinegrocerydelivery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CustomerNotFoundException  extends ResponseStatusException{
	public CustomerNotFoundException(HttpStatus status,String message) {
		super(status,message); }
}

