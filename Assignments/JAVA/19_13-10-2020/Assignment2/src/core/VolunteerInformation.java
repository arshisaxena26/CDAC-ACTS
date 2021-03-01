package core;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VolunteerInformation implements Serializable {

	private static final long serialVersionUID = 1L;

	// data members
	private int volunteerId;
	private String vName;
	private boolean isAvailable;
	private LocalDate dob;
	private List<String> hobbies = new ArrayList<>();

	// Parameterized Constructor
	public VolunteerInformation(int volunteerId, String vName, boolean isAvailable, LocalDate dob) {
		this.volunteerId = volunteerId;
		this.vName = vName;
		this.isAvailable = isAvailable;
		this.dob = dob;
	}

	// Method to add Hobbies to List
	public void volunteerHobbies(String hobby) {
		hobbies.add(hobby);
		;
	}

	@Override
	public String toString() {
		return "VolunteerInformation [volunteerId=" + volunteerId + ", vName=" + vName + ", hobbies=" + hobbies
				+ ", isAvailable=" + isAvailable + ", dob=" + dob + "]";
	}

	// Getters
	public String getvName() {
		return vName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public int getVolunteerId() {
		return volunteerId;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	// Setters
	public void setvName(String vName) {
		this.vName = vName;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}
}
