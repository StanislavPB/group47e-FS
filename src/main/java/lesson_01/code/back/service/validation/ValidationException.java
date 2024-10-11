package lesson_01.code.back.service.validation;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
