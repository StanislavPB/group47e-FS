package consultation.consultation_01.code.sleep;

public class HelloWorldApp {

    public static void main(String[] args) {

        Runnable task = () -> {
            try {
                int secWait = 20 * 1000;
                Thread.currentThread().sleep(secWait);
                System.out.println("Wake up!");
            } catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        };

        Thread thread = new Thread(task);
        thread.start();
    }
}
