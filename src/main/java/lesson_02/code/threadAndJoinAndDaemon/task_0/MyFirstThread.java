package lesson_02.code.threadAndJoinAndDaemon.task_0;

public class MyFirstThread extends Thread{
    @Override
    public void run() {
        System.out.println("I'm thread! My name is " + getName());
    }
}
