package tester;

import java.util.Scanner;
import static com.app.utils.ValidationRules.*;
import com.app.core.Customer;
import com.app.core.CustomerShippingAddress;

public class CustomerTester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			System.out.println("Enter Total Customers");
			Customer[] cust = new Customer[sc.nextInt()];

			boolean exit = false;
			int counter = 0;
			boolean noCustomers = true;

			while (!exit) {
				System.out.println("OPTIONS");
				System.out.println("1. Register New Customer");
				System.out.println("2. Display All Customer Details");
				System.out.println("3. Customer Login");
				System.out.println("4. Change Password");
				System.out.println("5. Assign Shipping Address");
				System.out.println("6. Place Order");
				System.out.println("10. Exit");

				switch (sc.nextInt()) {
				case 1:
					System.out.println(
							"Enter Customer Name,Email,Password(Atleast 8 characters long),Customer Type(SILVER,GOLD,PLATINUM),DOB(dd-MM-yyyy) and Registration Amount(multiples of 500)");
					cust[counter++] = new Customer(sc.next(), validateEmail(sc.next()), validatePassword(sc.next()),
							validateCustomerType(sc.next().toUpperCase()), validateDateOfBirth(sc.next()),
							validateRegAmount(sc.nextDouble()));
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
					if (!noCustomers) {
						System.out.println("Enter Email and Password");
						Customer c = CustomerLoginAuthentication(validateEmail(sc.next()), validatePassword(sc.next()),
								cust);
						System.out.println("Login Successful!\n" + c);
					} else
						System.out.println("No Customers Found.Sign Up First! ");
					break;

				case 4:
					if (!noCustomers) {
						System.out.println("Enter Email, Old Password and New Password");
						Customer c = CustomerLoginAuthentication(validateEmail(sc.next()), validatePassword(sc.next()),
								cust);
						c.setPassword(sc.next());
						System.out.println("Password Changed for " + c.getName());

					} else
						System.out.println("No Customers Found.Sign Up First! ");
					break;

				case 5:
					if (!noCustomers) {
						System.out.println("Enter Customer Name to Assign Shipping Address");
						Customer c = validateMatchingCustName(sc.next(), cust);
						System.out.println("Enter City,State,Country,ZipCode,Landline and Mobile Number");
						c.linkShippingAddr(new CustomerShippingAddress(sc.next(), sc.next(), sc.next(), sc.next(),
								sc.next(), sc.next()));
						System.out.println("Shipping Address Updated Successfully!");
					} else
						System.out.println("No Customers Found.Sign Up First! ");
					break;

				case 6:
					if (!noCustomers) {
						System.out.println("Enter Customer Email,Product Name and Quantity");
						Customer c = validateShippingAddr(sc.next(), cust);
						System.out.println("Hello " + c.getName() + "! Your Product " + sc.next() + "--Quantity:"
								+ sc.nextInt() + " will be delivered in next 3 Working Days");
					} else
						System.out.println("No Customers Found.Sign Up First! ");
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
			System.exit(0);
		}

	}

}
