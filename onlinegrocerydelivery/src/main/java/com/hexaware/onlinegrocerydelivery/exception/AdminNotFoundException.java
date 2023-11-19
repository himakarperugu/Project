package com.hexaware.onlinegrocerydelivery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AdminNotFoundException  extends ResponseStatusException{
	 private static final long serialVersionUID = 1L;
	public AdminNotFoundException(HttpStatus status,String message) {
		super(status,message); }
}
