package com.app.utils;

import java.util.ArrayList;
import java.util.Date;

import com.app.core.Car;
import com.app.core.ManufacturerName;

import custom_exceptions.CarExceptions;

public class CarValidations {

	public static boolean validateCarEntriesDuplication(String regNo, Date date, ManufacturerName manufacturer,
			ArrayList<Car.Manufacture> man) throws CarExceptions {
		for (Car.Manufacture c : man) {
			if (c != null)
				if (c.getRegistrationNo().equals(regNo) && c.getManufactureDate().equals(date)
						&& c.getCompanyName().equals(manufacturer))
					throw new CarExceptions("Duplicate Entries NOT Allowed");
		}
		return true;
	}

}
