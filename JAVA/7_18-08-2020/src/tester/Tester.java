package tester;

import java.util.Scanner;
import com.app.org.FixedStack;
import com.app.org.GrowableStack;
import com.app.org.Stack;

public class Tester {

	public static void main(String[] args) {
		Stack fixed = new FixedStack();
		Stack grow = new GrowableStack();

		Scanner sc = new Scanner(System.in);

		boolean exit = false;
		boolean counter = false;
		int count = 0;

		while (!exit) {
			System.out.println("OPTIONS");
			if (!counter) {
				System.out.println("1.Fixed Stack");
				System.out.println("2.Growable Stack");
			} else {
				System.out.println("3.Push Data");
				System.out.println("4.Pop Data and Display");
				System.out.println("5.Exit");
			}

			switch (sc.nextInt()) {
			case 1:
				System.out.println("Fixed Stack of size " + Stack.STACK_SIZE + " Created.");
				count = 1;
				counter = true;
				break;

			case 2:
				System.out.println("Growable Stack Created.");
				count = 2;
				counter = true;
				break;

			case 3:
				System.out.println("Enter one Employee ID and Name");
				if (count == 1) {
					fixed.push(sc.nextInt(), sc.next());
				} else {
					grow.push(sc.nextInt(), sc.next());
				}
				break;

			case 4:
				if (count == 1) {
					fixed.pop();
				} else {
					grow.pop();
				}
				break;
			case 5:
				System.out.println("GOODBYE!!");
				exit = true;
				break;
			}
		}
		sc.close();
	}

}
