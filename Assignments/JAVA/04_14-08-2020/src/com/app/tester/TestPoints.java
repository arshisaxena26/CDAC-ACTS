/* 
Q1. Create a new eclipse project day4_lab
	Copy earlier created Point2D class in com.app.geometry package.
	Create a new TestPoints class in "com.app.tester" package for the following.

1.1 Prompt user , how many points to plot?
	Create suitable array , to store Point2D type of references.

1.2 Add a menu , Run the application till user chooses option 10 (exit)

		1 Plot a new point
			I/P --index , x & y
			eg : If user supplies 5 50 100
			Create a Point2D with x, y of (50,100) & its reference should be stored at the 5th index position in array.

		2 Display all points plotted so far. (Use for-each)

		3. Calculate distance	
			I/P strt , end point indexes.
			eg : If user enters 2 6
			Find out the distance between 2nd & 6th point. (array indexes start from 0)

		10. Exit

Note : Boundary condition checking & null checking is expected.
(Meaning : if user supplies index > array length -1 , then give error message : invalid index --out of range
If no point is plotted at user specified index , then give error message : invalid index -- no point plotted here.) 
 */

package com.app.tester;

import java.util.Scanner;

import com.app.geometry.Point2D;

public class TestPoints {

	public static void main(String[] args) {
		System.out.println("How many Points to plot?");

		Scanner sc = new Scanner(System.in);
		Point2D[] points = new Point2D[sc.nextInt()];

		int counter = 0;
		boolean exit = false;

		while (!exit) {
			System.out.println("----OPTIONS----");
			System.out.println("1.Plot a New Point");
			System.out.println("2.Display all Plotted Points");
			System.out.println("3.Calculate Distance between 2 Points");
			System.out.println("10.EXIT");

			switch (sc.nextInt()) {
			case 1:
				System.out.println("Enter Index,X and Y coordinates");
				int index = sc.nextInt();

				if (index > points.length - 1)
					System.out.println("Index Out Of Range");

				else if (points[index] != null)
					System.out.println("Index Filled");
					
				else {
					points[index] = new Point2D(sc.nextInt(), sc.nextInt());
					System.out.println("New Point Added!");
					counter++;
				}
				break;

			case 2:
				if (counter == 0)
					System.out.println("No Points Plotted");
				
				else {
					for (Point2D p : points) {
						if (p != null)
							System.out.println(p.getDetails());
					}
				}
				break;

			case 3:
				if (counter == 0)
					System.out.println("No Points Plotted");
				else {
					System.out.println("Enter Two Points");
					int firstPoint = sc.nextInt();
					int secondPoint = sc.nextInt();

					if (firstPoint > points.length || secondPoint > points.length)
						System.out.println("Point NOT Found--OUT OF RANGE");

					else if (points[firstPoint - 1] == null || points[secondPoint - 1] == null)
						System.out.println("Point NOT Plotted");

					else
						System.out.println("Distance: " + points[firstPoint - 1].calcDistance(points[secondPoint - 1]));
				}
				break;

			case 10:
				System.out.println("GOODBYE!");
				exit = true;
				break;

			default:
				System.out.println("Wrong Input.Try Again!");
				break;
			}
		}

		sc.close();

	}

}
