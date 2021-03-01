package tester;

import static utils.StudentCollectionUtils.populateList;

import java.util.List;
import java.util.Scanner;
import com.app.core.Student;
import com.app.core.Subject;

public class TestLambda {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			List<Student> studentList = populateList();

			boolean exit = false;

			while (!exit) {
				System.out.println("\n1. Print Student List");
				System.out.println("2. Print Average GPA of JAVA students");
				System.out.println("3. Print Name of DBT Topper");
				System.out.println("4. Print List of JAVA Students sorted by DOB");
				System.out.println("5. Exit");

				switch (sc.nextInt()) {
				case 1:
					studentList.forEach(i -> System.out.println(i));
					break;

				case 2:
					double avg = studentList.stream().filter(i -> i.getSubject().equals(Subject.JAVA))
							.mapToDouble(i -> i.getGpa()).average().orElse(000);
					System.out.println(avg);
					break;

				case 3:
					String name = studentList.stream().filter(i -> i.getSubject().equals(Subject.DBT))
							.max((i, j) -> ((Double) i.getGpa()).compareTo(j.getGpa())).get().getName();
					System.out.println(name);
					break;

				case 4:
					studentList.stream().filter(i -> i.getSubject().equals(Subject.JAVA))
							.sorted((i, j) -> i.getDob().compareTo(j.getDob())).forEach(i -> System.out.println(i));
					break;

				case 5:
					System.out.println("GOODBYE!");
					exit = true;
					break;

				default:
					System.out.println("Invalid Input.");
					break;
				}
			}
		}
	}
}