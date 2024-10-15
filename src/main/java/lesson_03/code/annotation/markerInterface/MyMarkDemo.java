package lesson_03.code.annotation.markerInterface;

public class MyMarkDemo {
    public static void main(String[] args) {

        MyMarkClass marked = new MyMarkClass();
        NonMarkClass nonMarked = new NonMarkClass();

        test(marked);
        //test(nonMarked);

    }

    static void test(MyMark obj) {
        System.out.println("Метод 'test' пройден успешно!");
    }
}
