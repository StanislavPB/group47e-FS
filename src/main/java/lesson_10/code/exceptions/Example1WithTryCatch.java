package lesson_10.code.exceptions;


public class Example1WithTryCatch {
    public static void main(String[] args) {
        UserInput ui = new UserInput();

        int x = ui.inputInteger("Введите первое число");
        int y = ui.inputInteger("Введите второе число");


        try {
            System.out.println("результат деления: " + divide(x, y));
        } catch (Exception exception){
            System.out.println("произошла ошибка " + exception.getMessage());
        }


        System.out.println("Программа завершила свою работу");

    }

    static double divide(int x, int y){
        return x / y;
    }
}
