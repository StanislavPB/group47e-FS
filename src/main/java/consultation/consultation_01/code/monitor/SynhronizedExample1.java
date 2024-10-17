package consultation.consultation_01.code.monitor;

public class SynhronizedExample1 {

    public static void main(String[] args) throws InterruptedException {

        Object lockObj = new Object();

        Runnable task = () -> {
            synchronized (lockObj) {
                System.out.println("thread");
            }
        };

        //=========================

        Thread thread = new Thread(task);
        thread.start();

        for (int i = 0; i < 100000; i++) {

        }

        synchronized (lockObj) {
            for (int i = 0; i < 8; i++) {
                Thread.currentThread().sleep(1000);
                System.out.print(" " + i);
            }
            System.out.println("... ");
        }


    }
}
