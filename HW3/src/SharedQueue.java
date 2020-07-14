
import java.lang.reflect.Array;
import java.util.Queue;


public class SharedQueue {

    public String[] queue;
    public int maxSize = 10;
    public int size = 0;

    public SharedQueue() {
        queue = new String[100];
    }

    public synchronized boolean Enqueue(String string) {
        if (size < maxSize) {
            queue[size] = string;
            size++;
            notifyAll();
            return true;
        }

        return false;
    }

    public synchronized String Dequeue() {
        if (queue.length == 0) {
            notifyAll();
            return null;
        }

        String line = queue[0];
        for (int ix = 1; ix < queue.length - 1; ix++) {
            queue[ix - 1] = queue[ix];
        }

        size--;

        notifyAll();
        return line;
    }

    public synchronized boolean Full() {
        return size == maxSize;
    }

}
