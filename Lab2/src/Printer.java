public class Printer implements Runnable {

    @Override
    public void run() {
        for (int ix = 1; ix <= 50; ix++) {
            try {
                if (ix == 26) {
                    Thread.sleep(100);
                }
                System.out.println("Message ix = " + ix + ", from Thread Printer");
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
