package consultation.consultation_01.code.interrupt;

public class Example2 {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Working ...");
                for (int i = 0; i < 2000000000; i++) {

                }
                // делаем какой-то код
            }
            System.out.println("Thread finished ...");
        };
        // =========================================

        System.out.println("Старт приложения");
        Thread thread = new Thread(task);
        thread.start();


        Thread.sleep(100);
        System.out.println("Перерываем поток ");
        thread.interrupt();
    }
}
