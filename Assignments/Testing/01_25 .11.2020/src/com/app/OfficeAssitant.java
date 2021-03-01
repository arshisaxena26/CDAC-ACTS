package com.app;

import java.util.Scanner;

public class OfficeAssitant extends Employee {

	double asstSalary;
	double pay;
	int juniorAsstSal = 1000;
	double tax;
	String name;

	public void assistantSalary() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter assistant Name");
		String name = sc.next();
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Enter assistant designation");
		String designation = sc1.next();
		System.out.println("Enter Floor assigned");
		Scanner sc2 = new Scanner(System.in);
		int floor = sc2.nextInt();

		switch (designation) {
		case "juniorAsst":
			pay = juniorAsstSal;
			tax = pay * 0.05;
			asstSalary = payment(pay, tax);
			System.out.println("Salary for " + name + " working in floor " + floor + " is :" + asstSalary);

			break;
		case "IntermediateAsst":
			pay = juniorAsstSal + juniorAsstSal * 0.02;
			tax = pay * 0.06;
			asstSalary = payment(pay, tax);
			System.out.println("Salary for " + name + " working in floor " + floor + " is :" + asstSalary);

			break;
		case "seniorAsst":
			pay = juniorAsstSal + juniorAsstSal * 0.04;
			tax = pay * 0.07;
			asstSalary = payment(pay, tax);
			System.out.println("Salary for " + name + " working in floor " + floor + " is :" + asstSalary);

			break;
		default:
			break;
		}
		sc.close();
		sc1.close();
		sc2.close();
	}
}
