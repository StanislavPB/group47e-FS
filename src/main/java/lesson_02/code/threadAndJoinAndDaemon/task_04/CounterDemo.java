package lesson_02.code.threadAndJoinAndDaemon.task_04;

import lesson_02.code.threadAndJoinAndDaemon.task_01.MyThread1;

public class CounterDemo {

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();


        Thread thread = new Thread(new MyCounter(counter));
        Thread thread1 = new Thread(new MyCounter(counter));

        thread.start();
        thread1.start();

        // если нам нужно продолжить выполнение метода main
        // ТОЛЬКО после того как полностью отработаю оба потока


        thread.join();
        thread1.join();

        System.out.println(counter.getCount());
    }
}
