package lesson_01.code;


import lesson_01.code.back.repository.InMemoryRepository;
import lesson_01.code.back.repository.TaskRepository;
import lesson_01.code.back.service.AddTaskService;
import lesson_01.code.back.service.FindTaskService;
import lesson_01.code.back.service.validation.ValidationService;
import lesson_01.code.back.service.validation.validationRules.*;
import lesson_01.code.front.TaskAppUI;

import java.util.ArrayList;
import java.util.List;

public class TaskApp {
    public static void main(String[] args) {

        List<ValidationRule> validationRules = new ArrayList<>();
        validationRules.add(new TaskNameMaxLengthValidation());
        validationRules.add(new TaskNameMinLengthValidation());
        validationRules.add(new TaskNameNullValidation());
        validationRules.add(new TaskDescriptionNullValidation());

        ValidationService validationService = new ValidationService(validationRules);



        InMemoryRepository repository = new TaskRepository();
        AddTaskService addTaskService = new AddTaskService(repository,validationService);
        FindTaskService findTaskService = new FindTaskService(repository);

        TaskAppUI taskAppUI = new TaskAppUI(addTaskService,findTaskService);

        taskAppUI.start();


    }
}
