package tester;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Vector;
import static com.app.generics.GenericUtils.*;

import com.app.core.Customer;

public class Tester {

	public static void main(String[] args) {
		// Creating HashSet of Integers
		HashSet<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 90));

		// Creating LinkedList of Strings
		LinkedList<String> words = new LinkedList<>(Arrays.asList("This", "Program", "Is", "Testing", "Generics"));

		// Creating ArrayList of Customer Objects
		ArrayList<Customer> customers = new ArrayList<>();
		customers.add(new Customer("Arshi", "arshi@gmail.com"));
		customers.add(new Customer("Akshat", "akshat@gmail.com"));

		// Creating ArrayList of Doubles
		ArrayList<Double> doubles = new ArrayList<>(Arrays.asList(1.1, 2.2, 3.3, 4.4, 5.5));

		// Creating LinkedHashSet of Integers
		LinkedHashSet<Integer> nums = new LinkedHashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

		// Creating Vector of Floats
		Vector<Float> floats = new Vector<>(Arrays.asList(1.1f, 1.2f, 1.3f, 1.6f));

		System.out.println("\n----HashSet Integers----");
		display(numbers); // calling GenericUtils static method display
		System.out.println();

		System.out.println("\n----LinkedList Strings----");
		display(words);// calling GenericUtils static method display
		System.out.println();

		System.out.println("\n----ArrayList Customers----");
		display(customers);// calling GenericUtils static method display

		System.out.println();

		// calling GenericUtils static method squareRoot
		System.out.println("Square root of ArrayList Doubles:" + squareRoot(doubles));
		System.out.println("Square root of LinkedHashSet Integers:" + squareRoot(nums));
		System.out.println("Square root of Vector Floats:" + squareRoot(floats));

		System.out.println("\n----Removing ArrayList Alternate Customers----");
		removeAlternateElements(customers); // calling GenericUtils static method removeAlternateElements
		display(customers);// calling GenericUtils static method display

		System.out.println("\n----Removing HashSet Alternate Integers----");
		removeAlternateElements(numbers);// calling GenericUtils static method removeAlternateElements
		display(numbers);// calling GenericUtils static method display
		System.out.println();

		System.out.println("\n----Removing LinkedList Alternate Strings----");
		removeAlternateElements(words);// calling GenericUtils static method removeAlternateElements
		display(words);// calling GenericUtils static method display
	}

}
