package lesson_02.code.threadAndJoinAndDaemon.task_02;

public class CarDemo {
    public static void main(String[] args) {
       Car ferrari = new Car("Ferrari");
       Car bmw = new Car("BMW");

        ferrari.start();
        bmw.start();

        System.out.println("Main method continue execution ... ");
        System.out.println("Main method in the Thread " + Thread.currentThread().getName());
    }
}
