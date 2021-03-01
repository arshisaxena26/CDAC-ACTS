/*  Q1--CONTINUED
1.6 Write TestPoint class , under "com.app.tester" package with a main method
	Accept co ordinates of 2 points from user (Scanner) --p1 & p2

1.7 Use show method to display point details.(p1's details & p2's details)

1.8 Invoke isEqual & display if points are same or different (i.e p1 & p2 are located at the same position)

1.9 Create new point p3 , with the dimensions offset from p1.
	I/P --x offset & y offset

1.10 Display distance between 2 points.(between p1 & p2)
*/

package com.app.tester;
import com.app.geometry.Point2D;
import java.util.Scanner;

public class TestPoint
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		
		//Point 1
		System.out.println("Enter X and Y coordinates for Point 1");
		Point2D point1=new Point2D(sc.nextInt(),sc.nextInt());
		
		//Point2
		System.out.println("Enter X and Y coordinates for Point 2");
		Point2D point2=new Point2D(sc.nextInt(),sc.nextInt());
		
		//Displaying Points Co-ordinates
		System.out.println("Point 1");
		System.out.println(point1.getDetails());
		
		System.out.println("Point 2");
		System.out.println(point2.getDetails());
		
		//Checking if Points are Equal
		boolean present=point1.isEqual(point2);
		if(present)
			System.out.println("Points are Equal");
		else
			System.out.println("Points are NOT Equal");
		
		//Creating new Point with Offsets to Point 1
		System.out.println("Update X and Y coordinates");
		Point2D point3=point1.createNewPoint(sc.nextInt(),sc.nextInt());

		//Displaying Point 3 Co-ordinates
		System.out.println("Point 3");
		System.out.println(point3.getDetails());
		
		//Displaying Distance between Point 1 and Point 2
		System.out.println("DISTANCE between POINT 1 and POINT 2 is: "+point1.calcDistance(point2));

		sc.close();
		}
	}
