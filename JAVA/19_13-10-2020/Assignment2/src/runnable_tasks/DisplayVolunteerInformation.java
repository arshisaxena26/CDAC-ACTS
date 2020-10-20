package runnable_tasks;

import static services.ApplicationServices.*;

import java.util.ArrayList;

import core.VolunteerInformation;

public class DisplayVolunteerInformation implements Runnable {
	private ArrayList<VolunteerInformation> vList = new ArrayList<>();

	public DisplayVolunteerInformation(ArrayList<VolunteerInformation> vList) {
		super();
		this.vList = vList;
	}

	@Override
	public void run() {
		try {
			// Locking Shared Resource
			synchronized (vList) {
				displayVolunteersInformation(vList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
