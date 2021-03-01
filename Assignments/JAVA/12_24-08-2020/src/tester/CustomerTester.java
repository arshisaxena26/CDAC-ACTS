package tester;

import java.util.ArrayList;
import java.util.Scanner;
import static com.app.utils.ValidationRules.*;
import com.app.core.Customer;
import com.app.custom_exceptions.CustomerHandlingException;

import static com.app.utils.CollectionUtils.*;

public class CustomerTester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			// Creating ArrayList of objects of Customer Class with Sample data
			ArrayList<Customer> customerList = populateSampleData(); // calling CollectionUtils's static method

			boolean exit = false;
			while (!exit) {
				System.out.println("\nOPTIONS");
				System.out.println("1. Register New Customer");
				System.out.println("2. Display All Customer Details");
				System.out.println("3. Customer Login");
				System.out.println("4. Apply Discounts for Senior Citizens");
				System.out.println("5. Unsubscribe Customer");
				System.out.println("10. Exit");

				switch (sc.nextInt()) {
				case 1:
					System.out.println(
							"Enter Customer Name,Email,Password(Atleast 8 characters long),Customer Type(SILVER,GOLD,PLATINUM),DOB(dd-MM-yyyy) and Registration Amount(multiples of 500)");
					Customer cust = new Customer(sc.next(), validateEmail(sc.next()), validatePassword(sc.next()),
							validateCustomerType(sc.next().toUpperCase()), validateDateOfBirth(sc.next()),
							validateRegAmount(sc.nextDouble()));

					if (validateEmailDuplication(cust, customerList)) // ValidationRules' Method
						customerList.add(cust); // Adding object to ArrayList if entries unique
					System.out.println("Customer Registration Successful");
					break;

				case 2:
					for (Customer c : customerList)
						System.out.println(c);
					break;

				case 3:
					System.out.println("Enter Email and Password");
					Customer c = CustomerLoginAuthentication(validateEmail(sc.next()), validatePassword(sc.next()),
							customerList); // ValidationRules' Method
					System.out.println("Login Successful!\n" + c);
					break;

				case 4:
					System.out.println("Enter Discount%");
					if (validateAgeForDiscount(sc.nextInt(), customerList)) // ValidationRules' Method
						System.out.println("Discount Applied");
					break;

				case 5:
					System.out.println("Enter Email");
					// Using ArrayList's remove method--uses Customer Class' Overridden equals
					// method internally
					boolean unsubscribed = customerList.remove(new Customer(sc.next())); // calling primary key
																							// constructor
					if (!unsubscribed)
						throw new CustomerHandlingException("Invalid Email");
					System.out.println("Customer Unsubscribed");
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
