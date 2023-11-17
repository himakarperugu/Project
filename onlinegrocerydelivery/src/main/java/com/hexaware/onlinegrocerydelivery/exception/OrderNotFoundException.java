package com.hexaware.onlinegrocerydelivery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class OrderNotFoundException  extends ResponseStatusException{
	public OrderNotFoundException(HttpStatus status,String message) {
		super(status,message); 
		}
}