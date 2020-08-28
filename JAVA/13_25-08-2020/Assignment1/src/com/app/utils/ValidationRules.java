package com.app.utils;

import java.time.LocalDate;
import java.util.ArrayList;

import com.app.core.Customer;
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

	public static boolean validateEmailDuplication(Customer newCust, ArrayList<Customer> cust)
			throws CustomerHandlingException {
		if (cust.contains(newCust))
			throw new CustomerHandlingException("Email Already Exist");
		return true;
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

	public static Customer CustomerLoginAuthentication(String email, String pwd, ArrayList<Customer> custs)
			throws CustomerHandlingException {
		for (Customer c : custs) {
			if (c.getEmail().equals(email) && (c.getPassword().equals(pwd)))
				return c;
		}
		throw new CustomerHandlingException("Invalid Email or Password");
	}

	public static CustomerType validateCustomerType(String custType) throws CustomerHandlingException {
		try {
			valueOf(custType);
		} catch (IllegalArgumentException e) {
			throw new CustomerHandlingException("Invalid Customer Type");
		}
		return valueOf(custType);
	}

	public static boolean validateAgeForDiscount(int discount, ArrayList<Customer> cust)
			throws CustomerHandlingException {
		boolean flag = false;
		for (Customer c : cust) {
			if (c.computeAgeInYears() > 55) { // Calling Customer Class' Method
				c.setRegAmount(c.getRegAmount() - (discount / 100 * c.getRegAmount())); // Calculating Discount
				flag = true;
			}
		}
		if (flag == false)
			throw new CustomerHandlingException("No Senior Citizens");
		return true;
	}
}
