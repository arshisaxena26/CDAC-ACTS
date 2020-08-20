package com.app.org;

public class Employee {
	private int id;
	private String name;
	
	public Employee(int id,String name)
	{
		this.id=id;
		this.name=name;
	}
	
	public String toString()
	{
		return "Employee ID: "+id+"\nEmployee Name: "+name;
	}
}
