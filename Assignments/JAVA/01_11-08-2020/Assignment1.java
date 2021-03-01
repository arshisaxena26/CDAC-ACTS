/* Q1. Accept  i/ps from User , till user enters "quit" or any other option.
		I/P : operation(add|sub|mult|div) , number1(double) , number2(double) 
		Display the result of the operation.
*/

import java.util.Scanner;

class Assignment1
{
	public static void main(String[] args)
	{
		double num1=Double.parseDouble(args[0]);
		double num2=Double.parseDouble(args[1]);
		
		boolean exit=false;
		
		Scanner sc=new Scanner(System.in);

		while(!exit)
		{
			System.out.println("--------------OPTIONS-----------");
			System.out.println("1. Addition");
			System.out.println("2. Subtraction");
			System.out.println("3. Multiplication");
			System.out.println("4. Division");
			System.out.println("5. Exit");

			switch(sc.nextInt())
			{
				case 1: 
						System.out.println("Sum : "+ (num1+num2));
						break;
				case 2: 
						System.out.println("Sub : "+ (num1-num2));
						break;
				case 3: 
						System.out.println("Mul : "+ (num1*num2));
						break;
				case 4: 
						System.out.println("Div : "+ (num1/num2));
						break;
				case 5: 
						System.out.println("GOODBYE!");
						exit=true;
						break;
				default:
						System.out.println("Invalid Choice.Try Again!");
						break;
			}
		}
		sc.close();
	}
}	
