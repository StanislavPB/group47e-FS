package lesson_02.code.threadAndJoinAndDaemon.task_02;

public class Car extends Thread{

    private String model;

    public Car( String model) {
        this.model = model;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){}

        System.out.println("Car " + model + " is being driven in thr Thread " + Thread.currentThread().getName());
    }
}
