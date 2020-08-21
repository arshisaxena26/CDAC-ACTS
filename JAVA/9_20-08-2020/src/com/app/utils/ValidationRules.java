package com.app.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.app.custom_exceptions.CustomerHandlingException;

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

	public static String validateCustType(String custType) throws CustomerHandlingException {
		if (!((custType.contains("SILVER")) || (custType.contains("GOLD")) || (custType.contains("PLATINUM"))))
			throw new CustomerHandlingException("Choose Customer Type from \n1.SILVER\n2.GOLD\n3.PLATINUM");
		return custType;
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

}
