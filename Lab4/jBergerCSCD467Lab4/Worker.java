public class Worker extends Thread {

	private int count = 1;
	private int turn;
	private MyMonitor lock;

	public Worker(int turn, MyMonitor lock) {
		this.turn = turn;
		this.lock = lock;
	}

	public void run() {
		while (count <= 10){
			synchronized (lock) {
				if (lock.currentThread == turn) {
					switch (count) {
						case 1: System.out.println(count + "st Message from Thread " + turn);
						break;

						case 2: System.out.println(count + "nd Message from Thread " + turn);
						break;

						case 3: System.out.println(count + "rd Message from Thread " + turn);
						break;

						default: System.out.println(count + "th Message from Thread " + turn);
						break;
					}
					lock.increment();
					count++;
					if (count < 10) {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

}
