package core.threads;

public class OddPrinterTask implements Runnable {
	// private data members
	private int start, end;

	// Parameterized Constructor
	public OddPrinterTask(int start, int end) {
		this.start = start;
		this.end = end;
	}

	// Overriding run method
	@Override
	public void run() {
		try {
			for (int i = start; i <= end; i++) {
				if (i % 2 != 0) {
					System.out.println("Odd Number:" + i);
				}
				Thread.sleep(200); // Delay
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}