package utils;

import java.time.LocalDate;
import java.util.HashMap;

import core.HireNewEmployee;

import static java.time.LocalDate.*;

import customException.CustomHandlingException;

public class ValidationRules {
	
	public static LocalDate validateDateOfBirth(String dateString) throws CustomHandlingException{
		LocalDate dob = parse(dateString);
		
		//Barring Future Dates
		if(dob.isAfter(now()))
			throw new CustomHandlingException("Invalid Date of Birth");
		return dob;
	}
	
	//Checking for entries
	public static boolean validateRegisteredEmployees(HashMap<String, HireNewEmployee> empMap) throws CustomHandlingException{
		if(empMap.isEmpty())
			throw new CustomHandlingException("No Registered Employees!");
		return true;
	}
	
	//Validating DeptID
	public static String validateDeptID(HashMap<String, HireNewEmployee> empMap,String deptID) throws CustomHandlingException{
		for(HireNewEmployee e: empMap.values()) {
			if(!(e.getDeptId().equals(deptID)))
				throw new CustomHandlingException("Invalid Deptartment ID");
		}
		return deptID;
	}
}
