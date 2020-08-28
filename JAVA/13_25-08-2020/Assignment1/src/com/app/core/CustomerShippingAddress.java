package com.app.core;

public class CustomerShippingAddress {
	// private data members
	private String city, state, country, zipCode;
	private String[] phoneNumbers = new String[2];

	// Parameterized Constructor
	public CustomerShippingAddress(String city, String state, String country, String code, String landline,
			String mobile) {
		this.city = city;
		this.state = state;
		this.country = country;
		zipCode = code;
		phoneNumbers[0] = landline;
		phoneNumbers[1] = mobile;
	}

	// Overriding toString method to display Class' data members
	@Override
	public String toString() {
		return "\n---Customer's Shipping Address---\nCity: " + city + "\nState: " + state + "\nCountry: " + country
				+ "\nZIP CODE: " + zipCode + "\nPhone Numbers: " + phoneNumbers[0] + " , " + phoneNumbers[1];
	}
}
