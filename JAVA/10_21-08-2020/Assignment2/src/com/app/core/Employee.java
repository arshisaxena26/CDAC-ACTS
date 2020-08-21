package com.app.core;

import java.util.Date;

public class Employee {
	private int id;
	private String name, deptID;
	private double salary;
	private Date date;

	public Employee(int id, String name, String deptID, double sal, Date date) {
		this.id = id;
		this.name = name;
		this.deptID = deptID;
		salary = sal;
		this.date = date;
	}

	@Override
	public boolean equals(Object anObject) {
		if (anObject instanceof Employee) {
			Employee emp = (Employee) anObject;
			if (this.id == emp.id)
				return true;
		}
		return false;
	}
}
