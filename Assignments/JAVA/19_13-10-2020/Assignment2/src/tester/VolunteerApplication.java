package tester;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import static utils.CollectionUtils.*;
import static services.ApplicationServices.*;
import java.util.Scanner;
import static utils.ValidationRules.*;
import static utils.IOUtils.*;

import core.VolunteerInformation;
import custom_exception.CustomHandlingException;
import runnable_tasks.DisplayVolunteerInformation;
import runnable_tasks.VolunteerRegistration;

public class VolunteerApplication {

	public static void main(String[] args)
			throws CustomHandlingException, FileNotFoundException, ClassNotFoundException, IOException {

		try (Scanner sc = new Scanner(System.in)) {

			// DeSerialization
			ArrayList<VolunteerInformation> volunteerList = readData("Volunteers.ser");

			// Populating Sample Data from utils.CollectionUtils
			if (volunteerList.isEmpty())
				volunteerList = populateVolunteersList();

			boolean exit = false;

			while (!exit) {
				System.out.println("\n1. Add Volunteer");
				System.out.println("2. Update Volunteer Information");
				System.out.println("3. Show Volunteers Information");
				System.out.println("4. Show Volunteers with same hobbies");
				System.out.println("5. Save and Exit");

				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println(
								"Enter Volunteer ID, Volunteer Name, Availablity(yes/no), Date of birth and Hobbies(Press q to exit)");

						// Validating Information and Initializing Objects
						VolunteerRegistration volReg = new VolunteerRegistration(volunteerList,
								new VolunteerInformation(sc.nextInt(), sc.next(), validateAvailablity(sc.next()),
										validateDOB(sc.next())));

						// Adding Hobbies
						while (sc.hasNext()) {
							String hobby = sc.next();
							if (hobby.equals("q"))
								break;
							volReg.getVolunteer().volunteerHobbies(hobby);
						}

						// Creating Threads for Adding and Displaying Volunteer Information
						Thread thread_add = new Thread(volReg, "Registration");
						Thread thread_display = new Thread(new DisplayVolunteerInformation(volunteerList),
								"DisplayInformation");

						// Starting Threads
						thread_add.start();
						thread_display.start();

						// Waiting for Child Threads to finish execution
						thread_add.join();
						thread_display.join();

						break;

					case 2:
						System.out.println("Enter Volunteer ID");
						int volunteerID = validateVolunteerID(sc.nextInt(), volunteerList);

						System.out.println("1. Update Name");
						System.out.println("2. Update Availablity");
						System.out.println("3. Update Date of Birth");

						try {
							switch (sc.nextInt()) {
							case 1:
								System.out.println("Enter new name");
								updateName(volunteerID, volunteerList, sc.next());
								break;

							case 2:
								System.out.println("Enter new Availablity(yes/no)");
								updateAvailablity(volunteerID, volunteerList,
										validateAvailablity(sc.next().toUpperCase()));
								break;

							case 3:
								System.out.println("Enter new Date of Birth(year-month-day)");
								updateDOB(volunteerID, volunteerList, validateDOB(sc.next()));
								break;

							default:
								System.out.println("Invalid Input!");
								break;
							}
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						break;

					case 3:
						displayVolunteersInformation(volunteerList);
						break;

					case 4:
						showVolunteersWithSameHobbies(volunteerList);
						break;

					case 5:
						storeVolunteerInfo(volunteerList, "Volunteers.ser");
						exit = true;
						break;

					default:
						System.out.println("Invalid Input!");
						break;
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
					System.out.println("Try Again!");
				}
			}
		}
	}
}