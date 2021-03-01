package services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import core.Student;

public class StudentSortingServices {

	public static List<Student> sortStudentsGPAListMap(Map<String, Student> hm) {

		// Map values to ArrayList
		ArrayList<Student> list = new ArrayList<>(hm.values());

		// Using Anonymous Class
		Collections.sort(list, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				System.out.println("Sorting by GPA");
				int ret = ((Double) o1.getGpa()).compareTo(o2.getGpa());
				return ret;
			}
		});
		return list;
	}

	public static List<Student> sortStudentsDoBListMap(Map<String, Student> hm) {

		// Map values to ArrayList
		ArrayList<Student> list = new ArrayList<>(hm.values());

		// Using Anonymous Class
		Collections.sort(list, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				System.out.println("Sorting by DOB");
				return o1.getDob().compareTo(o2.getDob());
			}
		});
		return list;
	}
}
