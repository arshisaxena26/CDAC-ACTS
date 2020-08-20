package com.app.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.app.custom_exceptions.CustomerHandlingException;

public class ValidationRules {

	public static void validateEmail(String email) throws CustomerHandlingException {
		if (!email.contains("@"))
			throw new CustomerHandlingException("Email must contain @ character");
		if (!email.endsWith(".com"))
			throw new CustomerHandlingException("Email must end with .com");
	}

	public static void validateCustType(String custType) throws CustomerHandlingException {
		if (!((custType.contains("SILVER")) || (custType.contains("GOLD")) || (custType.contains("PLATINUM"))))
			throw new CustomerHandlingException("Choose Customer Type from \n1.SILVER\n2.GOLD\n3.PLATINUM");
	}

	public static void validateDateOfBirth(Date date) throws CustomerHandlingException {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Date reqDate = sdf.parse("01-01-1990");

			if (date.compareTo(reqDate) < 0)
				throw new CustomerHandlingException("Minimum Age required:30");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static void validateRegAmount(double regAmount)throws CustomerHandlingException
	{
		if(regAmount%500!=0)
			throw new CustomerHandlingException("Reg Amount must be in multiples of 500");
	}
}
