package tester;

import static utils.StudentCollectionUtils.populateList;
import static utils.StudentCollectionUtils.populateMap;

import java.util.Map;
import java.util.Scanner;

import core.Student;

import tasks.StudentSorterDOB;
import tasks.StudentSorterGPA;

public class StudentApplication {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			// Populating Map with Sample Data
			Map<String, Student> studentMap = populateMap(populateList());

			System.out.println("Enter file names on 2 separate lines");

			// Creating Child Threads--passing runnable instance
			Thread t1 = new Thread(new StudentSorterGPA(studentMap, sc.nextLine()), "StudentSorterGPA");
			Thread t2 = new Thread(new StudentSorterDOB(studentMap, sc.nextLine()), "StudentSorterDOB");

			// Starting Threads
			t1.start();
			t2.start();

			// Waiting on Child Threads--ensuring no orphan threads
			t1.join();
			t2.join();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
