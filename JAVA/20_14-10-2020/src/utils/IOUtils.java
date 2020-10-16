package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import com.app.core.Student;

public class IOUtils {
		public static void storeStudentDetails(Collection<Student> students,String fileName) throws IOException
		{
			try(PrintWriter pw=new PrintWriter(new FileWriter(fileName)))
			{
				pw.println("Student Info sorted as per criteria");
				
				for(Student s : students) {
					pw.println(s);
					pw.println();
				}
				System.out.println("info saved ...");
			}
		}
}
