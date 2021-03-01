package utils;

import java.util.ArrayList;

import core.VolunteerInformation;
import custom_exception.CustomHandlingException;

import static utils.ValidationRules.*;

public class CollectionUtils {

	public static ArrayList<VolunteerInformation> populateVolunteersList() throws CustomHandlingException {

		ArrayList<VolunteerInformation> vList = new ArrayList<>();

		VolunteerInformation vInfo = new VolunteerInformation(1, "Susan", validateAvailablity("yes"),
				validateDOB("1993-11-26"));
		vInfo.volunteerHobbies("Dance");
		vInfo.volunteerHobbies("Bowling");
		vList.add(vInfo);

		vInfo = new VolunteerInformation(2, "Janice", validateAvailablity("no"), validateDOB("1991-12-21"));
		vInfo.volunteerHobbies("Acrobatics");
		vInfo.volunteerHobbies("Bowling");
		vList.add(vInfo);

		vInfo = new VolunteerInformation(3, "John", validateAvailablity("yes"), validateDOB("1996-01-16"));
		vInfo.volunteerHobbies("Dance");
		vInfo.volunteerHobbies("Bowling");
		vList.add(vInfo);

		vInfo = new VolunteerInformation(4, "Emily", validateAvailablity("no"), validateDOB("1998-04-09"));
		vInfo.volunteerHobbies("Ice Skating");
		vInfo.volunteerHobbies("Karate");
		vList.add(vInfo);

		vInfo = new VolunteerInformation(5, "Bob", validateAvailablity("no"), validateDOB("1999-09-07"));
		vInfo.volunteerHobbies("Ice Skating");
		vInfo.volunteerHobbies("Acrobatics");
		vList.add(vInfo);

		return vList;
	}
}
