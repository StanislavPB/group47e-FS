package consultation.consultation_01.code.interrupt;

public class Example3 implements Runnable{

    private boolean stop;


    @Override
    public void run() {
        while (!stop) {
            System.out.println("Thread is running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){}
        }
    }

    public void stopThread() {
        stop = true;
    }


}
