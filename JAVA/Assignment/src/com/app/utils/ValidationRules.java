package com.app.utils;

import java.util.HashMap;

import com.app.core.Book;
import com.app.core.BookShopUsers;
import com.app.core.Cart;

import custom_exception.BookShopCustomException;

public class ValidationRules {

	// Validating Login Authentication
	public static void validateLogin(String email, String password, HashMap<String, BookShopUsers> map)
			throws BookShopCustomException {
		if (map.get(email) == null)
			throw new BookShopCustomException("User NOT Found");

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
	public static int validateQuantityBookSelection(int quantity, int key, HashMap<Integer, Book> map)
			throws BookShopCustomException {
		if (map.get(key).getQuantity() < quantity)
			throw new BookShopCustomException("Quantity Out of Stock");
		return quantity;
	}

	// Increasing Quantity of Same Selection
	public static boolean validateDuplicateBooksInCart(HashMap<Integer, Book> bookMap, int key,
			HashMap<Integer, Cart> cartMap, int quantity) throws BookShopCustomException {
		for (Cart c : cartMap.values()) {
			if (c.getTitle().equals(bookMap.get(key).getTitle())) {
				c.setQuantity(c.getQuantity() + quantity);
				return false;
			}
		}
		return true;
	}

	// Validating Quantity for Removal
	public static void validateQuantityForRemoval(int quantity, int key, HashMap<Integer, Cart> map)
			throws BookShopCustomException {
		if (map.get(key).getQuantity() == 1)
			map.remove(key);
		else
			map.get(key).setQuantity(map.get(key).getQuantity() - quantity);

	}

	// Validating if Quantity Requested exceeds Quantity Present in Cart
	public static int validateQuantityCartSelection(int quantity, int key, HashMap<Integer, Cart> map)
			throws BookShopCustomException {
		if (map.get(key).getQuantity() < quantity)
			throw new BookShopCustomException("Quantity Cannot be more than Cart Quantity for Selected Book");
		return quantity;
	}

}
