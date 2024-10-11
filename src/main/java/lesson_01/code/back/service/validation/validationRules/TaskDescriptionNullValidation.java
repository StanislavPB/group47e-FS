package lesson_01.code.back.service.validation.validationRules;

import lesson_01.code.back.dto.RequestDto;
import lesson_01.code.back.service.validation.ValidationException;

public class TaskDescriptionNullValidation implements ValidationRule{
    @Override
    public void validate(RequestDto request) {

        if (request.getTaskDescription() == null){
            throw new ValidationException("Task description must be not null");
        }
    }
}
