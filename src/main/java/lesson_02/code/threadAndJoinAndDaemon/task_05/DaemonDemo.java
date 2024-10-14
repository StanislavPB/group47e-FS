package lesson_02.code.threadAndJoinAndDaemon.task_05;

public class DaemonDemo {
    public static void main(String[] args) {

        Thread worker = new Thread( () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {}

            String threadName = Thread.currentThread().getName();

            System.out.println("Thread is finishing its execution with name: " + threadName);
        }, "Worker");

        Thread daemon = new Thread( () -> {
            for (int i = 0; i < 10; i++) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}

            String threadName = Thread.currentThread().getName();

            System.out.println("Thread is finishing its execution with name: " + threadName);
        } }, "Daemon");

        daemon.setDaemon(true);

        worker.start();

        daemon.start();

        System.out.println();

        String threadName = Thread.currentThread().getName();

        System.out.println("Thread is finishing its execution with name: " + threadName);

    }
}
