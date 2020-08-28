package com.app.custom_exceptions;

@SuppressWarnings("serial")
public class CustomerHandlingException extends Exception {
	public CustomerHandlingException(String errorMsg) {
		super(errorMsg);
	}
}
