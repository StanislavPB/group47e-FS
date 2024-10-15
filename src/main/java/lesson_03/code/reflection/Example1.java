package lesson_03.code.reflection;

import java.lang.reflect.Method;

public class Example1 {
    public static void main(String[] args) {

        Class stringClass = String.class;

        Method[] methods = stringClass.getMethods();

        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i]);
        }
    }
}
