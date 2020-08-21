package tester;

import java.util.Scanner;
import static com.app.utils.ValidationRules.*;
import com.app.Customer;

public class CustomerTester {

	public static void main(String[] args) {
		int exception = 0;
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
				System.out.println("10. Exit");

				switch (sc.nextInt()) {
				case 1:
					exception = 1;
					System.out.println(
							"Enter Customer Name,Email,Password(Atleast 8 characters long),Customer Type(SILVER,GOLD,PLATINUM),DOB(dd-MM-yyyy) and Registration Amount(multiples of 500)");
					cust[counter++] = new Customer(sc.next(), validateEmail(sc.next()), validatePassword(sc.next()),
							validateCustType(sc.next()), validateDateOfBirth(sc.next()),
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
					exception = 2;
					boolean flag = false;
					if (!noCustomers) {
						System.out.println("Enter Email and Password");
						for (Customer c : cust) {
							if (c.getEmail().equals(validateEmail(sc.next()))
									&& (c.getPassword().equals(validatePassword(sc.next())))) {
								System.out.println("Login Successful!");
								System.out.println(c);
								flag = true;
							}
						}
						if (flag == false)
							System.out.println("Invalid Email or Password");
					} else
						System.out.println("No Customers Found.Sign Up First! ");
					break;

				case 4:
					exception = 3;
					flag = false;
					if (!noCustomers) {
						System.out.println("Enter Email, Old Password and New Password");
						for (Customer c : cust) {
							if (c.getEmail().equals(validateEmail(sc.next()))
									&& c.getPassword().equals(validatePassword(sc.next()))) {
								c.setPassword(sc.next());
								System.out.println("Password Updated Successfully!");
								flag = true;
							}
						}
						if (flag == false)
							System.out.println("Matching Email or Password Not Found");
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
			if (exception == 1)
				System.out.println("Customer Registration Failed");
			else if (exception == 2)
				System.out.println("Customer Login Failed");
			else
				System.out.println("Password Updation Failed");
			System.exit(0);
		}

	}

}
