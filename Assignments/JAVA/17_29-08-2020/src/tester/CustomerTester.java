package tester;

import static com.app.utils.CollectionUtils.populateMap;
import static com.app.utils.CollectionUtils.populateSampleData;
import static com.app.utils.IOUtils.readData;
import static com.app.utils.IOUtils.writeData;
import static com.app.utils.ValidationRules.CustomerLoginAuthentication;
import static com.app.utils.ValidationRules.validateCustomer;
import static com.app.utils.ValidationRules.validateEmail;
import static com.app.utils.ValidationRules.validatePassword;
import static java.time.LocalDate.now;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import com.app.core.Customer;
import com.app.custom_exceptions.CustomerHandlingException;

public class CustomerTester {

	public static void main(String[] args) throws CustomerHandlingException, ClassNotFoundException, IOException {
		try (Scanner sc = new Scanner(System.in)) {

			// DeSerialization
			HashMap<String, Customer> customerMap = readData("customers.ser");

			// Populating with Sample data
			if (customerMap.isEmpty())
				customerMap.putAll(populateMap(populateSampleData()));

			boolean exit = false;
			while (!exit) {
				System.out.println("\nOPTIONS");
				System.out.println("1. Login");
				System.out.println("2. Pay Subscription Amount");
				System.out.println("3. Add Late Fee");
				System.out.println("4. Unsbscribe Customer");
				System.out.println("10. Exit");

				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter Email and Password");
						Customer c = CustomerLoginAuthentication(validateEmail(sc.next()), validatePassword(sc.next()),
								customerMap); // Validating Customer Login Authentication
						System.out.println("Login Successful!\n" + c);
						break;

					case 2:
						System.out.println("Enter Email and Subscription Amount");
						Customer c1 = customerMap.get(validateEmail(sc.next()));
						c1.setSubscriptionAmount(sc.nextDouble()); // Updating Subscription Amount
						c1.setSubscriptionPaidDate(now()); // Updating Subscription Date
						break;

					case 3:
						for (Customer c2 : customerMap.values())
							c2.computeLateFee();
						break;

					case 4:
						// Validating and Removing Customer
						System.out.println("Enter Email");
						String email = sc.next();
						if (validateCustomer(email, customerMap))
							customerMap.remove(email);
						System.out.println("Customer Unsubscribed!");

						break;

					case 10:
						// Serialization
						writeData(customerMap, "customers.ser");
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
