package com.hexaware.onlinegrocerydelivery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class SubstitutionNotFoundException extends ResponseStatusException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SubstitutionNotFoundException(HttpStatus status,String message) {
		super(status,message); }
}
