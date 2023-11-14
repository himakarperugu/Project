package com.hexaware.onlinegrocerydelivery.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class ProductNotFoundException extends ResponseStatusException {
	public ProductNotFoundException(HttpStatusCode status, String message) {
		
		super(status, message);
	}
}
