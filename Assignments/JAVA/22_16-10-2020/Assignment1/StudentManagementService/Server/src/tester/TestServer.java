package tester;

import static utils.StudentCollectionUtils.*;

import java.io.DataInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.app.core.Student;
import com.app.core.Subject;

public class TestServer {
	public static void main(String[] args) {
		HashMap<String, Student> studentMap = populateMap(populateList());
		List<Student> specificSubjectList;

		System.out.println("Waiting For Client");

		try (ServerSocket ss = new ServerSocket(5000, 1);
				Socket ds = ss.accept();
				DataInputStream in = new DataInputStream(ds.getInputStream());
				ObjectOutputStream out = new ObjectOutputStream(ds.getOutputStream());) {

			System.out.println("Connection Established.");

			try {
				Subject selectedSubject = Subject.valueOf(in.readUTF().toUpperCase());

				specificSubjectList = studentMap.values().stream().filter(i -> i.getSubject().equals(selectedSubject))
						.filter(i -> i.getGpa() > 7.0).collect(Collectors.toList());
				out.writeObject(specificSubjectList);

			} catch (Exception e) {
				out.writeObject("Invalid Subject Selection.");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
