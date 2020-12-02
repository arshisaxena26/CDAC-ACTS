package com.app;

import java.util.Scanner;

public class ConDeveloper extends Employee {

	double conSalary;
	double pay;
	int salSoftwareEng = 1000;
	int salDevLead = 2000;
	int salTechLead = 3000;
	int contractPay = 100;
	double tax;
	int id;
	String name;

	public void contractSalary() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Contract Developer Id");
		int id = sc.nextInt();
		System.out.println("Enter Contract Developer Name");
		String name = sc.next();
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Enter Contract Developer designation");
		String designation = sc1.next();
		System.out.println("Enter Contract Developer level");
		Scanner sc2 = new Scanner(System.in);
		String level = sc2.next();

		switch (designation) {
		case "SoftwareEngineer":
			if (level.equals("beginner")) {
				pay = salSoftwareEng;
				tax = pay * 0.05;
				conSalary = paymentContract(pay, contractPay, tax);
				System.out.println("Salary for " + name + " with Id " + id + " is :" + conSalary);
			} else if (level.equals("intermediate")) {
				pay = salSoftwareEng + salSoftwareEng * 0.02;
				tax = pay * 0.06;
				conSalary = paymentContract(pay, contractPay, tax);
				System.out.println("Salary for " + name + " with Id " + id + " is :" + conSalary);
			} else if (level.equals("expert")) {
				pay = salSoftwareEng + salSoftwareEng * 0.04;
				tax = pay * 0.07;
				conSalary = paymentContract(pay, contractPay, tax);
				System.out.println("Salary for " + name + " with Id " + id + " is :" + conSalary);
			}
			break;

		case "DevLead":
			if (level.equals("beginner")) {
				pay = salDevLead;
				tax = pay * 0.05;
				conSalary = paymentContract(pay, contractPay, tax);
				System.out.println("Salary for " + name + " with Id " + id + " is :" + conSalary);
			} else if (level.equals("intermediate")) {
				pay = salDevLead + salDevLead * 0.02;
				tax = pay * 0.06;
				conSalary = paymentContract(pay, contractPay, tax);
				System.out.println("Salary for " + name + " with Id " + id + " is :" + conSalary);
			} else if (level.equals("expert")) {
				pay = salDevLead + salDevLead * 0.04;
				tax = pay * 0.07;
				conSalary = paymentContract(pay, contractPay, tax);
				System.out.println("Salary for " + name + " with Id " + id + " is :" + conSalary);
			}
			break;

		case "TechLead":
			if (level.equals("beginner")) {
				pay = salTechLead;
				tax = pay * 0.05;
				conSalary = paymentContract(pay, contractPay, tax);
				System.out.println("Salary for " + name + " with Id " + id + " is :" + conSalary);
			} else if (level.equals("intermediate")) {
				pay = salTechLead + salTechLead * 0.02;
				tax = pay * 0.06;
				conSalary = paymentContract(pay, contractPay, tax);
				System.out.println("Salary for " + name + " with Id " + id + " is :" + conSalary);
			} else if (level.equals("expert")) {
				pay = salTechLead + salTechLead * 0.04;
				tax = pay * 0.07;
				conSalary = paymentContract(pay, contractPay, tax);
				System.out.println("Salary for " + name + " with Id " + id + " is :" + conSalary);
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
