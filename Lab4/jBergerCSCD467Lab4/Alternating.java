public class Alternating {

	public static void main(String[] args) {
		int numThreads = Integer.parseInt(args[0]);

		Worker[] threads = new Worker[numThreads];
		MyMonitor lock = new MyMonitor(numThreads);

		for (int ix = 0; ix < threads.length; ix++) {
			threads[ix] = new Worker(ix, lock);
			threads[ix].start();
		}

		for (Worker thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
