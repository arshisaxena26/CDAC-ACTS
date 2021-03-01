package com.app;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestOfficeAssistant {
	OfficeAssitant assistant = new OfficeAssitant();

	@Test
	public void testAssistantSalary() {

		assertEquals(950, assistant.payment(1000, 50), 0.0);
		assertEquals(1918, assistant.payment(2040, 122), 0.0);
		assertEquals(1934, assistant.payment(2080, 146), 0.0);
	}
}
