package com.app.org;

public class Manager extends Employee{
	private double perfBonus;
	
	public Manager(int id,String name,int deptId,double basicSal,double perfBonus)
	{
		super(id,name,deptId,basicSal);
		this.perfBonus=perfBonus;
	}
	
	@Override
	public String toString()
	{
		return super.toString()+"\nManager's Performance Bonus: "+perfBonus;
	}
	
	@Override
	public double computeNetSalary()
	{
		return getBasicSal()+perfBonus;
	}

	public double getPerfBonus() {
		return perfBonus;
	}
}
