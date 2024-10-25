package lesson_11.code.regex;

public class IbanExample {
    public static void main(String[] args) {
        // IBAN DE89

        String ibanRegEx = "^[A-Z]{2}\\d{2}[A-Z0-9]{1,30}$";
    }
}
