package tester;

import java.text.SimpleDateFormat;

import com.app.core.Employee;
import com.app.core.Employee1;

public class EmployeeTester {

	public static void main(String[] args) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Employee e1 = new Employee(101, "abc", "rnd", 12345, sdf.parse("1-5-2020"));
			Employee e2 = new Employee(101, "abc", "dev", 12345, sdf.parse("1-5-2020"));

			System.out.println(e1.equals(e2)); // Equals overridden--same id

			Employee1 emp1 = new Employee1(101, "abc", "rnd", 12345, sdf.parse("1-5-2020"));
			Employee1 emp2 = new Employee1(101, "abc", "rnd", 12345, sdf.parse("1-5-2020"));

			System.out.println(emp1.equals(emp2)); // Equals overridden--same id and deptID
		} catch (Exception e) {
			System.out.println("Invalid Date Format");
		}
	}

}
