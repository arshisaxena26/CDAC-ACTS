package com.app.utils;

import java.util.ArrayList;
import static com.app.utils.ValidationRules.*;
import com.app.core.Customer;
import com.app.core.CustomerShippingAddress;
import com.app.custom_exceptions.CustomerHandlingException;

//Class to populate ArrayList with Sample Data
public class CollectionUtils {
	public static ArrayList<Customer> populateSampleData() throws CustomerHandlingException {
		ArrayList<Customer> customerList = new ArrayList<>();

		Customer customer = new Customer("Arshi", validateEmail("arshi@gmail.com"), validatePassword("@R$hi123"),
				validateCustomerType("SILVER"), validateDateOfBirth("1993-11-26"), validateRegAmount(1000));
		customer.linkShippingAddr(
				new CustomerShippingAddress("Jaipur", "Rajashthan", "India", "302021", "0141-40197xx", "98290xxxxx"));
		customerList.add(customer);

		customer = new Customer("Akshat", validateEmail("akshat@gmail.com"), validatePassword("@R$hi123"),
				validateCustomerType("GOLD"), validateDateOfBirth("1960-02-21"), validateRegAmount(500));
		customer.linkShippingAddr(
				new CustomerShippingAddress("Jaipur", "Rajasthan", "India", "302021", "0141-401xxxx", "94140xxxxx"));
		customerList.add(customer);

		customer = new Customer("Mayank", validateEmail("mayank@gmail.com"), validatePassword("@R$hi123"),
				validateCustomerType("PLATINUM"), validateDateOfBirth("1995-11-16"), validateRegAmount(1500));
		customer.linkShippingAddr(new CustomerShippingAddress("Indore", "MadhyaPradesh", "India", "402030",
				"0221-309xxxx", "997788xxxx"));
		customerList.add(customer);

		customer = new Customer("Racsha", validateEmail("racsha@gmail.com"), validatePassword("@R$hi123"),
				validateCustomerType("SILVER"), validateDateOfBirth("1996-12-25"), validateRegAmount(2000));
		customer.linkShippingAddr(new CustomerShippingAddress("Haldwani", "Uttarakhand", "India", "202011",
				"0112-890xxxx", "98257xxxxx"));
		customerList.add(customer);

		customer = new Customer("Shreyasi", validateEmail("shreyasi@gmail.com"), validatePassword("@R$hi123"),
				validateCustomerType("GOLD"), validateDateOfBirth("1995-09-19"), validateRegAmount(2500));
		customer.linkShippingAddr(new CustomerShippingAddress("Indore", "MadhyaPradesh", "India", "402030",
				"0221-5678xxx", "77889xxxxx"));
		customerList.add(customer);

		return customerList;
	}
}
