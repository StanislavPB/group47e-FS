package lesson_02.code.threadAndJoinAndDaemon.task_01;

public class MyThread2 extends Thread{
    @Override
    public void run(){
        for (int i = 10000; i < 10010; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName() + " - " + i);
        }
    }
}
