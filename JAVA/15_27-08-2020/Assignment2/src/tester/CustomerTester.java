package tester;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

import static com.app.utils.ValidationRules.*;
import com.app.core.Customer;
import com.app.core.CustomerShippingAddress;
import com.app.custom_exceptions.CustomerHandlingException;

import static com.app.utils.CollectionUtils.*;

public class CustomerTester {

	public static void main(String[] args) throws CustomerHandlingException {
		try (Scanner sc = new Scanner(System.in)) {

			// Creating Map of objects of Customer Class with Sample data
			HashMap<String, Customer> customerMap = populateMap(populateSampleData()); // calling CollectionUtils's
																						// static method

			boolean exit = false;
			while (!exit) {
				System.out.println("\nOPTIONS");
				System.out.println("1. Register New Customer");
				System.out.println("2. Display All Customer Details");
				System.out.println("3. Assign Shipping Address");
				System.out.println("4. Unsubscribe Customer");
				System.out.println("5. Display Phone numbers of all senior citizens");
				System.out.println("6. Sort Customers by Email");
				System.out.println("10. Exit");

				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println(
								"Enter Customer Email,Name,Password(Atleast 8 characters long),Customer Type(SILVER,GOLD,PLATINUM),DOB(yyyy-MM-dd) and Registration Amount(multiples of 500)");
						String email = validateEmail(sc.next());

						// Mapping to HashMap
						if (customerMap.putIfAbsent(email,
								new Customer(email, sc.next(), validatePassword(sc.next()),
										validateCustomerType(sc.next().toUpperCase()), validateDateOfBirth(sc.next()),
										validateRegAmount(sc.nextDouble()))) != null)
							throw new CustomerHandlingException("Email Already Exists");
						System.out.println("Customer Registration Successful");

						break;

					case 2:
						// Collection view of HashMap
						for (Customer c : customerMap.values())
							System.out.println(c);
						break;

					case 3:
						System.out.println("Enter Email");

						// Getting value of the specified key
						Customer cust = customerMap.get(validateEmail(sc.next()));

						if (cust == null)
							throw new CustomerHandlingException("Email NOT Found");

						System.out.println("Enter City,State,Country,ZIP Code,Phone Numbers(Landline,Mobile)");

						// calling method on retrieved value
						cust.linkShippingAddr(new CustomerShippingAddress(sc.next(), sc.next(), sc.next(), sc.next(),
								sc.next(), sc.next()));

						break;

					case 4:
						System.out.println("Enter Email");

						// Removing entry if key is present
						if (customerMap.remove(validateEmail(sc.next())) == null)
							throw new CustomerHandlingException("Email NOT Found");
						System.out.println("Customer Unsubscribed");
						break;

					case 5:
						// Collection view of HashMap
						for (Customer c : customerMap.values()) {
							if (c.computeAgeInYears() > 55)
								System.out.println("Phone Numbers:" + c.getCustShippingAddr().getPhoneNumbers());
						}
						break;

					case 6:
						// Creating TreeMap to sort by email
						TreeMap<String, Customer> customerTree = new TreeMap<>(customerMap); // HashMap to TreeMap

						// Using Collection View of TreeMap
						for (Customer c : customerTree.values())
							System.out.println(c);
						break;

					case 10:
						System.out.println("GOODBYE!!");
						exit = true;
						break;

					default:
						System.out.println("Invalid Input.Try Again!");
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
