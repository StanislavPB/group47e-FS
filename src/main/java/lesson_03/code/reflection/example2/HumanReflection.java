package lesson_03.code.reflection.example2;


public class HumanReflection {
    public static void main(String[] args) {

        Human john = new Human("John", "London");

        Class humanClass = john.getClass();

        System.out.println(humanClass);

        /*

        getName() - возвращает имя и пакет класса
        getSimpleName() - возвращает имя класса
        getPackage() - возвращает имя пакета
        getModifiers() - возвращает модификаторы класса
        getSuperclass() - возвращает родительский класс
        getInterfaces() - возвращает список интерфейсов, которые класс использует
        getConstructors() - возвращает список конструкторов
        getFields() - возвращает список публичных полей класса
        getDeclaredFields() - возвращает список всех полей класса
        getMethods() - возвращает массив публичных методов класса
        getDeclaredMethods() - возвращает массив всех методов

         */
    }
}
