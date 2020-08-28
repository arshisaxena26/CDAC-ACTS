package com.app.core;

import static java.time.LocalDate.*;
import static java.time.Period.*;
import java.time.LocalDate;

public class Customer implements Comparable<Customer> {
	// private data members
	private String name, email, password;
	private CustomerType custType;
	private LocalDate date;
	private double regAmount;
	private CustomerShippingAddress custShippingAddr;

	// Parameterized Constructor
	public Customer(String name, String email, String pwd, CustomerType type, LocalDate date, double amt) {
		this.name = name;
		this.email = email;
		password = pwd;
		custType = type;
		this.date = date;
		regAmount = amt;
	}

	// Overloaded Parameterized Constructor for Primary Key: Email
	public Customer(String email) {
		this.email = email;
	}

	// Overriding equals method to check for Primary Key--Email Duplication

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Customer) {
			Customer cust = (Customer) obj;
			return this.email.equals(cust.email);
		}
		return false;
	}

	// Overriding toString method to display Class' data members
	@Override
	public String toString() {
		return "\nCustomer Name: " + name + "\nEmail: " + email + "\nCustomer Type: " + custType + "\nDate of Birth: "
				+ date + "\nAmount: " + regAmount + custShippingAddr;
	}

	// Method to compute Customer's Age based on his Date of Birth and current year
	public int computeAgeInYears() {
		return between(this.date, now()).getYears();
	}

	// Overriding hashCode() as per contract
	@Override
	public int hashCode() {
		return email.hashCode(); // calling String Class' hashCode method
	}

	// Overriding compareTo method for Natural Ordering
	@Override
	public int compareTo(Customer cust) {
		return this.email.compareTo(cust.email);
	}

	// Getters and Setters
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

	public double getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}

	public CustomerShippingAddress getCustShippingAddr() {
		return custShippingAddr;
	}

	public CustomerType getCustType() {
		return custType;
	}

	public LocalDate getDate() {
		return date;
	}

	// Linking CustomerShippingAddress Class (HAS-A Relationship)
	public void linkShippingAddr(CustomerShippingAddress custShipAddr) {
		custShippingAddr = custShipAddr;
	}
}
