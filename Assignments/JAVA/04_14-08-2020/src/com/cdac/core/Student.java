/*
Q2. Create java application for the following.
Create Student class  in package com.cdac.core

2.1 Every student must have   --- id(int) --if possible system generated(Hint : use static data member id counter : start with 1 n generate ids.), name (String), email(String), age(int),gpa

2.2 Add suitable parameterized constructor.
	Accept -- name,email,age only from user.

2.3 Add a method fetchDetails to  fetch student details
	(ret type -- String)

2.4 Add computeGPA method in Student class
	Accept 3 method arguments for : scores for quiz , test & assignments
	gpa should be computed on 20 % of quiz score, 50% of test score & 30% of assignment score.
	(1-10 scale)
 */

package com.cdac.core;

public class Student {
	private static int idStatic;
	private int id;
	private String name,email;
	private int age;
	private double gpa;
	
	public Student(String name,String email,int age)
	{
		id=++idStatic;
		this.name=name;
		this.email=email;
		this.age=age;
	}
	public String fetchDetails()
	{
		return "Student ID: "+id+"\nStudent Name: "+name+"\nStudent Email: "+email+"\nStudent Age: "+age;
	}
	public void computeGPA(int quiz,int test,int assignment)
	{
		gpa=0.2*quiz+0.5*test+0.3*assignment;
	}
	public int getID()
	{
		return id;
	}
	public double getGPA()
	{
		return gpa;
	}
}
