package com.app.core;

import static java.time.LocalDate.*;
import static java.time.Period.*;

import java.io.Serializable;
import java.time.LocalDate;

//Marking Class as Serializable
public class Customer implements Serializable {

	// private data members
	private static final long serialVersionUID = 1L;
	private String name, email, password;
	private CustomerType custType;
	private LocalDate date;
	private CustomerShippingAddress custShippingAddr;
	private LocalDate subscriptionPaidDate;
	private double subscriptionAmount;

	// Parameterized Constructor
	public Customer(String email, String name, String pwd, CustomerType type, LocalDate date, double amt,
			LocalDate subscription/* , double amount */) {
		this.email = email;
		this.name = name;
		password = pwd;
		custType = type;
		this.date = date;
		subscriptionAmount = amt;
		this.subscriptionPaidDate = subscription;

	}

	// Overloaded Parameterized Constructor for Primary Key: Email
	public Customer(String email) {
		this.email = email;
	}

	// Overriding toString method to display Class' data members
	@Override
	public String toString() {
		return "\nCustomer Name: " + name + "\nEmail: " + email + "\nCustomer Type: " + custType + "\nDate of Birth: "
				+ date + "\nSubscription Amount: " + subscriptionAmount + "\nSubscription Paid Date:"
				+ subscriptionPaidDate + custShippingAddr;
	}

	// Method to compute Customer's Age based on his Date of Birth and current year
	public int computeAgeInYears() {
		return between(this.date, now()).getYears();
	}

	// Getters and Setters

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setSubscriptionAmount(double subscriptionAmount) {
		this.subscriptionAmount = subscriptionAmount;
	}

	public void setSubscriptionPaidDate(LocalDate subscriptionPaidDate) {
		this.subscriptionPaidDate = subscriptionPaidDate;
	}

	public CustomerShippingAddress getCustShippingAddr() {
		return custShippingAddr;
	}

	public CustomerType getCustType() {
		return custType;
	}

	public double getSubscriptionAmount() {
		return subscriptionAmount;
	}

	public String getName() {
		return name;
	}

	// Linking CustomerShippingAddress Class (HAS-A Relationship)
	public void linkShippingAddr(CustomerShippingAddress custShipAddr) {
		custShippingAddr = custShipAddr;
	}

	public void computeLateFee() {
		if (!(subscriptionPaidDate.getMonth().equals(now().getMonth()))) {
			double lateFee = 0.2 * subscriptionAmount;
			subscriptionAmount += lateFee;
		}
	}
}
