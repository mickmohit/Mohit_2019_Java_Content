package com.mohit.springrest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc)
	{
		StudentErrorResponse srr= new StudentErrorResponse();
		
		srr.setMessage(exc.getMessage());
		srr.setStatus(HttpStatus.NOT_FOUND.value());
		srr.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(srr,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleExceptions(Exception exc)
	{
		StudentErrorResponse srr= new StudentErrorResponse();
		
		srr.setMessage(exc.getMessage());
		srr.setStatus(HttpStatus.BAD_REQUEST.value());
		srr.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(srr,HttpStatus.BAD_REQUEST);
		
	}
}
