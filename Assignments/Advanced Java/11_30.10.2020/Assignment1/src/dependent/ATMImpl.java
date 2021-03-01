package dependent;

import dependency.Transport;

public class ATMImpl implements ATM {
	private Transport myTransport;
	private double cash;

	// Constructor based D.I
	public ATMImpl(double c) {
		cash = c;
	}

	@Override
	public void deposit(double amt) {
		System.out.println("Depositing " + amt);
		byte[] data = ("depositing " + amt).getBytes();
		myTransport.informBank(data);
		cash += amt; // Updating Cash in ATM
	}

	@Override
	public void withdraw(double amt) {
		System.out.println("Withdrawing " + amt);

		if (cash >= amt) {
			cash -= amt; // Updating Cash in ATM
			byte[] data = ("withdrawing " + amt).getBytes();
			myTransport.informBank(data);
		} else
			System.out.println("OUT OF CASH. Try Again Later!\n");
	}

	@Override
	public void cashInATM() {
		System.out.println("Cash in ATM: " + cash);
		byte[] data = ("Cash In ATM :" + cash).getBytes();
		myTransport.informBank(data);
	}

	// setter Based D.I
	public void setMyTransport(Transport myTransport) {
		this.myTransport = myTransport;
	}

	// init style method
	public void init() {
		System.out.println("in init " + myTransport + "\n");
	}

	// destroy style method
	public void destroy() {
		System.out.println("in destroy " + myTransport);
	}
}
