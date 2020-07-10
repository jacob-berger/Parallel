public class Lab2 {

    static Thread Printer, Waiter;

    public static void main(String[] args) throws InterruptedException {
        Printer = new Thread(new Printer());
        Waiter = new Thread(new Waiter());

        Printer.start();
        Waiter.start();

        try {
            Printer.join();
            Waiter.join();
        } catch (InterruptedException e) {
            System.out.println("Something else called an interrupt?");
        }
        System.out.println("Both Waiter and Printer have finished their work!");
    }

}
