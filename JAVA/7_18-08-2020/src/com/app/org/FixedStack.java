package com.app.org;

public class FixedStack implements Stack {

	Employee[] emp = new Employee[STACK_SIZE];
	int counter = 0;

	@Override
	public void push(int id, String name) {
		if (counter < emp.length) {
			emp[counter++] = new Employee(id, name);
		} else 
			System.out.println("Stack Full");	
	}

	@Override
	public void pop() {
		if (counter > 0) {
			System.out.println(emp[counter-1]);
			emp[--counter]=null;
		} else
			System.out.println("Stack Empty");
	}
}
