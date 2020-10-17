package runnable_tasks;

import static java.lang.Thread.currentThread;
import static utils.StudentCollectionUtils.sortStudentsGPAListMap;

import java.util.Map;

import com.app.core.Student;

import static utils.IOUtils.storeStudentDetails;

public class GPASorter implements Runnable {
	private Map<String, Student> map;
	private String fileName;

	public GPASorter(Map<String, Student> map, String fileName) {
		super();
		this.map = map;
		this.fileName = fileName;
	}

	@Override
	public void run() {
		System.out.println(currentThread().getName() + " strted ");
		try {
			synchronized (map) {
				storeStudentDetails(sortStudentsGPAListMap(map), fileName);
			}
		} catch (Exception e) {
			System.out.println(currentThread().getName() + " error " + e);
		}
		System.out.println(currentThread().getName() + " over ");

	}

}
