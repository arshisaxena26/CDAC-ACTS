package tester;

import java.util.Scanner;

import core.threads.EvenPrinterThread;
import core.threads.OddPrinterThread;

public class MainThread {

	public static void main(String[] args) throws InterruptedException {
		try (Scanner sc = new Scanner(System.in)) {

			System.out.println("Enter Range--start and end value");
			int start = sc.nextInt();
			int end = sc.nextInt();

			// Creating Child Threads
			EvenPrinterThread t1 = new EvenPrinterThread("EvenNumberPrinter", start, end);
			OddPrinterThread t2 = new OddPrinterThread("OddNumberPrinter", start, end);

			// Waiting for Child Threads--ensuring no orphan threads
			t1.join();
			t2.join();

		}

	}

}
