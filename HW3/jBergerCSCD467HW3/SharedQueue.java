
import java.util.LinkedList;
import java.util.Queue;


public class SharedQueue {

    public Queue<String> queue = new LinkedList<String>();
    public int maxSize = 100;

    public synchronized void enqueue(String string) {
        while (queue.size() > maxSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        queue.add(string);
        notify();

    }

    public synchronized String dequeue() {
        while (queue.size() <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                return null;
            }
        }

        String line = queue.remove();
        notify();
        return line;
    }

}
