package com.app.custom_exceptions;

public class CustomerHandlingException extends Exception {
	public CustomerHandlingException(String errorMsg) {
		super(errorMsg);
	}
}
