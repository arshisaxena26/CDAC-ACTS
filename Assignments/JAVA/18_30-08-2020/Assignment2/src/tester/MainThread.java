package tester;

import java.util.Scanner;

import core.threads.EvenPrinterTask;
import core.threads.OddPrinterTask;

public class MainThread {

	public static void main(String[] args) throws InterruptedException {
		try (Scanner sc = new Scanner(System.in)) {

			System.out.println("Enter Range--start and end value");
			int start = sc.nextInt();
			int end = sc.nextInt();

			// Calling Constructors to pass start,end values
			EvenPrinterTask evenTask = new EvenPrinterTask(start, end);
			OddPrinterTask oddTask = new OddPrinterTask(start, end);

			// Creating Child Threads passing runnable instance
			Thread t1 = new Thread(evenTask, "evenThread");
			Thread t2 = new Thread(oddTask, "oddThread");

			// Starting Threads
			t1.start();
			t2.start();

			// Waiting for Child Threads--ensuring no orphan threads
			t1.join();
			t2.join();

		}

	}

}
