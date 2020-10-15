package core;

import java.time.LocalDate;

public class HireNewEmployee {
	//data members
	private String empId; 
	private String name;
	private LocalDate dob;
	private double salary;
	private String deptId;
	
	//Parameterized Constructor
	public HireNewEmployee(String empId, String name, LocalDate dob, double salary, String deptId) {
		this.empId = empId;
		this.name = name;
		this.dob = dob;
		this.salary = salary;
		this.deptId = deptId;
	}
	
	//Getters
	public LocalDate getDob() {
		return dob;
	}

	public String getDeptId() {
		return deptId;
	}

	@Override
	public String toString() {
		return "HireNewEmployee [empId=" + empId + ", name=" + name + ", dob=" + dob + ", salary=" + salary
				+ ", deptId=" + deptId + "]";
	}	
}
