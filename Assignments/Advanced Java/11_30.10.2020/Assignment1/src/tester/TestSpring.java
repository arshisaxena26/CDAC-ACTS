package tester;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dependent.ATMImpl;

public class TestSpring {

	public static void main(String[] args) {

		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml")) {

			ATMImpl atm1 = ctx.getBean("atm_impl", ATMImpl.class);

			// Business Logic
			atm1.deposit(1000);
			atm1.cashInATM();

			atm1.withdraw(2000);
			atm1.cashInATM();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
