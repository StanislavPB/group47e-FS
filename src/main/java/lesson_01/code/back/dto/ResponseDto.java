package lesson_01.code.back.dto;


import lesson_01.code.back.service.validation.validationRules.CoreError;

import java.util.List;

public class ResponseDto <T> {
    private T result;
    private List<CoreError> errors;

    public ResponseDto(T result, List<CoreError> errors) {
        this.result = result;
        this.errors = errors;
    }

    public T getResult() {
        return result;
    }

    public List<CoreError> getErrors() {
        return errors;
    }
}
