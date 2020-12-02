package com.app;

import java.util.Scanner;

public class Developer extends Employee {

	double devSalary;
	double pay;
	int salSoftwareEng = 1000;
	int salDevLead = 2000;
	int salTechLead = 3000;
	double tax;
	int id;
	String name;

	/*
	 * Developer(int empId, String empName) { super(empId, empName);
	 * empId=this.empId; empName=this.empName; id=empId; name=empName;
	 * 
	 * }
	 */

	public void devSalary() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Developer Id");
		int id = sc.nextInt();
		System.out.println("Enter Developer Name");
		String name = sc.next();
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Enter Developer designation");
		String designation = sc1.next();
		System.out.println("Enter Developer level");
		Scanner sc2 = new Scanner(System.in);
		String level = sc2.next();

		switch (designation) {
		case "SoftwareEngineer":
			if (level.equals("beginner")) {
				pay = salSoftwareEng;
				tax = pay * 0.05;
				devSalary = payment(pay, tax);
				System.out.println("Salary for " + name + " with Id " + id + " is :" + devSalary);
			} else if (level.equals("intermediate")) {
				pay = salSoftwareEng + salSoftwareEng * 0.02;
				tax = pay * 0.06;
				devSalary = payment(pay, tax);
				System.out.println("Salary for " + name + " with Id " + id + " is :" + devSalary);
			} else if (level.equals("expert")) {
				pay = salSoftwareEng + salSoftwareEng * 0.04;
				tax = pay * 0.07;
				devSalary = payment(pay, tax);
				System.out.println("Salary for " + name + " with Id " + id + " is :" + devSalary);
			}

			break;
		case "DevLead":
			if (level.equals("beginner")) {
				pay = salDevLead;
				tax = pay * 0.05;
				devSalary = payment(pay, tax);
				System.out.println("Salary for " + name + " with Id " + id + " is :" + devSalary);
			} else if (level.equals("intermediate")) {
				pay = salDevLead + salDevLead * 0.02;
				tax = pay * 0.06;
				devSalary = payment(pay, tax);
				System.out.println("Salary for " + name + " with Id " + id + " is :" + devSalary);
			} else if (level.equals("expert")) {
				pay = salDevLead + salDevLead * 0.04;
				tax = pay * 0.07;
				devSalary = payment(pay, tax);
				System.out.println("Salary for " + name + " with Id " + id + " is :" + devSalary);
			}

			break;
		case "TechLead":
			if (level.equals("beginner")) {
				pay = salTechLead;
				tax = pay * 0.05;
				devSalary = payment(pay, tax);
				System.out.println("Salary for " + name + " with Id " + id + " is :" + devSalary);
			} else if (level.equals("intermediate")) {
				pay = salTechLead + salTechLead * 0.02;
				tax = pay * 0.06;
				devSalary = payment(pay, tax);
				System.out.println("Salary for " + name + " with Id " + id + " is :" + devSalary);
			} else if (level.equals("expert")) {
				pay = salTechLead + salTechLead * 0.04;
				tax = pay * 0.07;
				devSalary = payment(pay, tax);
				System.out.println("Salary for " + name + " with Id " + id + " is :" + devSalary);
			}

			break;
		default:
			break;
		}
		sc.close();
		sc1.close();
		sc2.close();
	}
}
