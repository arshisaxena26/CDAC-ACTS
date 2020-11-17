package com.app.exc_handler;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.cust_excs.ResourceNotFoundException;
import com.app.dto.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exc, WebRequest request) {
		System.out.println("handling  res not found exc ");
		ErrorResponse errResp = new ErrorResponse(exc.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errResp, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<?> handleConstraintViolationException(ConstraintViolationException e, WebRequest request) {
		System.out.println("handling constraint violation exc");
		ErrorResponse errResp = new ErrorResponse(e.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errResp, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleAnyException(Exception exc, WebRequest request) {
		System.out.println("in handle exc");
		ErrorResponse errResp = new ErrorResponse(exc.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errResp, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
