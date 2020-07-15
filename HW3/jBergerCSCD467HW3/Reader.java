import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Reader implements Runnable {

	private String fileName;
	private SharedQueue queue;
	private FileReader fileReader;
	private Searcher searcher;

	public Reader(String fileName, SharedQueue queue, Searcher searcher) {
		this.fileName = fileName;
		this.queue = queue;
		this.searcher = searcher;
	}

	@Override
	public void run() {

		System.out.println("Reader started.");
		int row = 0;
		String line = null;
		try {
			fileReader = new FileReader(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		try {
			line = bufferedReader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			while ((line = bufferedReader.readLine()) != null) {
				queue.enqueue(line);
				row++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Reader done after " + row + " rows.");
		searcher.interrupt();

		try {
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
