package com.app.org;

public class GrowableStack implements Stack {
	int counter = 0;
	Employee[] emp = new Employee[STACK_SIZE];
	Employee[] emp1 = new Employee[STACK_SIZE*2]; //Limited

	@Override
	public void push(int id, String name) {
		if (emp[emp.length - 1] == null) {
			if (counter < emp.length) {
				emp[counter++] = new Employee(id, name);
			}
		} else

		{
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
		if (emp1[0] == null) {
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
		} else {
			for (int i = emp1.length - 1; i >= 0; i--) {
				if (emp1[i] != null) {
					emp1[i] = null;
					break;
				}
			}
			for (Employee e : emp1) {
				if (e != null)
					System.out.println(e);
			}
		}
	}
}
