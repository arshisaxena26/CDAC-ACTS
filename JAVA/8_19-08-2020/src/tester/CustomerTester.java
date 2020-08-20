package tester;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.app.Customer;
import com.app.utils.ValidationRules;

public class CustomerTester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			System.out.println("Enter Total Customers");
			Customer[] cust = new Customer[sc.nextInt()];

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

			boolean exit = false;
			int counter = 0;
			boolean noCustomers = true;

			while (!exit) {
				System.out.println("OPTIONS");
				System.out.println("1. Register New Customer");
				System.out.println("2. Display All Customer Details");
				System.out.println("3. Exit");

				switch (sc.nextInt()) {
				case 1:
					System.out.println("Enter Customer's DOB(dd-MM-yyyy)");
					Date date = sdf.parse(sc.next());
					ValidationRules.validateDateOfBirth(date);

					System.out.println("Enter Customer's Email");
					String email = sc.next();
					ValidationRules.validateEmail(email);

					System.out.println("Choose Customer Type from SILVER, GOLD or PLATINUM");
					String custType = sc.next();
					ValidationRules.validateCustType(custType);

					System.out.println("Enter Registration Amount in multiples of 500");
					double regAmount = sc.nextDouble();
					ValidationRules.validateRegAmount(regAmount);
					sc.nextLine();

					System.out.println("Enter Customer Name and Password");
					cust[counter++] = new Customer(sc.nextLine(), email, sc.next(), custType, date, regAmount);
					noCustomers = false;
					System.out.println("Customer Registration Successful");
					break;

				case 2:
					if (!noCustomers) {
						for (Customer c : cust) {
							if (c != null)
								System.out.println(c);
						}
					} else
						System.out.println("No Customers Registered");
					break;

				case 3:
					System.out.println("GOODBYE!!");
					exit = true;
					break;

				default:
					System.out.println("Invalid Input.Try Again!");
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Customer Registration Failed");
			System.exit(0);
		}

	}

}
