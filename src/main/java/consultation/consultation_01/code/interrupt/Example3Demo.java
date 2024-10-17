package consultation.consultation_01.code.interrupt;

public class Example3Demo {
    public static void main(String[] args) throws InterruptedException {

        Example3 ie = new Example3();

        Thread thread = new Thread(ie);

        thread.start();

        Thread.sleep(5000);

        ie.stopThread();
    }
}
