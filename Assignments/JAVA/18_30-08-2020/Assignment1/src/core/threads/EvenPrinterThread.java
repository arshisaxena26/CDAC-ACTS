package core.threads;

public class EvenPrinterThread extends Thread {
	// private data members
	private int start, end;

	// Parameterized Constructor
	public EvenPrinterThread(String name, int start, int end) {
		super(name); // Calling Thread Class' Constructor
		this.start = start;
		this.end = end;
		start(); // Calling Thread Class Method to start thread
	}

	// Overriding run method
	@Override
	public void run() {
		try {
			for (int i = start; i <= end; i++) {
				if (i % 2 == 0) {
					System.out.println("Even Number:" + i);
				}
				Thread.sleep(100); // Delay
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
