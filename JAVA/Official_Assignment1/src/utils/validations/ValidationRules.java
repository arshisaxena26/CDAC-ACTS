package utils.validations;

import java.util.ArrayList;
import java.util.HashMap;

import core.books.Book;
import core.bookshop_users.BookShopUsers;
import core.cart.Cart;
import custom_exception.BookShopCustomException;

public class ValidationRules {

	// Validating Admin Authentication
	public static void validateAdminLogin(String email, String password, HashMap<String, BookShopUsers> map)
			throws BookShopCustomException {
		if (!(email.equals("admin@gmail.com")))
			throw new BookShopCustomException("Incorrect Admin Email");

		if (!(map.get(email).getPassword().equals(password)))
			throw new BookShopCustomException("Incorrect Password");
	}

	// Validating Customer Authentication
	public static void validateCustomerLogin(String email, String password, HashMap<String, BookShopUsers> map)
			throws BookShopCustomException {
		if (map.get(email) == null || email.equals("admin@gmail.com"))
			throw new BookShopCustomException("Customer NOT Found");

		if (!(map.get(email).getPassword().equals(password)))
			throw new BookShopCustomException("Incorrect Password");
	}

	// Validating Rating Range
	public static double validateRating(double rating) throws BookShopCustomException {
		if (rating < 1.0 || rating > 5.0)
			throw new BookShopCustomException("Rating Should be in the Range 1-5");
		return rating;
	}

	// Validating if Quantity Requested exceeds Quantity Present in Store
	public static int validateQuantityBookSelection(int quantity, int index, ArrayList<Book> bookList)
			throws BookShopCustomException {
		if (bookList.get(index).getQuantity() < quantity)
			throw new BookShopCustomException("Quantity Out of Stock");
		return quantity;
	}

	// Increasing Quantity of Same Selection
	public static boolean validateDuplicateBooksInCart(ArrayList<Book> bookList, int index, ArrayList<Cart> cartList,
			int quantity) throws BookShopCustomException {
		for (Cart c : cartList) {
			if (c.getTitle().equals(bookList.get(index).getTitle())) {
				c.setQuantity(c.getQuantity() + quantity);
				return false;
			}
		}
		return true;
	}

	// Validating Quantity for Removal
	public static void validateQuantityForRemoval(int quantity, int index, ArrayList<Cart> cartList)
			throws BookShopCustomException {
		if (cartList.get(index).getQuantity() == quantity)
			cartList.remove(index);
		else
			cartList.get(index).setQuantity(cartList.get(index).getQuantity() - quantity);

	}

	// Validating if Quantity Requested exceeds Quantity Present in Cart
	public static int validateQuantityCartSelection(int quantity, int index, ArrayList<Cart> cartList)
			throws BookShopCustomException {
		if (cartList.get(index).getQuantity() < quantity)
			throw new BookShopCustomException("Quantity Cannot be more than Cart Quantity for Selected Book");
		return quantity;
	}

}
