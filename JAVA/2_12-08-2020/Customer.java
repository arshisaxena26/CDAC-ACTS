/* Q. Create a java application for the following.
 		Create a Customer class , with data members (all private : tight encapsulation)
		name(String),email(String),age(int), creditLimit(double)

4.1 Supply a parameterized constructor to accept all details from user
4.2 Supply an argument less  constructor to init default name to "Riya" , email to "riya@gmail.com",age=25,creditLimit=10000
4.3 Supply another constructor , to init default creditLimit to 15000, taking rest of the i/ps from user.
4.4 Write a method , getDetails to return string form of customer name & credit limit details.
4.5 Supply getter & setter for creditLimit.

Note : Currently constructor chaining is not discussed. But can be discussed in the lab & make use of it then.

4.6 Create a TestCustomer class . Use scanner to accept user i/ps.
Create 3 customers using 3 different constructors(4.1 : c1 ,4.2 : c2,4.3 :c3 )
Display customer details of all customers.
Prompt user , for changing creditLimit of the c3.
Display new credit limit on the console.

*/
import java.util.Scanner;
class Customer
{
	private String name,email;
	private int age;
	private double creditLimit;

	Customer(String name,String email, int age, double creditLimit)
	{
		this.name=name;
		this.email=email;
		this.age=age;
		this.creditLimit=creditLimit;
		}
	
	Customer()
	{
		this("Riya","riya@gmail.com",25,10000);
		}
	
	Customer(String name,String email, int age)
	{
		this(name,email,age,15000);
		}
	
	String getDetails()
	{
		return "Name: "+this.name+"  Credit Limit:"+this.creditLimit;
		}
	
	public void setCreditLimit(double creditLimit)
	{
		this.creditLimit=creditLimit;
		}

	public double getCreditLimit()
	{
		return this.creditLimit;
		}
	}


class TestCustomer
{
	public static void main(String[] args)
	{
		System.out.println("Enter Customer's Name,Email,Age and Credit Limit");
		Scanner sc=new Scanner(System.in);
		
		Customer c1=new Customer(sc.nextLine(),sc.next(),sc.nextInt(),sc.nextDouble());
		sc.nextLine();
		Customer c2=new Customer();
		
		System.out.println("Enter Customer's Name,Email and Age");
		Customer c3=new Customer(sc.nextLine(),sc.next(),sc.nextInt());
		sc.nextLine();

		System.out.println("Details of Customer 1");
		System.out.println(c1.getDetails());

		System.out.println("Details of Customer 2");
		System.out.println(c2.getDetails());
		
		System.out.println("Details of Customer 3");
		System.out.println(c3.getDetails());


		System.out.println("Update Credit Limit");
		System.out.println("New Credit Limit is:"+(c3.getCreditLimit()+sc.nextDouble()));

		sc.close();
		}
	}

