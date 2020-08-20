package tester;

import java.util.Scanner;
import com.app.org.FixedStack;
import com.app.org.GrowableStack;
import com.app.org.Stack;

public class Tester {

	public static void main(String[] args) {
		Stack stack=null;
		Scanner sc = new Scanner(System.in);

		boolean exit = false;
		boolean counter = false;

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
				stack=new FixedStack();
				System.out.println("Fixed Stack of size " + Stack.STACK_SIZE + " Created.");
				counter = true;
				break;

			case 2:
				stack=new GrowableStack();
				System.out.println("Growable Stack Created.");
				counter = true;
				break;

			case 3:
				System.out.println("Enter one Employee ID and Name");
				stack.push(sc.nextInt(),sc.next());
				break;

			case 4:
				stack.pop();
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
