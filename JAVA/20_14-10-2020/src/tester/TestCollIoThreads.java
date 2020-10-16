package tester;

import static utils.StudentCollectionUtils.*;

import java.util.Map;
import java.util.Scanner;

import com.app.core.Student;

import runnable_tasks.DobSorter;
import runnable_tasks.GPASorter;
import runnable_tasks.SubjectSorter;

public class TestCollIoThreads {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			
			//Get populated student map from CollectionUtils
			Map<String, Student> studentMap = populateMap(populateList());
			
			//Create tasks, Attach threads to runnable tasks and Start
			Thread t1 = new Thread(new GPASorter(studentMap, "gpa.txt"), "gpa_sorter");
			Thread t2 = new Thread(new DobSorter(studentMap, "dob.txt"), "dob_sorter");
			Thread t3 = new Thread(new SubjectSorter(studentMap, "subject.txt"), "subject_sorter");
			
			//Applying Locks
			synchronized (t1) {
				t1.start();
			}
			
			synchronized (t2) {
				t2.start();
			}
			
			synchronized (t3) {
				t3.start();
			}
			
			System.out.println("main waiting for child thrds to finish exec");
			t1.join();
			t2.join();
			t3.join();
			
			System.out.println("child thrds completed exec");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("main over....");

	}

}
