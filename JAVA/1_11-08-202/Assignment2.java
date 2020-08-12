/* Q2. Accept 2 double values from User (using Scanner). Check data type.
	If arguments are not doubles , supply suitable error message & terminate.
	If numbers are double values , print its average.
*/

import java.util.Scanner;

class Assignment2
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);

		System.out.println("Enter TWO Numbers");
		
		double num1=0,num2=0;

		if(sc.hasNextDouble()) 
			num1=sc.nextDouble();
		else 
		{
			System.out.println("Invalid Input");
			return;
		}
		
		if(sc.hasNextDouble()) 
			num2=sc.nextDouble();
		else 
		{
			System.out.println("Invalid Input");
			return;
		}

		System.out.println("Average: "+(num1+num2)/2);

		sc.close();
		}
	}
