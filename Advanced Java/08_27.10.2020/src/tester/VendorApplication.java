package tester;

import static java.time.LocalDate.parse;
import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.VendorDaoImpl;

public class VendorApplication {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getSf()) {
			boolean exit = false;
			VendorDaoImpl vendorDao = new VendorDaoImpl();
			while (!exit) {
				System.out.println("\n1.Vendor Login");
				System.out.println("2.List Specific Vendors");
				System.out.println("3.Apply Discounts");
				System.out.println("4.Exit");

				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter Vendor Email and Password");
						System.out.println("Login Successful.\n" + vendorDao.authenticate(sc.next(), sc.next()));
						break;

					case 2:
						System.out.println("Enter Registration Date(yyyy-mm-dd) and Amount");
						vendorDao.getSpecificVendors(parse(sc.next()), sc.nextDouble())
								.forEach(i -> System.out.println(i));
						break;

					case 3:
						System.out.println("Enter Registration Date(yyyy-mm-dd) and Amount");
						System.out.println(vendorDao.offerDiscount(parse(sc.next()), sc.nextDouble()));
						break;

					case 4:
						System.out.println("GOODBYE!");
						exit = true;
						break;

					default:
						System.out.println("Invalid Input.");
						break;
					}

				} catch (Exception e) {
					System.out.println(e.getMessage() + "\nTryAgain!");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
