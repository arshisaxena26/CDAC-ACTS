package tester;

import static java.time.LocalDate.parse;
import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.VendorDaoImpl;
import pojos.BankAccount;
import pojos.Role;
import pojos.Type;
import pojos.Vendor;

public class VendorApplication {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getSf()) {
			boolean exit = false;
			VendorDaoImpl vendorDao = new VendorDaoImpl();
			Vendor vendor = null;

			while (!exit) {
				System.out.println("\n1.Vendor Registration");
				System.out.println("2.Unsubscribe Vendor");
				System.out.println("3.Fetch Vendor Details");
				System.out.println("4.Exit");

				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println(
								"Enter Vendor Name, Email, Password, Registration Amount, Registration Date(yyyy-mm-dd),Role");
						vendor = new Vendor(sc.next(), sc.next(), sc.next(), sc.nextDouble(), parse(sc.next()),
								Role.valueOf(sc.next().toUpperCase()));

						System.out.println("Enter Two Bank Details: Account Type and Balance");
						for (int i = 0; i < 2; i++)
							vendor.addBankAccountToList(
									new BankAccount(Type.valueOf(sc.next().toUpperCase()), sc.nextDouble()));

						System.out.println(vendorDao.registerVendor(vendor));
						break;

					case 2:
						System.out.println("Enter Vendor ID");
						System.out.println(vendorDao.unsubscribeVendor(sc.nextInt()));
						break;

					case 3:
						System.out.println("Enter Email and Password");
						vendor = vendorDao.getVendorDetails(sc.next(), sc.next());
						System.out.println("\nVendor Details:\n" + vendor);
						System.out.println("\nBank Account Details :");
						vendor.getAccounts().forEach(i -> System.out.println(i));
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
					System.out.println("\n" + e.getMessage() + "\nTryAgain!");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
