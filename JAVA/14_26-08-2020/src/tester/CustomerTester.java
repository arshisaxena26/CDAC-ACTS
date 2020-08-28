package tester;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

import static com.app.utils.ValidationRules.*;
import com.app.core.Customer;

import static com.app.utils.CollectionUtils.*;

public class CustomerTester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			// Creating HashSet of objects of Customer Class with Sample data
			HashSet<Customer> customerSet = populateHashSet(); // calling CollectionUtils's static method

			boolean exit = false;
			while (!exit) {
				System.out.println("\nOPTIONS");
				System.out.println("1. Register New Customer");
				System.out.println("2. Display All Customer Details");
				System.out.println("3. Sort Customer Details by Email");
				System.out.println("4. Sort Customer Details by DOB and Registration Amount");
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
					TreeSet<Customer> customertree = new TreeSet<>(customerSet);// HashSet to TreeSet
					System.out.println("\n-----Sorted by Email-----");
					for (Customer c : customertree)
						System.out.println(c);
					break;

				case 4:
					TreeSet<Customer> customerTreeCustom = new TreeSet<>(new Comparator<Customer>() {
						// Inner Anonymous Class
						@Override
						public int compare(Customer cust1, Customer cust2) {
							int value = cust1.getDate().compareTo(cust2.getDate()); // LocalDate's compareTo
							if (value == 0)
								return cust1.getCustType().compareTo(cust2.getCustType()); // Enum's compareTo
							return value;
						}
					});
					customerTreeCustom.addAll(customerSet); // HashSet values added to TreeSet
					for (Customer c : customerTreeCustom)
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
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
