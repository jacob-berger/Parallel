public class MyMonitor {

	int currentThread = 0;
	int numThreads;

	public MyMonitor(int numThreads) {
		this.numThreads = numThreads;
	}

	public synchronized void increment() {

		currentThread = (currentThread + 1) % numThreads;

		this.notifyAll();
	}

}
