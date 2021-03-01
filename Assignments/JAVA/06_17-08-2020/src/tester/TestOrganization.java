package tester;

import java.util.Scanner;

import com.app.org.Employee;
import com.app.org.Manager;
import com.app.org.Worker;

public class TestOrganization {

	public static void main(String[] args) {
		System.out.println("Enter Total Employees");

		Scanner sc = new Scanner(System.in);

		Employee[] emp = new Employee[sc.nextInt()];

		int counter = 0;
		boolean exit = false;
		while (!exit) {
			System.out.println("----OPTIONS------");
			System.out.println("1. Hire Manager");
			System.out.println("2. Hire Worker");
			System.out.println("3. Display information of all employees");
			System.out.println("10 Exit");

			switch (sc.nextInt()) {
			case 1:
				if (counter < emp.length) {
					System.out.println("Enter Manager's ID, Name, Department ID, Basic Salary and Performance Bonus");
					int id=sc.nextInt();
					sc.nextLine();
					emp[counter++] = new Manager(id, sc.nextLine(), sc.nextInt(), sc.nextDouble(),
							sc.nextDouble());
				} else
					System.out.println("No Vacancies");
				break;

			case 2:
				if (counter < emp.length) {
					System.out.println("Enter Worker's ID, Name, Department ID, Basic Salary,Hours Worked and Hourly Rate");
					int id=sc.nextInt();
					sc.nextLine();
					emp[counter++] = new Worker(id,sc.nextLine(), sc.nextInt(), sc.nextDouble(),
							sc.nextDouble(), sc.nextDouble());
				} else
					System.out.println("No Vacancies");
				break;

			case 3:
				for (Employee e : emp) {
					if (e != null)
						System.out.println(e.toString()+"\nNet Salary: "+e.computeNetSalary()+"\n");
				}
				break;

			case 10:
				System.out.println("GOODBYE!");
				exit = true;
				break;

			default:
				System.out.println("Wrong Input.Try Again!");
				break;
			}
		}
		sc.close();
	}

}
