package tasks;

import static java.lang.Thread.currentThread;
import static utils.IOUtils.storeStudentDetails;
import static services.StudentSortingServices.*;

import java.util.Map;

import core.Student;

public class StudentSorterDOB implements Runnable {
	// private data members
	private Map<String, Student> map;
	private String fileName;

	// Parameterized Constructor
	public StudentSorterDOB(Map<String, Student> map, String fileName) {
		super();
		this.map = map;
		this.fileName = fileName;
	}

	// Overriding run() method of Runnable Interface
	@Override
	public void run() {
		try {
			storeStudentDetails(sortStudentsDoBListMap(map), fileName);
		} catch (Exception e) {
			System.out.println(currentThread().getName() + " error " + e);
		}
	}
}
