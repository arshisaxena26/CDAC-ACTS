package com.app.core;

import java.util.Date;

public class Customer {
	private String name, email, password;
	private CustomerType custType;
	private Date date;
	private double regAmount;
	private CustomerShippingAddress custShippingAddr;

	public Customer(String name, String email, String pwd, CustomerType type, Date date, double amt) {
		this.name = name;
		this.email = email;
		password = pwd;
		custType = type;
		this.date = date;
		regAmount = amt;
	}

	public String toString() {
		return "Customer Name: " + name + "\nEmail: " + email + "\nCustomer Type: " + custType + "\nDate of Birth: "
				+ date + "\nAmount: " + regAmount + custShippingAddr;
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

	public CustomerShippingAddress getCustShippingAddr() {
		return custShippingAddr;
	}

	public void linkShippingAddr(CustomerShippingAddress custShipAddr) {
		custShippingAddr = custShipAddr;
	}
}
