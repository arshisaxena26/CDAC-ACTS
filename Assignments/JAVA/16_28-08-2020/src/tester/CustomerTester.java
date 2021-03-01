package tester;

import static com.app.utils.CollectionUtils.populateMap;
import static com.app.utils.CollectionUtils.populateSampleData;
import static com.app.utils.IOUtils.storeNameAndPhone;
import static com.app.utils.IOUtils.storeSortedRegAmt;
import static com.app.utils.ValidationRules.CustomerLoginAuthentication;
import static com.app.utils.ValidationRules.validateEmail;
import static com.app.utils.ValidationRules.validatePassword;
import static java.time.LocalDate.now;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.app.core.Customer;
import com.app.custom_exceptions.CustomerHandlingException;

public class CustomerTester {

	public static void main(String[] args) throws CustomerHandlingException {
		try (Scanner sc = new Scanner(System.in)) {

			// Creating Map of objects of Customer Class with Sample data
			HashMap<String, Customer> customerMap = populateMap(populateSampleData()); // calling CollectionUtils's
																						// static method

			boolean exit = false;
			while (!exit) {
				System.out.println("\nOPTIONS");
				System.out.println("1. Login");
				System.out.println("2. Pay Subscription Amount");
				System.out.println("3. File Storing names & phone numbers of senior citizens subscribed for GOLD plan");
				System.out.println("4. Add Late Fee");
				System.out.println("5. File Storing Customer Details Sorted by Registration Amount");
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
						System.out.println("Enter File Path to Store Details");
						storeNameAndPhone(customerMap, sc.next()); // Storing to File
						break;

					case 4:
						for (Customer c2 : customerMap.values())
							c2.computeLateFee();
						break;

					case 5:

						// Converting HashMap to List in order to sort details by value

						List<Map.Entry<String, Customer>> list = new LinkedList<>(customerMap.entrySet());

						// Using Anonymous Class
						Collections.sort(list, new Comparator<Map.Entry<String, Customer>>() {

							@Override
							public int compare(Entry<String, Customer> o1, Entry<String, Customer> o2) {
								if (o1.getValue().getSubscriptionAmount() < o2.getValue().getSubscriptionAmount())
									return -1;
								if (o1.getValue().getSubscriptionAmount() > o2.getValue().getSubscriptionAmount())
									return 1;
								return 0;
							}
						});

						System.out.println("Enter FileNAme");
						storeSortedRegAmt(list, sc.next()); // Storing to File
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
