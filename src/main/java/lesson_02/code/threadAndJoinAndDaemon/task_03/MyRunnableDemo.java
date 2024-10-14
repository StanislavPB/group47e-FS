package lesson_02.code.threadAndJoinAndDaemon.task_03;

public class MyRunnableDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new MyFirstRunnable());

            thread.start();
        }

        System.out.println("Main method finished");
    }
}
