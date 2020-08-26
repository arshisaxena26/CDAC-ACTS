package com.app.utils;

import java.util.ArrayList;
import com.app.core.Car;
import com.app.core.ManufacturerName;
import static com.app.core.ManufacturerName.*;

import custom_exceptions.CarExceptions;

public class CarValidations {

	public static boolean validateCarEntriesDuplication(ArrayList<Car> car, Car newCar) throws CarExceptions {
		for (Car c : car) {
			if (c != null)
				if (c.equals(newCar)) // Calling Car Class' Overridden equals method
					throw new CarExceptions("Duplicate Entries NOT Allowed");
		}
		return true;
	}

	public static ManufacturerName validateManufacturerName(String name) throws CarExceptions {
		try { // Checking for Valid Manufacturer Name in Enum
			valueOf(name.toUpperCase());
		} catch (IllegalArgumentException e) {
			throw new CarExceptions("Invalid Manufacturer");
		}
		return valueOf(name.toUpperCase());
	}

	// Checking if the specified location exists with any object in ArrayList
	public static boolean validateLocation(String location, ArrayList<Car> car) throws CarExceptions {
		for (Car c : car) {
			if (c != null)
				if (c.getLocation().equals(location))
					return true;
		}
		throw new CarExceptions("No Cars at " + location + " location");
	}
}
