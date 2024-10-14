package lesson_02.code.threadAndJoinAndDaemon.task_04;

public class MyCounter implements Runnable{

    private Counter counter;

    public MyCounter(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            counter.increment();
            System.out.println("Count =" + counter.getCount() + " в потоке " + Thread.currentThread().getName());
        }
    }
}
