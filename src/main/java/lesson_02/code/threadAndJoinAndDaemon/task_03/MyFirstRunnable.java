package lesson_02.code.threadAndJoinAndDaemon.task_03;

public class MyFirstRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello from Thread " + Thread.currentThread().getName());
    }
}
