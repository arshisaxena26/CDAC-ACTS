package tester;

import java.util.HashSet;
import java.util.Scanner;
import static com.app.utils.ValidationRules.*;
import com.app.core.Customer;
import com.app.custom_exceptions.CustomerHandlingException;

import static com.app.utils.CollectionUtils.*;

public class CustomerTester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			// Creating HashSet of objects of Customer Class with Sample data
			HashSet<Customer> customerSet = populateSampleData(); // calling CollectionUtils's static method

			boolean exit = false;
			while (!exit) {
				System.out.println("\nOPTIONS");
				System.out.println("1. Register New Customer");
				System.out.println("2. Display All Customer Details");
				System.out.println("3. Check for Existing Customer");
				System.out.println("4. Remove Customer");
				System.out.println("10. Exit");

				switch (sc.nextInt()) {
				case 1:
					System.out.println(
							"Enter Customer Name,Email,Password(Atleast 8 characters long),Customer Type(SILVER,GOLD,PLATINUM),DOB(dd-MM-yyyy) and Registration Amount(multiples of 500)");

					// Directly Adding to HashSet as Duplicate Email values will be discarded
					// implicitly
					customerSet.add(new Customer(sc.next(), validateEmail(sc.next()), validatePassword(sc.next()),
							validateCustomerType(sc.next().toUpperCase()), validateDateOfBirth(sc.next()),
							validateRegAmount(sc.nextDouble())));

					System.out.println("Customer Registration Successful");
					break;

				case 2:
					for (Customer c : customerSet)
						System.out.println(c);
					break;

				case 3:
					System.out.println("Enter Email");
					// Using HashSet's contains method--uses overridden equals internally
					System.out.println(
							customerSet.contains(new Customer(sc.next())) ? "Customer Exists" : "Customer NOT Found");

					break;

				case 4:
					System.out.println("Enter Email");
					// Using HashSet's remove method--uses Customer Class' Overridden equals
					// method internally
					boolean unsubscribed = customerSet.remove(new Customer(sc.next())); // calling primary key
																						// constructor
					if (!unsubscribed)
						throw new CustomerHandlingException("Invalid Email");
					System.out.println("Customer Removed");
					break;

				case 10:
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
		}

	}

}
