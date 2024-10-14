package lesson_02.code.threadAndJoinAndDaemon.task_01;

public class Main {
    public static void main(String[] args) {
        // Создание потоков с помощью класса Thread
        Thread thread1 = new MyThread1();
        Thread thread2 = new MyThread2();

        // запускаем наши потоки

        thread1.start();
        thread2.start();


    }
}
