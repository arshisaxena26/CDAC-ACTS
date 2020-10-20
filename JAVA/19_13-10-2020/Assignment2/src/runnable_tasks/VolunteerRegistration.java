package runnable_tasks;

import java.util.ArrayList;

import core.VolunteerInformation;
import static services.ApplicationServices.*;

public class VolunteerRegistration implements Runnable {
	private ArrayList<VolunteerInformation> vList = new ArrayList<>();
	private VolunteerInformation volunteer;

	public VolunteerRegistration(ArrayList<VolunteerInformation> vList, VolunteerInformation volunteer) {
		this.vList = vList;
		this.volunteer = volunteer;
	}

	@Override
	public void run() {
		try {
			// Locking Shared Resource
			synchronized (vList) {
				vList = volunteerRegistration(volunteer, vList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Getter
	public VolunteerInformation getVolunteer() {
		return volunteer;
	}
}
