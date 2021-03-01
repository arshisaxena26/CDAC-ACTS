package tester;

import static utils.CollectionUtils.sortEmployeesByDOB;
import static utils.IOUtils.storeEmployeeDetails;
import static utils.ValidationRules.validateRegisteredEmployees;
import static utils.ValidationRules.validateDateOfBirth;
import static utils.ValidationRules.validateDeptID;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import core.HireNewEmployee;
import customException.CustomHandlingException;

public class EmpServiceApplication {

	public static void main(String[] args) throws CustomHandlingException, IOException {
		
		//try with Resources--AutoClosable Scanner
		try (Scanner sc = new Scanner(System.in)) {
			
			//HashMap to store Employees' Details
			HashMap<String, HireNewEmployee> employees = new HashMap<>();

			boolean exit = false;

			while (!exit) {
				System.out.println();
				System.out.println("1. Hire New Employee");
				System.out.println("2. View Employee Details");
				System.out.println("3. View Employees by Department");
				System.out.println("4. Save and Exit");

				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter Employee ID, Employee Name, DOB, Salary and Department ID");

						String empID = sc.next();
						sc.nextLine();
						
						//Adding Valid Entry to HashMap
						if (employees.putIfAbsent(empID, new HireNewEmployee(empID, sc.nextLine(),
								validateDateOfBirth(sc.next()), sc.nextDouble(), sc.next())) != null) {
							System.out.println("EmployeeID Already Exist!");
							break;
						}

						System.out.println("Registration Successful!");
						break;

					case 2:
						if (validateRegisteredEmployees(employees)) {
							for (HireNewEmployee e : employees.values())
								System.out.println(e);
						}
						break;

					case 3:
						if (validateRegisteredEmployees(employees)) {
							System.out.println("Enter Department ID");
							
							//Displaying Sorted Employees' Details
							sortEmployeesByDOB(employees, validateDeptID(employees, sc.next()));
						}
						break;

					case 4:
						//Exporting Employees' Details to Text File
						storeEmployeeDetails(employees, "emp_info.txt");
						exit = true;
						break;

					default:
						System.out.println("Invalid Input. Try Again!");
						break;
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
					System.out.println("Try Again!");
				}
			}
		}

	}

}
