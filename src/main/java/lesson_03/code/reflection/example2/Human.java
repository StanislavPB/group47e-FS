package lesson_03.code.reflection.example2;

public class Human {

    private String name;
    private String address;

    public Human(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    private int generateSecretCode(String code){

        String str = "Secret " + code;
        System.out.println(str);
        return str.hashCode();
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
