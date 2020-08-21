package com.app.core;

public class CustomerShippingAddress {
	private String city, state, country, zipCode;
	private String[] phoneNumbers = new String[2];

	public CustomerShippingAddress(String city, String state, String country, String code, String landline,
			String mobile) {
		this.city = city;
		this.state = state;
		this.country = country;
		zipCode = code;
		phoneNumbers[0] = landline;
		phoneNumbers[1] = mobile;
	}

	@Override
	public String toString() {
		return "---Customer's Shipping Address---\nCity: " + city + "\nState: " + state + "\nCountry: " + country
				+ "\nZIP CODE: " + zipCode + "\nPhone Numbers: " + phoneNumbers;
	}
}
