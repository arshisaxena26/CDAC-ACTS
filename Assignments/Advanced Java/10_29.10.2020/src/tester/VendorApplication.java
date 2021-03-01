package tester;

import static java.time.LocalDate.parse;
import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.VendorDaoImpl;
import pojos.BankAccount;
import pojos.Location;
import pojos.PaymentMode;
import pojos.PaymentType;
import pojos.Role;
import pojos.AccountType;
import pojos.Vendor;

public class VendorApplication {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getSf()) {
			boolean exit = false;
			VendorDaoImpl vendorDao = new VendorDaoImpl();
			Vendor vendor = null;

			while (!exit) {
				System.out.println("\n1.Vendor Registration");
				System.out.println("2.Fetch Vendor Details");
				System.out.println("3.Exit");

				try {
					switch (sc.nextInt()) {
					case 1:
						// Vendor Basic Details
						System.out.println(
								"Enter Vendor Name, Email, Password, Registration Amount, Registration Date(yyyy-mm-dd),Role");
						vendor = new Vendor(sc.next(), sc.next(), sc.next(), sc.nextDouble(), parse(sc.next()),
								Role.valueOf(sc.next().toUpperCase()));

						// Vendor Bank Details
						System.out.println("Enter Two Bank Details: Account Type and Balance");
						for (int i = 0; i < 2; i++)
							vendor.addBankAccountToList(
									new BankAccount(AccountType.valueOf(sc.next().toUpperCase()), sc.nextDouble()));

						// Vendor Location Details
						System.out.println("Enter Location Details: City,State and Country");
						vendor.addVendorLocation(new Location(sc.next(), sc.next(), sc.next()));

						// Vendor Payment Details
						System.out.println("Enter Payment Type,Amount and Date(yyy-mm-dd)");
						vendor.setPaymentMode(new PaymentMode(PaymentType.valueOf(sc.next().toUpperCase()),
								sc.nextDouble(), parse(sc.next())));

						// Vendor Phone Numbers
						System.out.println("Enter Two Phone Numbers");
						for (int i = 0; i < 2; i++)
							vendor.getPhoneNumbers().add(sc.next());

						// Registering Vendor
						System.out.println(vendorDao.registerVendor(vendor));
						break;

					case 2:
						System.out.println("Enter Email");
						vendor = vendorDao.getVendorDetails(sc.next());
						System.out.println("\nVendor Details:\n" + vendor);

						System.out.println("\nBank Account Details :");
						vendor.getAccounts().forEach(i -> System.out.println(i));

						System.out.println("\nLocation: \n" + vendor.getLocation());
						System.out.println("\nPayment Method: \n" + vendor.getPaymentMode());

						System.out.println("\nPhone Numbers :");
						vendor.getPhoneNumbers().forEach(i -> System.out.println(i));

						break;

					case 3:
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
			System.out.println(e.getMessage());
		}

	}

}
