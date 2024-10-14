package lesson_02.code.threadAndJoinAndDaemon.task_04;

public class Counter {

    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
