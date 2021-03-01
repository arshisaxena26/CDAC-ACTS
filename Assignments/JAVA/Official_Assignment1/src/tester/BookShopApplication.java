package tester;

import static utils.sample_data.BooksCollectionUtils.*;
import static services.BookShopServices.*;
import static utils.sample_data.UsersCollectionsUtils.*;
import static utils.validations.ValidationRules.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import core.books.Book;
import core.bookshop_users.BookShopUsers;
import core.cart.Cart;
import custom_exception.BookShopCustomException;

public class BookShopApplication {

	public static void main(String[] args) throws BookShopCustomException {

		// try with Resources--AutoClosable Scanner
		try (Scanner sc = new Scanner(System.in)) {

			// Getting Sample Populated Data of Books and Users
			HashMap<String, BookShopUsers> usersMap = populateUserSampleData();
			ArrayList<Book> bookList = populateSampleBooksData();

			// ArrayList for Cart
			ArrayList<Cart> cartList = new ArrayList<>();

			boolean exit = false;

			while (!exit) {
				System.out.println("\n***WELCOME TO THE BOOK SHOP***");
				System.out.println("1. Admin Login to Display Books");
				System.out.println("2. Customer Login");
				System.out.println("3. Exit");

				try {
					switch (sc.nextInt()) {

					case 1:
						System.out.println("Enter Email and Password");
						validateAdminLogin(sc.next(), sc.next(), usersMap); // Authenticating Admin
						System.out.println("\nWelcome ADMIN");

						displayBooks(bookList);// Displaying Sample Books Data
						break;

					case 2:
						// Providing Guest Credentials for Testing Purposes
						System.out.println("Guest Credentials:\tguest@gmail.com\t\tguest\n");
						System.out.println("Enter Email and Password");
						validateCustomerLogin(sc.next(), sc.next(), usersMap);// Authenticating Customer
						System.out.println("Login Successful");

						while (!exit) {
							System.out.println();
							System.out.println("---------OPTIONS------------");
							System.out.println("1. Display Available Books ");
							System.out.println("2. Add Books to the Cart ");
							System.out.println("3. Show Cart Contents ");
							System.out.println("4. Remove Cart Contents ");
							System.out.println("5. CheckOut ");

							try {
								switch (sc.nextInt()) {

								case 1:
									displayBooks(bookList);
									break;

								case 2:
									// Adding Selected Book and Desired Quantity in Cart
									System.out.println("Enter SNO to Add to Cart");
									int selectedBook = sc.nextInt();

									System.out.println("Enter Quantity");

									addToCart(bookList, selectedBook - 1, cartList,
											validateQuantityBookSelection(sc.nextInt(), selectedBook - 1, bookList));
									break;

								case 3:
									displayCart(cartList);
									break;

								case 4:
									// Removing Items and Updating Cart
									if (!cartList.isEmpty()) {
										System.out.println("Enter SNO to Remove");
										selectedBook = sc.nextInt();
										System.out.println("Enter Quantity to Remove");
										removeFromCart(sc.nextInt(), selectedBook - 1, cartList);
									} else
										System.out.println("Cart is Empty");
									break;

								case 5:
									displayCheckoutCart(cartList);
									exit = true;
									break;

								default:
									System.out.println("Invalid Option. Try Again!");
									break;
								}

							} catch (Exception e) {
								System.out.println(e.getMessage());
								System.out.println("Try Again!");
							}
						}
					case 3:
						System.out.println("\nGOODBYE! VISIT AGAIN!!");
						exit = true;
						break;

					default:
						System.out.println("Invalid Option. Try Again!");
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
