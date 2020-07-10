
public class Alternation {

	boolean isT1turn;
	final Object lock = new Object();
	Thread t1;
	Thread t2;
	int t1count = 1;
	int t2count = 2;

	public Alternation() {

		isT1turn = true;
		t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				while (t1count <= 50) {
					synchronized (lock) {
						if (isT1turn ) {
							System.out.println("T1=" + t1count);
							isT1turn = false;
							t1count += 2;
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
							}
						}
					}//end of sync
				}//end of for
			}
		});
		t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				while (t2count <= 50) {
					synchronized (lock) {
						if (!isT1turn) {
							System.out.println("T2=" + t2count);
							isT1turn = true;
							t2count += 2;
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
							}
						}
					}//end of sync
				}
			}
		});
		t1.start();
		t2.start();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Alternation();
	}
}


