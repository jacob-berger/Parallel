
public class Searcher extends Thread {

    public String pattern;
    public SharedQueue queue;
    public boolean searching = true;
    public int numFound = 0;

    public Searcher(String pattern, SharedQueue queue) {

        this.pattern = pattern;
        this.queue = queue;

    }

    public void run() {

        while (searching) {
            synchronized (queue) {
                if (queue.size != 0) {
                    String line = queue.Dequeue();

                    if (line.contains(pattern)) {
                        numFound++;
                    }
                } else {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        System.out.println("Found " + numFound + " matches.");
        
    }

}
