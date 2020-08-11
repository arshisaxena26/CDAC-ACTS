/* Q3. Display food menu to user. Assign fixed prices to food items.
		User will select items from menu along with the quantity.
		When user enters 'Generate Bill' option, display total bill & exit.
*/

import java.util.Scanner;

class Assignment3
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int sum=0;
	
		while(true)
		{	
			System.out.println("-----------Menu----------");
			System.out.println("1. Plain Dosa     Rs 50/-");
			System.out.println("2. Pizza          Rs 20/-");
			System.out.println("3. Burger         Rs 40/-");
			System.out.println("-------------------------");
			System.out.println("4. Generate Bill Amount");

			int choice=sc.nextInt();
			int quantity=0;
			
			switch(choice)
			{
				case 1:
					System.out.print("Enter Quantity: ");
					quantity=sc.nextInt();
					sum+=quantity*50;
					break;
				case 2:
					System.out.print("Enter Quantity: ");
					quantity=sc.nextInt();
					sum+=quantity*20;
					break;
				case 3:
					System.out.print("Enter Quantity: ");
					quantity=sc.nextInt();
					sum+=quantity*40;
					break;
				case 4:
					System.out.println("Bill Amount: "+sum);
					return;
				default:
					System.out.println("Invalid Input. Try Again!");
					break;
			}
		}
	}
}
