package lesson_01.code.back.service.validation.validationRules;

import lesson_01.code.back.dto.RequestDto;

public interface ValidationRule {

    void validate(RequestDto request);
}
