package com.app.org;

public abstract class Employee {
	private int id, depId;
	private String name;
	private double basicSal;

	public Employee(int id, String name, int deptId, double basicSal) {
		this.id = id;
		this.name = name;
		this.depId = deptId;
		this.basicSal = basicSal;
	}

	@Override
	public String toString() {
		return "Employee ID: " + id + "\nEmployee Name: " + name + "\nDepartment ID: " + depId + "\nBasic Salary: "
				+ basicSal;
	}

	public abstract double computeNetSalary();

	public double getBasicSal() {
		return basicSal;
	}

}
