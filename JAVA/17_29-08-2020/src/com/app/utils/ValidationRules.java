package com.app.utils;

import static com.app.core.CustomerType.valueOf;
import static java.time.LocalDate.parse;

import java.time.LocalDate;
import java.util.HashMap;

import com.app.core.Customer;
import com.app.core.CustomerType;
import com.app.custom_exceptions.CustomerHandlingException;

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

	public static boolean validateCustomer(String email, HashMap<String, Customer> custs)
			throws CustomerHandlingException {
		if (custs.get(email) == null)
			throw new CustomerHandlingException("Customer Not Found");
		return true;
	}

	public static LocalDate validateDateOfBirth(String dateString) throws CustomerHandlingException {
		LocalDate date = parse(dateString);
		if (date.isBefore(begDate))
			throw new CustomerHandlingException("Minimum Age required:30");
		return date;
	}

	public static double validateSubAmount(double subAmount) throws CustomerHandlingException {
		if (subAmount % 500 != 0)
			throw new CustomerHandlingException("Reg Amount must be in multiples of 500");
		return subAmount;
	}

	public static CustomerType validateCustomerType(String custType) throws CustomerHandlingException {
		try {
			valueOf(custType);
		} catch (IllegalArgumentException e) {
			throw new CustomerHandlingException("Invalid Customer Type");
		}
		return valueOf(custType);
	}

	public static Customer CustomerLoginAuthentication(String email, String pwd, HashMap<String, Customer> custs)
			throws CustomerHandlingException {
		for (Customer c : custs.values()) {
			if (c.getEmail().equals(email) && (c.getPassword().equals(pwd)))
				return c;
		}
		throw new CustomerHandlingException("Invalid Email or Password");
	}
}
