package com.app.org;

public class FixedStack implements Stack {

	Employee[] emp = new Employee[STACK_SIZE];
	int counter = 0;

	@Override
	public void push(int id, String name) {
		if (counter < emp.length) {
			emp[counter++] = new Employee(id, name);
		}
		else
			System.out.println("Stack Full");
	}

	

	@Override
	public void pop() {
		for (int i = emp.length - 1; i >= 0; i--) {
			if (emp[i] != null) {
				emp[i] = null;
				break;
			}
		}
		for (Employee e : emp) {
			if (e != null)
				System.out.println(e);
		}
	}

}
