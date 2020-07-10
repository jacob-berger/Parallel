public class Waiter implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(100);
            System.out.println("Printer got his work half done!");
            Thread.sleep(100);
            System.out.println("Waiter has done all its work, terminating.");
        } catch (InterruptedException e) {
            return;
        }


    }
}
