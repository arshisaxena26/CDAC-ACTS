package tester;

import static utils.StudentCollectionUtils.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import com.app.core.Student;

import runnable_tasks.DobSorter;
import runnable_tasks.GPASorter;
import runnable_tasks.SubjectSorter;

public class TestCollIoThreads {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			// Get populated student map from CollectionUtils
			Map<String, Student> studentMap = populateMap(populateList());
			ArrayList<Thread> threads = new ArrayList<>();

			threads.add(new Thread(new GPASorter(studentMap, "gpa.txt"), "gpa_sorter"));
			threads.add(new Thread(new DobSorter(studentMap, "dob.txt"), "dob_sorter"));
			threads.add(new Thread(new SubjectSorter(studentMap, "subject.txt"), "subject_sorter"));

			for (Thread t : threads)
				t.start();

			for (Thread t : threads)
				t.join();

			System.out.println("child thrds completed exec");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("main over....");
	}
}
