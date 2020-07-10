public class MyPrimeTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		if (args.length < 3) {
			System.out.println("Usage: MyPrimeTest numThread low high \n");
			return;
		}
		int nthreads = Integer.parseInt(args[0]);
		int low = Integer.parseInt(args[1]);
		int high = Integer.parseInt(args[2]);
		Counter c = new Counter();
		
		//test cost of serial code
		long start = System.currentTimeMillis();
		int numPrimeSerial = SerialPrime.numSerailPrimes(low, high);
		long end = System.currentTimeMillis();
		long timeCostSer = end - start;
		System.out.println("Time cost of serial code: " + timeCostSer + " ms.");
		
		//test of concurrent code
		// **************************************
		start = System.currentTimeMillis();

		ThreadPrime threads[] = new ThreadPrime[nthreads];

		for (int ix = 0; ix < nthreads; ix++) {
			threads[ix] = new ThreadPrime(low + (high/nthreads) * ix, (high / nthreads) * ix + (high / nthreads), c);
//			System.out.println("Thread " + ix + ", low: " + (low + (high/nthreads) * ix) + ", high: " + (high / nthreads * ix + (high / nthreads)));
			threads[ix].start();
		}

		for (int ix = 0; ix < nthreads; ix++) {
			threads[ix].join();
		}
		end = System.currentTimeMillis();
		long timeCostCon = end - start;
		
		// **************************************
		System.out.println("Time cost of parallel code: " + timeCostCon + " ms.");
		System.out.format("The speedup ration is by using concurrent programming: %5.2f. %n", (double)timeCostSer / timeCostCon);

		System.out.println("Number prime found by serial code is: " + numPrimeSerial);
		System.out.println("Number prime found by parallel code is " + c.total());
	}
		

}
