package consultation.consultation_01.code.synch.synchExample3;

public class HelloWorldApp {
    public static void main(String[] args) {
        Object object = new Object();

        synchronized (object) {
            System.out.println("Hello World!");
        }
    }
}
