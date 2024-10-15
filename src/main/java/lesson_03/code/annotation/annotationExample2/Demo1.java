package lesson_03.code.annotation.annotationExample2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Demo1 {
    public static void main(String[] args) throws NoSuchMethodException {


        Class<DemoClass> demoClass = DemoClass.class;

        Annotation[] annotations = demoClass.getAnnotations();

        for (Annotation annotation : annotations) {
            if (annotation instanceof JavaFileInfo javaFileInfo) {
                System.out.println("Автор: " + javaFileInfo.name());
                System.out.println("Версия: " + javaFileInfo.value());

            }
        }


        Method method = demoClass.getMethod("printString");

        annotations = method.getAnnotations();

        for (Annotation annotation : annotations) {
            if (annotation instanceof JavaFileInfo javaFileInfo) {
                System.out.println("Автор: " + javaFileInfo.name());
                System.out.println("Версия: " + javaFileInfo.value());

            }
        }

    }
}
