package lesson_02.code.threadAndJoinAndDaemon.task_0;

public class ThreadDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            MyFirstThread thread = new MyFirstThread();
            thread.start();
        }
    }
}
