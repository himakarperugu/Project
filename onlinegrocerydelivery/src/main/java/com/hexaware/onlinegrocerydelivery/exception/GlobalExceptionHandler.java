package com.hexaware.onlinegrocerydelivery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
//Author:Himakar

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler({
	AdminNotFoundException.class,
	CustomerNotFoundException.class,
	OrderNotFoundException.class,
	ProductNotFoundException.class,
	SubstitutionNotFoundException.class
	
	})
public ResponseEntity<String> handleAnyExpection(Exception e) {
	
	return new ResponseEntity<>(e.toString(),HttpStatus.NOT_FOUND);
}
}