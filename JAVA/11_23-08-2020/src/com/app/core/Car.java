package com.app.core;

import java.util.Date;

//Outer Class
public class Car {
	private String registrationNo, color;
	private double price;
	private Date manufactureDate;
	private Manufacture vendor = null;

	// Parameterized Constructor
	public Car(String regNo, Date manufactureDate, String color, double price) {
		registrationNo = regNo;
		this.manufactureDate = manufactureDate;
		this.color = color;
		this.price = price;
	}

	// Inner Class
	public class Manufacture {
		private String location;
		private ManufacturerName companyName;

		// Parameterized Constructor
		public Manufacture(ManufacturerName company, String location) {
			companyName = company;
			this.location = location;
		}

		// Overriding toString to display Inner Class' data members
		@Override
		public String toString() {
			return "\nManufacturer:" + companyName + "\nLocation:" + location;
		}

		// Overriding equals method to check duplicate entries for Manufacturer's Name
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Manufacture) {
				Manufacture man = (Manufacture) obj;
				return this.companyName.equals(man.companyName);
			}
			return false;
		}
	} // End of Inner Class

	// Linking Inner Class to Outer Class
	public void linkVendor(ManufacturerName companyName, String location) {
		vendor = new Manufacture(companyName, location);
	}

	// Overriding toString Method to display Outer Class' data members
	@Override
	public String toString() {
		return "\nRegistration Number:" + registrationNo + "\nManufacture Date:" + manufactureDate + "\nColor:" + color
				+ "\nPrice:" + price + vendor.toString(); // Adding Overridden toString method of Inner Class
	}

	// Overriding equals Method to check duplicate entries
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Car) {
			Car car = (Car) obj;
			return this.registrationNo.equals(car.registrationNo) && this.manufactureDate.equals(car.manufactureDate)
					&& this.vendor.equals(car.vendor); // Adding Inner Class' overridden equals method
		}
		return false;
	}

	// Getters and Setters
	public ManufacturerName getCompanyName() {
		return vendor.companyName;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public double getPrice() {
		return price;
	}

	public String getLocation() {
		return vendor.location;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
