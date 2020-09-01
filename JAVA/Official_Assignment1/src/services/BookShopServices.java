package services;

import static utils.validations.ValidationRules.validateDuplicateBooksInCart;
import static utils.validations.ValidationRules.validateQuantityCartSelection;
import static utils.validations.ValidationRules.validateQuantityForRemoval;

import java.util.ArrayList;

import core.books.Book;
import core.cart.Cart;
import custom_exception.BookShopCustomException;

public class BookShopServices {

	// Method to display Books
	public static void displayBooks(ArrayList<Book> bookList) {
		int index = 1;
		System.out.println("\n***Books Available In Store***");
		System.out.println("SNO\tTITLE\t\t\t\tCATEGORY\tPRICE\tPUBLISH DATE  QUANTITY  RATING  AUTHOR INFORMATION\n");
		for (Book b : bookList) {
			System.out.print(index++);
			System.out.print(b);
			b.displayAuthorInfo();
		}
	}

	// Method to display Cart
	public static void displayCart(ArrayList<Cart> cartList) {
		if (!cartList.isEmpty()) {
			int index = 1;
			System.out.println("***********CART**************");
			System.out.println("SNO\tTITLE\t\t\t\tQuantity\tPRICE");
			for (Cart c : cartList) {
				System.out.println(index + "\t" + c);
				index++;
			}
		} else
			System.out.println("Cart is Empty");
	}

	// Method to display Cart at Checkout
	public static void displayCheckoutCart(ArrayList<Cart> cartList) {
		int checkoutBill = 0;
		if (!cartList.isEmpty()) {
			for (Cart c : cartList) {
				System.out.println("PRODUCT\t-----" + c.getTitle());
				checkoutBill += c.getTotalprice();
			}
			System.out.println("\nTotal Cart Value:\t" + checkoutBill);
		}
	}

	// Method to Add to Cart
	public static void addToCart(ArrayList<Book> bookList, int selectedBook, ArrayList<Cart> cartList, int quantity)
			throws BookShopCustomException {
		if (validateDuplicateBooksInCart(bookList, selectedBook, cartList, quantity)) {

			cartList.add(
					new Cart(quantity, bookList.get(selectedBook).getTitle(), bookList.get(selectedBook).getPrice()));

			bookList.get(selectedBook).setQuantity(bookList.get(selectedBook).getQuantity() - quantity);
		}
		System.out.println("Added " + quantity + " copies of " + bookList.get(selectedBook).getTitle());
	}

	// Method to Remove Items from Cart
	public static void removeFromCart(int quantity, int selectedBook, ArrayList<Cart> cartList)
			throws BookShopCustomException {
		validateQuantityForRemoval(validateQuantityCartSelection(quantity, selectedBook, cartList), selectedBook,
				cartList);
		System.out.println("Selection Removed From Cart--Cart Updated");
	}
}
