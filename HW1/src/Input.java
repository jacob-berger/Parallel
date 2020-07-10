public class Input implements Runnable {

	private String word;

	public Input(String word) {
		this.word = word;
	}

	@Override
	public void run() {
		while (true) {
			if (!Thread.interrupted()) {
				HW1.output.append(word + "\n");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					return;
				}
			} else {
				return;
			}
		}
	}
}
