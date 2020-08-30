package tester;

import java.util.HashMap;
import java.util.Scanner;

import com.app.core.Book;
import com.app.core.BookShopUsers;
import com.app.core.Cart;

import custom_exception.BookShopCustomException;

import static com.app.utils.UsersCollectionsUtils.*;
import static com.app.utils.ValidationRules.*;
import static com.app.utils.BooksCollectionUtils.*;

public class BookShopApplication {

	public static void main(String[] args) throws BookShopCustomException {

		// try with Resources--AutoClosable Scanner
		try (Scanner sc = new Scanner(System.in)) {

			boolean exit = false;
			int cartIndex = 1; // Recording Serial Number of Items in Cart
			int checkoutBill = 0; // Final Amount

			// Getting Sample Populated Data of Books and Users
			HashMap<String, BookShopUsers> usersMap = populateUserSampleData();
			HashMap<Integer, Book> bookMap = populateSampleBooksData();

			// HashMap for Cart
			HashMap<Integer, Cart> cartMap = new HashMap<>();

			while (!exit) {
				System.out.println("\n***WELCOME TO THE BOOK SHOP***");
				System.out.println("Please Login to Continue---Enter Email and Password");

				try {
					validateLogin(sc.next(), sc.next(), usersMap);
					System.out.println("Login Successful");

					while (!exit) {
						System.out.println();
						System.out.println("---------OPTIONS------------");
						System.out.println("1. Display Available Books ");
						System.out.println("2. Add Books to the Cart ");
						System.out.println("3. Show Cart Contents ");
						System.out.println("4. Remove Cart Contents ");
						System.out.println("5. CheckOut ");

						switch (sc.nextInt()) {
						case 1:
							// Displaying Sample Books Data
							System.out.println("\n***Books Available In Store***");
							System.out.println(
									"SNO\tTITLE\t\t\t\tCATEGORY\tPRICE\tPUBLISH DATE  QUANTITY  RATING  AUTHOR INFORMATION\n");
							for (Book b : bookMap.values()) {
								System.out.print(b);
								b.displayAuthorInfo();
							}
							break;

						case 2:
							try {
								// Adding Selected Book and Desired Quantity in Cart
								System.out.println("Enter SNO to Add to Cart");
								int selectedBook = sc.nextInt();

								System.out.println("Enter Quantity");
								int quantity = validateQuantityBookSelection(sc.nextInt(), selectedBook, bookMap);

								if (validateDuplicateBooksInCart(bookMap, selectedBook, cartMap, quantity)) {
									cartMap.putIfAbsent(cartIndex,
											new Cart(cartIndex, quantity, bookMap.get(selectedBook).getTitle(),
													bookMap.get(selectedBook).getPrice()));
									cartIndex++;
									bookMap.get(selectedBook)
											.setQuantity(bookMap.get(selectedBook).getQuantity() - quantity);
								}
								System.out.println(
										"Added " + quantity + " copies of " + bookMap.get(selectedBook).getTitle());
							} catch (Exception e) {
								System.out.println(e.getMessage());
								System.out.println("Try Again!");
							}
							break;
						case 3:
							// Displaying Cart
							if (!cartMap.isEmpty()) {
								System.out.println("***********CART**************");
								System.out.println("SNO\tTITLE\t\t\t\tQuantity\tPRICE");
								for (Cart c : cartMap.values())
									System.out.println(c);
							} else
								System.out.println("Cart is Empty");
							break;
						case 4:
							// Removing Items and Updating Cart
							if (!cartMap.isEmpty()) {
								System.out.println("Enter SNO to Remove");
								int selectedBook = sc.nextInt();
								System.out.println("Enter Quantity to Remove");
								int quantity = validateQuantityCartSelection(sc.nextInt(), selectedBook, cartMap);

								validateQuantityForRemoval(quantity, selectedBook, cartMap);

								System.out.println("Selection Removed From Cart--Cart Updated");
							} else
								System.out.println("Cart is Empty");
							break;
						case 5:
							// Displaying Final Items and Total Price
							if (!cartMap.isEmpty()) {
								for (Cart c : cartMap.values()) {
									System.out.println("PRODUCT\t-----" + c.getTitle());
									checkoutBill += c.getTotalprice();
								}
								System.out.println("\nTotal Cart Value:\t" + checkoutBill);
							}

							// Checking Out
							System.out.println("\nGOODBYE! VISIT AGAIN!!");
							exit = true;
							break;

						default:
							System.out.println("Invalid Option. Try Again!");
							break;
						}

					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
					System.out.println("Try Again!");
				}

			}
		}
	}
}