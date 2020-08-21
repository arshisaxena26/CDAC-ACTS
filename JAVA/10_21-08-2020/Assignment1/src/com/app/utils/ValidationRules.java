package com.app.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.app.core.Customer;
import com.app.core.CustomerType;
import com.app.custom_exceptions.CustomerHandlingException;
import static com.app.core.CustomerType.*;

public class ValidationRules {
	public static SimpleDateFormat sdf;
	public static Date begDate;

	static {
		sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			begDate = sdf.parse("01-01-1990");
		} catch (ParseException e) {
			System.out.println("Date not in Correct Format" + e);
		}
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

	public static Date validateDateOfBirth(String dateString) throws ParseException, CustomerHandlingException {
		Date date = sdf.parse(dateString);
		if (date.before(begDate))
			throw new CustomerHandlingException("Minimum Age required:30");
		return date;
	}

	public static double validateRegAmount(double regAmount) throws CustomerHandlingException {
		if (regAmount % 500 != 0)
			throw new CustomerHandlingException("Reg Amount must be in multiples of 500");
		return regAmount;
	}

	public static Customer CustomerLoginAuthentication(String email, String pwd, Customer[] custs)
			throws CustomerHandlingException {
		for (Customer c : custs) {
			if (c != null)
				if (c.getEmail().equals(email) && (c.getPassword().equals(pwd)))
					return c;
		}
		throw new CustomerHandlingException("Invalid Email or Password");
	}

	public static CustomerType validateCustomerType(String custType) {
		return valueOf(custType);
	}

	public static Customer validateMatchingCustName(String name, Customer[] cust) throws CustomerHandlingException {
		for (Customer c : cust) {
			if (c != null)
				if (c.getName().equals(name))
					return c;
		}
		throw new CustomerHandlingException("Customer Not Found");
	}

	public static Customer validateShippingAddr(String email, Customer[] cust) throws CustomerHandlingException {
		for (Customer c : cust) {
			if (c != null)
				if (c.getEmail().equals(email) && c.getCustShippingAddr() != null)
					return c;
		}
		throw new CustomerHandlingException("Shipping Address NOT Assigned");
	}
}
