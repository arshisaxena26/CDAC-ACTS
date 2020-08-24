package com.app.core;

import java.util.Date;

public class Car {
	private String registrationNo, color;
	private double price;
	private Date manufactureDate;

	public Car(String regNo, Date manufactureDate, String color, double price) {
		registrationNo = regNo;
		this.manufactureDate = manufactureDate;
		this.color = color;
		this.price = price;

	}

	public class Manufacture {
		private String location;
		private ManufacturerName companyName;

		public Manufacture(ManufacturerName company, String location) {
			companyName = company;
			this.location = location;
		}

		public ManufacturerName getCompanyName() {
			return companyName;
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
			return location;
		}

		public void setPrice(double price) {
			Car.this.price = price;
		}

		public String toString() {
			return "Registration Number:" + registrationNo + "\nManufacture Date:" + manufactureDate + "\nColor:"
					+ color + "\nPrice:" + price + "\nManufacturer:" + companyName + "\nLocation:" + location;
		}

	}

}
