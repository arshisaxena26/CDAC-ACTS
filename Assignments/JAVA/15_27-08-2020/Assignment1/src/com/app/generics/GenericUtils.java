package com.app.generics;

import java.util.Collection;
import java.util.Iterator;
import static java.lang.Math.sqrt;

public class GenericUtils {

	// Method to display contents of ANY Collection
	public static void display(Collection<?> contents) {
		for (Object c : contents)
			System.out.print(c + " ");
	}

	// Method to return square root of sum of numbers passed in ANY Collection
	public static double squareRoot(Collection<? extends Number> numbers) {
		int sum = 0;
		for (Number num : numbers) {
			sum += num.doubleValue();
		}
		return sqrt(sum);
	}

	// Method to remove alternate elements of ANY Collection
	public static void removeAlternateElements(Collection<?> elements) {
		Iterator<?> it = elements.iterator();
		boolean remove = false;
		while (it.hasNext()) {
			it.next();
			if (remove)
				it.remove();
			remove = !remove;
		}
	}
}
