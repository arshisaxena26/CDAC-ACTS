package com.app.core;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomerShippingAddress {
	// private data members
	private String city, state, country, zipCode;
	private ArrayList<String> phoneNumbers = new ArrayList<>();

	// Parameterized Constructor
	public CustomerShippingAddress(String city, String state, String country, String code, String... phoneNumber) {
		this.city = city;
		this.state = state;
		this.country = country;
		zipCode = code;
		phoneNumbers.addAll(Arrays.asList(phoneNumber));
	}

	// Getter
	public ArrayList<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	// Overriding toString method to display Class' data members
	@Override
	public String toString() {
		return "\nCustomerShippingAddress [city=" + city + ", state=" + state + ", country=" + country + ", zipCode="
				+ zipCode + ", phoneNumbers=" + phoneNumbers.get(0) + phoneNumbers.get(1) + "]";
	}
}
