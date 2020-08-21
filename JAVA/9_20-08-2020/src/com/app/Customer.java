package com.app;

import java.util.Date;

public class Customer {
	String name, email, password, custType;
	Date date;
	double regAmount;

	public Customer(String name, String email, String pwd, String type, Date date, double amt) {
		this.name = name;
		this.email = email;
		password = pwd;
		custType = type;
		this.date = date;
		regAmount = amt;
	}

	public String toString() {
		return "Customer Name: " + name + "\nEmail: " + email + "\nCustomer Type: " + custType + "\nDate of Birth: "
				+ date + "\nAmount: " + regAmount;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
