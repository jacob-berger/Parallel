
public class Searcher extends Thread {

	private String pattern;
	private SharedQueue queue;

	private int numFound = 0;

	public Searcher(String pattern, SharedQueue queue) {

		this.pattern = pattern;
		this.queue = queue;

	}

	public void run() {

		System.out.println("Searcher started.");

		while (true) {
		    String line = queue.dequeue();

		    if (line == null) break;
		    numFound += SerialSearchFile.searchLine(line, pattern);
		}

		System.out.println("Found " + numFound + " matches.\nSearcher done.");
	}
}
