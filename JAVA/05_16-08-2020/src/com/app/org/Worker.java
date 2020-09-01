package com.app.org;

public class Worker extends Employee {
	private double hoursWorked,hourlyRate;
	
	public Worker(int id,String name,int deptId,double basicSal,double hoursWorked,double hourlyRate)
	{
		super(id,name,deptId,basicSal);
		this.hoursWorked=hoursWorked;
		this.hourlyRate=hourlyRate;
	}
	
	@Override
	public String toString()
	{
		return super.toString()+"\nWorker's Hours Worked: "+hoursWorked+"\nWorker's Hourly Rate: "+hourlyRate;
	}
	
	@Override
	public double computeNetSalary()
	{
		return getBasicSal()+(hoursWorked*hourlyRate);
	}

	public double getHourlyRate() {
		return hourlyRate;
	}
}
