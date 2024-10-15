package lesson_03.code.reflection.example2;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HumanReflectionMethods {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {


        Human john = new Human("John", "London");

        Class humanClass = john.getClass();

        Method[] methods = humanClass.getDeclaredMethods();

        for (Method method : methods){
            System.out.println(method);

            if (method.getName().contains("Secret")){
                System.out.println("Private method was find!");
                method.setAccessible(true);
                int secretCode = (int) method.invoke(john, "Our method was broken");
                System.out.println(secretCode);
            }
        }

    }
}
