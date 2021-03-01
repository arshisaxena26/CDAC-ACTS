package utils;

import java.time.LocalDate;
import java.util.ArrayList;

import core.VolunteerInformation;

import static java.time.LocalDate.*;

import custom_exception.CustomHandlingException;

public class ValidationRules {

	public static LocalDate validateDOB(String dateString) throws CustomHandlingException {
		LocalDate dob = parse(dateString);

		if (dob.isBefore(parse("1990-01-01")))
			throw new CustomHandlingException("Volunteer Minimum Age Criteria unmet.");
		return dob;
	}

	public static boolean validateAvailablity(String str) throws CustomHandlingException {
		str = str.toUpperCase();
		if (str.equals("YES"))
			return true;
		if (str.equals("NO"))
			return false;
		throw new CustomHandlingException("Invalid Input");
	}

	public static boolean validateDuplicateEnteries(VolunteerInformation info, ArrayList<VolunteerInformation> vList)
			throws CustomHandlingException {
		for (VolunteerInformation v : vList) {
			if ((v.getvName().equals(info.getvName())) && (v.getDob().equals(info.getDob())))
				throw new CustomHandlingException("Duplicate Enteries Not Allowed.");
		}
		return true;
	}

	public static int validateVolunteerID(int volunteerID, ArrayList<VolunteerInformation> vList)
			throws CustomHandlingException {
		for (VolunteerInformation v : vList) {
			if (v.getVolunteerId() == volunteerID)
				return volunteerID;
		}
		throw new CustomHandlingException("Invalid Volunteer ID");
	}
}
