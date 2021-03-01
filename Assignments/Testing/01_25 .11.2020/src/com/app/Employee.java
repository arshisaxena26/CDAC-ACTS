package com.app;

public class Employee implements Payable, incrementable {

	double salary;
	int empId;
	String empName;
	double conSalary;

	@Override
	public double payment(double pay, double tax) {
		salary = pay - tax;
		return salary;
	}

	@Override
	public double paymentContract(double pay, double contractPay, double tax) {
		conSalary = pay + contractPay - tax;
		return conSalary;
	}
}
