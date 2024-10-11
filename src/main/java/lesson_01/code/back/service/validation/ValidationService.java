package lesson_01.code.back.service.validation;

import lesson_01.code.back.dto.RequestDto;
import lesson_01.code.back.service.validation.validationRules.CoreError;
import lesson_01.code.back.service.validation.validationRules.ValidationRule;

import java.util.ArrayList;
import java.util.List;

public class ValidationService {

    private List<ValidationRule> validationRules;

    public ValidationService(List<ValidationRule> validationRules) {
        this.validationRules = validationRules;
    }

    public List<CoreError> validation(RequestDto request){
        List<CoreError> errors = new ArrayList<>();

        if (request == null) {
            errors.add(new CoreError("Task request must be not null"));
            return errors;
        }

        for (ValidationRule rule : validationRules){
           try {
               rule.validate(request);
           } catch (ValidationException e) {
               errors.add(new CoreError(e.getMessage()));
           }
        }


        return errors;
    }

}
