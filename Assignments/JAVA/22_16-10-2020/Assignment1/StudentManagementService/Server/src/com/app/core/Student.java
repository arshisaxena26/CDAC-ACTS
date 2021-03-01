package com.app.core;

import java.io.Serializable;
import java.time.LocalDate;


public class Student implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String rollNo;
	private String name;
	private LocalDate dob;
	private Subject subject;
	private double gpa;
	private Address address;
	public Student(String rollNo, String name, LocalDate dob, Subject subject, double gpa) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.dob = dob;
		this.subject = subject;
		this.gpa = gpa;
	}
	@Override
	public String toString() {
		return "Student rollNo=" + rollNo + ", name=" + name + ", dob=" + dob + ", subject=" + subject 
				+ ", gpa=" + gpa
				+ "adr : "+address;
	}
	
	//Getters
	
	public String getName() {
		return name;
	}
	public String getRollNo() {
		return rollNo;
	}
	public LocalDate getDob() {
		return dob;
	}
	public Subject getSubject() {
		return subject;
	}
	public double getGpa() {
		return gpa;
	}
	public void assignAddress(Address a)
	{
		this.address=a;
	}
	public Address getAddress() {
		return address;
	}
}
