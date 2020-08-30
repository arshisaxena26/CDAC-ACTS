package com.app.utils;

import com.app.core.Book;
import static com.app.core.BookCategories.*;

import static java.time.LocalDate.*;

import java.util.HashMap;

import static com.app.utils.ValidationRules.*;

import custom_exception.BookShopCustomException;

public class BooksCollectionUtils {
	// Populating Book Data
	public static HashMap<Integer, Book> populateSampleBooksData() throws BookShopCustomException {

		// HashMap to contain Books
		HashMap<Integer, Book> bookMap = new HashMap<>();

		int index = 1; // Serial Numbers to display Books

		// Creating Book Object,linking Author Details and Adding Book in HashMap
		Book bookObj = new Book(index++, "Old Man and the Sea", valueOf("FICTION"), 150.0,
				parse("1952-09-01"), 5, validateRating(3.8));
		bookObj.linkAuthorDetails("ernest_hem@gmail.com", "Ernest Hemingway");
		bookMap.putIfAbsent(index - 1, bookObj);

		// Creating Book Object,linking Author Details and Adding Book in HashMap
		bookObj = new Book(index++, "Pride and Prejudice", valueOf("FICTION"), 179.0, parse("1813-01-28"),
				3, validateRating(4.3));
		bookObj.linkAuthorDetails("jane_austen@gmail.com", "Jane Austen");
		bookMap.putIfAbsent(index - 1, bookObj);

		// Creating Book Object,linking Author Details and Adding Book in HashMap
		bookObj = new Book(index++, "A Brief History of Time", valueOf("SCIENCE"), 260.0,
				parse("1988-03-01"), 8, validateRating(4.2));
		bookObj.linkAuthorDetails("stephen_hawking@gmail.com", "Stephen Hawking");
		bookMap.putIfAbsent(index - 1, bookObj);

		// Creating Book Object,linking Author Details and Adding Book in HashMap
		bookObj = new Book(index++, "Interdimension Travel", valueOf("SCIENCE"), 280.0,
				parse("1987-10-29"), 4, validateRating(4.5));
		bookObj.linkAuthorDetails("james_g@gmail.com", "James Gleick");
		bookMap.putIfAbsent(index - 1, bookObj);

		// Creating Book Object,linking Author Details and Adding Book in HashMap
		bookObj = new Book(index++, "The Quants Theory", valueOf("FINANCE"), 250.16, parse("2010-02-02"),
				9, validateRating(3.9));
		bookObj.linkAuthorDetails("scott_p@gmail.com", "Scott Patterson");
		bookMap.putIfAbsent(index - 1, bookObj);

		// Creating Book Object,linking Author Details and Adding Book in HashMap
		bookObj = new Book(index++, "The Currency Wars", valueOf("FINANCE"), 504.0, parse("2007-06-01"), 2,
				validateRating(3.8));
		bookObj.linkAuthorDetails("song_hong@gmail.com", "Song Hongbing");
		bookMap.putIfAbsent(index - 1, bookObj);

		// Creating Book Object,linking Author Details and Adding Book in HashMap
		bookObj = new Book(index++, "Yoga:An Understanding", valueOf("YOGA"), 743.0, parse("2019-01-08"),
				6, validateRating(2.5));
		bookObj.linkAuthorDetails("ann_swan@gmail.com", "Ann Swanson");
		bookMap.putIfAbsent(index - 1, bookObj);

		// Creating Book Object,linking Author Details and Adding Book in HashMap
		bookObj = new Book(index++, "The Science of Yoga", valueOf("YOGA"), 899.0, parse("2011-10-28"), 8,
				validateRating(3.5));
		bookObj.linkAuthorDetails("leslie_k@gmail.com", "Leslie Kaminoff");
		bookObj.linkAuthorDetails("matthews_amy@gmail.com", "Amy Matthews");
		bookMap.putIfAbsent(index - 1, bookObj);

		// Creating Book Object,linking Author Details and Adding Book in HashMap
		bookObj = new Book(index++, "Disability Visiblity", valueOf("POETRY"), 199.0, parse("2017-08-10"),
				9, validateRating(2.6));
		bookObj.linkAuthorDetails("marcus_a@gmail.com", "Marcus Aurelius");
		bookMap.putIfAbsent(index - 1, bookObj);

		// Creating Book Object,linking Author Details and Adding Book in HashMap
		bookObj = new Book(index++, "Leaves of Grass:A Poem", valueOf("POETRY"), 280.0,
				parse("2017-09-27"), 10, validateRating(4.5));
		bookObj.linkAuthorDetails("hector_gar@gmail.com", "Héctor García");
		bookObj.linkAuthorDetails("francesc@gmail.com", "Francesc Miralles");
		bookMap.putIfAbsent(index - 1, bookObj);

		return bookMap;
	}
}
