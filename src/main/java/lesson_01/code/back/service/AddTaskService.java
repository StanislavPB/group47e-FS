package lesson_01.code.back.service;

import lesson_01.code.back.dto.RequestDto;
import lesson_01.code.back.dto.ResponseDto;
import lesson_01.code.back.repository.InMemoryRepository;
import lesson_01.code.back.service.validation.ValidationService;
import lesson_01.code.back.service.validation.validationRules.CoreError;
import lesson_01.code.back.entity.Task;
import java.util.List;

public class AddTaskService {

    private final InMemoryRepository repository;
    private final ValidationService validationService;

    public AddTaskService(InMemoryRepository repository, ValidationService validationService) {
        this.repository = repository;
        this.validationService = validationService;
    }


    public ResponseDto<Task> addNewTask(RequestDto request) {
        // пока что вместо лога используем печать на экран
        System.out.println("Receive request: " + request);

        // валидация данных

        List<CoreError> errors = validationService.validation(request);
        Task savedTask = null;

        if (errors.isEmpty()) {
            Task taskForSave = new Task(0, request.getTaskName(), request.getTaskDescription());
            savedTask = repository.add(taskForSave);
        }

        return new ResponseDto<>(savedTask,errors);

    }

}
