
public class Message implements Runnable {

	public String name;
	
	public Message(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		
		while (true) {
			try {
				Display.output.append("Message from Thread----> " + name + "\n");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				return;
			}
		}

	}

}
