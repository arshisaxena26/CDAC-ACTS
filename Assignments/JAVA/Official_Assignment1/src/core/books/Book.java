package core.books;

import java.time.LocalDate;
import java.util.HashSet;

public class Book {
	// private data members
	private String title;
	private BookCategories category; // enum
	private double price, rating;
	private LocalDate publishDate;
	private int quantity;
	private BookAuthors author = null;
	private HashSet<BookAuthors> authorSet = new HashSet<>(); // HashSet to contain multiple Authors

	// Parameterized Constructor
	public Book(String title, BookCategories category, double price, LocalDate publishDate, int quantity,
			double rating) {
		this.title = title;
		this.category = category;
		this.price = price;
		this.publishDate = publishDate;
		this.quantity = quantity;
		this.rating = rating;
	}

	// Nested Class
	private class BookAuthors {
		// private data members private
		private String email, name;

		// Parameterized Constructor
		public BookAuthors(String email, String name) {
			this.email = email;
			this.name = name;
		}

		// Overriding equals--Primary Key Email
		@Override
		public boolean equals(Object o) {
			if (o instanceof BookAuthors) {
				BookAuthors authors = (BookAuthors) o;
				return this.email.equals(authors.email);
			}
			return false;
		}

		// Overriding hashCode--as per contract
		@Override
		public int hashCode() {
			return this.email.hashCode();
		}
	}

	// Linking Inner Class to Outer Class
	public void linkAuthorDetails(String email, String name) {
		author = new BookAuthors(email, name);
		authorSet.add(author); // adding BookAuthors object to HashSet
	}

	// Overriding toString method to display Books
	@Override
	public String toString() {
		return "\t" + title + "\t\t" + category + "\t\t" + price + "\t" + publishDate + "\t" + quantity + "\t" + rating
				+ "\t";
	}

	// Overriding equals for primary key--title
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Book) {
			Book b = (Book) obj;
			return this.title.equals(b.title);
		}
		return false;
	}

	// Method to display HashSet of Author Information
	public void displayAuthorInfo() {
		for (BookAuthors b : authorSet)
			System.out.print("Name:" + b.name + ",   Email:" + b.email + "    ");
		System.out.println();
	}

	// Getters
	public String getTitle() {
		return title;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
