package com.app.utils;

import java.time.LocalDate;
import com.app.core.CustomerType;
import com.app.custom_exceptions.CustomerHandlingException;
import static com.app.core.CustomerType.*;
import static java.time.LocalDate.*;

public class ValidationRules {
	public static LocalDate begDate;

	// static Initializer Block to initialize static data members
	static {
		begDate = parse("1950-01-01");
	}

	public static String validateEmail(String email) throws CustomerHandlingException {
		if (!((email.contains("@")) && (email.endsWith(".com"))))
			throw new CustomerHandlingException("Email must contain @ character and end with .com");
		return email;
	}

	public static String validatePassword(String password) throws CustomerHandlingException {
		if (password.length() < 8)
			throw new CustomerHandlingException("Password must be atleast 8 characters");

		return password;
	}

	public static LocalDate validateDateOfBirth(String dateString) throws CustomerHandlingException {
		LocalDate date = parse(dateString);
		if (date.isBefore(begDate))
			throw new CustomerHandlingException("Minimum Age required:30");
		return date;
	}

	public static double validateRegAmount(double regAmount) throws CustomerHandlingException {
		if (regAmount % 500 != 0)
			throw new CustomerHandlingException("Reg Amount must be in multiples of 500");
		return regAmount;
	}

	public static CustomerType validateCustomerType(String custType) throws CustomerHandlingException {
		try {
			valueOf(custType);
		} catch (IllegalArgumentException e) {
			throw new CustomerHandlingException("Invalid Customer Type");
		}
		return valueOf(custType);
	}
}
