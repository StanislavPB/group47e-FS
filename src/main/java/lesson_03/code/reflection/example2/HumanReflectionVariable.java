package lesson_03.code.reflection.example2;


import java.lang.reflect.Field;

public class HumanReflectionVariable {
    public static void main(String[] args) throws IllegalAccessException {

        Human john = new Human("John", "London");

        Class humanClass = john.getClass();

        Field[] fields = humanClass.getDeclaredFields();

        for (Field field : fields){
            System.out.println(field);

            if (field.getName().contains("name")){
                System.out.println("Private field 'name' was find!");
                field.setAccessible(true);
                field.set(john, "Bill");
            }
        }

        System.out.println(john);

    }
}
