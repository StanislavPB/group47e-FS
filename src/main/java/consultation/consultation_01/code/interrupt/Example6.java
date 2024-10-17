package consultation.consultation_01.code.interrupt;

public class Example6 {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("Thread is interrupted ...");
                Thread.currentThread().interrupt();
            }
        });

        thread.start();
        // прервем поток через 5 сек
        System.out.println("Main thread sleep 5 sec ");
        Thread.sleep(5000);

        System.out.println(thread.getState());

        if (thread.isAlive()) {
            System.out.println("My thread is alive and i try interrupt it");
            thread.interrupt();
        }

        Thread.sleep(1000);

        System.out.println(thread.getState());
    }
}
