package core.threads;

public class EvenPrinterTask implements Runnable {
	// private data members
	private int start, end;

	// Parameterized Constructor
	public EvenPrinterTask(int start, int end) {
		this.start = start;
		this.end = end;
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
