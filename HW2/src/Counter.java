public class Counter {
	private int c = 0;
	private boolean inUse = false;

    public synchronized void increment( int n) {
        c += n;
    }

    public synchronized int total() {
        return c;
    }
}
