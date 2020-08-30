package com.app.core;

public class BookShopUsers {
	// private data members
	private String email, password;

	// Parameterized Constructor
	public BookShopUsers(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	// Getters
	public String getPassword() {
		return password;
	}

}
