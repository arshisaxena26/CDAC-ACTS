package com.app.core;

import java.util.Date;

public class Employee1 {
	private int id;
	private String name, deptID;
	private double salary;
	private Date date;

	public Employee1(int id, String name, String deptID, double sal, Date date) {
		this.id = id;
		this.name = name;
		this.deptID = deptID;
		salary = sal;
		this.date = date;
	}

	@Override
	public boolean equals(Object anObject) {
		if (anObject instanceof Employee1) {
			Employee1 emp = (Employee1) anObject;
			if ((this.id == emp.id) && (this.deptID.equals(emp.deptID)))
				return true;
		}
		return false;
	}
}
