package com.app.core;

public class Customer {
	// private data members
	private String name, email;

	// Parameterized Constructor
	public Customer(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	// Overriding toString to display data members values
	@Override
	public String toString() {
		return "Customer [name=" + name + ", email=" + email + "]\n";
	}
}
