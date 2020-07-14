import apple.laf.JRSUIConstants;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.*;


public class Reader implements Runnable {

    String fileName;
    SharedQueue queue;
    String line;

    public Reader(String fileName, SharedQueue queue) {
        this.fileName = fileName;
        this.queue = queue;
    }

    @Override
    public void run() {

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                synchronized (queue) {
                    if (queue.Full()) {
                        System.out.println("READER WAITING");
                        queue.wait();
                    } else {
                        System.out.println(line);
                        queue.Enqueue(line);
                    }
                }
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
