package com.app.core;

public class Cart {
	// private data members
	private int quantity, index;
	private String title;
	private double totalprice;

	// Parameterized Constructor
	public Cart(int sno, int quantity, String title, double price) {
		this.index = sno;
		this.quantity = quantity;
		this.title = title;
		this.totalprice = quantity * price;
	}

	// Overriding toString to display data member values
	@Override
	public String toString() {
		return index + "\t" + title + "\t\t    " + quantity + "\t\t" + totalprice;
	}

	// Getters and Setters
	public String getTitle() {
		return title;
	}

	public double getTotalprice() {
		return totalprice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getIndex() {
		return index;
	}
}
