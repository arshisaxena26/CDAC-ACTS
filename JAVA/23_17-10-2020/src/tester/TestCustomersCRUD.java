package tester;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;
import dao.*;
import pojos.Customer;

public class TestCustomersCRUD {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		try (Scanner sc = new Scanner(System.in)) {

			CustomersDaoImpl dao = new CustomersDaoImpl();
			boolean exit = false;

			while (!exit) {
				System.out.println("\n1.Login");
				System.out.println("2.Registration");
				System.out.println("3.Change Password");
				System.out.println("4.Unsubscribe");
				System.out.println("5.Exit");

				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter Email and Password");
						Customer customer = dao.authenticateUser(sc.next(), sc.next());
						if (customer == null) {
							System.out.println("Invalid Email or Password");
							break;
						}
						System.out.println(customer);
						break;

					case 2:
						System.out.println(
								"Enter the following: \nDeposit Amount\nCustomer Email\nCustomer Name\nCustomer Password\nRegistration Date(year-month-day)\nCustomer Role");
						System.out.println(dao.customerRegistration(sc.nextDouble(), sc.next(), sc.next(), sc.next(),
								Date.valueOf(sc.next()), sc.next()));
						break;

					case 3:
						System.out.println("Enter Email, Old Pasword and New Password");
						System.out.println(dao.changeCustomerPassword(sc.next(), sc.next(), sc.next()));
						break;

					case 4:
						System.out.println("Enter Customer ID");
						System.out.println(dao.unsubscribeCustomer(sc.nextInt()));
						break;

					case 5:
						dao.cleanup();
						exit = true;
						System.out.println("GOODBYE!");
						break;

					default:
						System.out.println("Invalid Input.");
						break;
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
	}
}
