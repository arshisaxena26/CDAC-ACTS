package com.app.org;

public class GrowableStack implements Stack {
	int counter = 0;
	Employee[] emp = new Employee[STACK_SIZE];
	Employee[] emp1 = new Employee[STACK_SIZE * 2];

	@Override
	public void push(int id, String name) {
		if (emp[emp.length - 1] == null) {
			if (counter < emp.length) {
				emp[counter++] = new Employee(id, name);
			}
		} else {
			for (int i = 0; i < emp.length; i++) {
				emp1[i] = emp[i];
			}
			if (counter < emp1.length) {
				emp1[counter++] = new Employee(id, name);
			}
		}
	}

	@Override
	public void pop() {
		if(emp1[0]==null) {
			if (counter > 0) {
				System.out.println(emp[counter-1]);
				emp[--counter]=null;
			} else
				System.out.println("Stack Empty");
		}
		else {
			System.out.println(counter);
			if (counter > 0) {
				System.out.println(emp1[counter-1]);
				emp1[--counter]=null;
			} else
				System.out.println("Stack Empty");
		}
	}
}
