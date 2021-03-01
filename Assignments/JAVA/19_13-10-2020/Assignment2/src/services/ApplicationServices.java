package services;

import static utils.ValidationRules.validateDuplicateEnteries;

import java.time.LocalDate;
import java.util.ArrayList;

import core.VolunteerInformation;
import custom_exception.CustomHandlingException;

public class ApplicationServices {
	public static void updateName(int volunteerID, ArrayList<VolunteerInformation> vList, String name) {
		for (VolunteerInformation v : vList) {
			if (v.getVolunteerId() == volunteerID) {
				v.setvName(name);
				System.out.println("Name Updated.");
			}
		}
	}

	public static void updateAvailablity(int volunteerID, ArrayList<VolunteerInformation> vList, boolean availablity) {
		for (VolunteerInformation v : vList) {
			if (v.getVolunteerId() == volunteerID) {
				v.setAvailable(availablity);
				System.out.println("Availablity Updated");
			}
		}
	}

	public static void updateDOB(int volunteerID, ArrayList<VolunteerInformation> vList, LocalDate dob) {
		for (VolunteerInformation v : vList) {
			if (v.getVolunteerId() == volunteerID) {
				v.setDob(dob);
				System.out.println("Date of Birth Updated");
			}
		}
	}

	public static void showVolunteersWithSameHobbies(ArrayList<VolunteerInformation> vList) {
		for (int i = 0; i < vList.size(); i++) {
			for (int j = i + 1; j < vList.size(); j++) {
				if (vList.get(i).getHobbies().equals(vList.get(j).getHobbies())) {
					System.out.println(
							vList.get(i).getvName() + "," + vList.get(j).getvName() + "\t" + vList.get(i).getHobbies());
				}
			}
		}
	}

	public static void displayVolunteersInformation(ArrayList<VolunteerInformation> vList) {
		vList.forEach(i -> System.out.println(i));
	}

	public static ArrayList<VolunteerInformation> volunteerRegistration(VolunteerInformation vInfo,
			ArrayList<VolunteerInformation> vList) throws CustomHandlingException {

		if (validateDuplicateEnteries(vInfo, vList))
			vList.add(vInfo);

		return vList;

	}
}
