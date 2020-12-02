package com.app;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestConDeveloper {
	ConDeveloper cd = new ConDeveloper();

	@Test
	public void testContractSalary() {
		// Testing for Software Engineer
		assertEquals(1050, cd.paymentContract(1000, 100, 50), 0.0);
		assertEquals(2018, cd.paymentContract(2040, 100, 122), 0.0);
		assertEquals(2034, cd.paymentContract(2080, 100, 146), 0.0);

		// Testing for DevLead
		assertEquals(2000, cd.paymentContract(2000, 100, 100), 0.0);
		assertEquals(3935, cd.paymentContract(4080, 100, 245), 0.0);
		assertEquals(3969, cd.paymentContract(4160, 100, 291), 0.0);

		// Testing for TechLead
		assertEquals(2950, cd.paymentContract(3000, 100, 150), 0.0);
		assertEquals(5914, cd.paymentContract(6120, 100, 306), 0.0);
		assertEquals(5903, cd.paymentContract(6240, 100, 437), 0.0);
	}
}
