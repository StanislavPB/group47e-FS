package lesson_01.code.back.service;

import lesson_01.code.back.dto.ResponseDto;
import lesson_01.code.back.entity.Task;
import lesson_01.code.back.repository.InMemoryRepository;
import lesson_01.code.back.service.validation.validationRules.CoreError;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FindTaskService {
    private final InMemoryRepository repository;

    public FindTaskService(InMemoryRepository repository) {
        this.repository = repository;
    }

    public ResponseDto<List<Task>> findAll(){
        List<CoreError> errors = new ArrayList<>();
        List<Task> allTasks = repository.findAll();

        if (allTasks.isEmpty()) {
            errors.add(new CoreError("Task database is empty"));
        }

        return new ResponseDto<>(allTasks,errors);

    }

    public ResponseDto<Task> findById(Integer id){

        Optional<Task> foundedTaskOptional = repository.findTaskById(id);
        List<CoreError> errors = new ArrayList<>();

        if (foundedTaskOptional.isEmpty()){
          errors.add(new CoreError("Task with id = " + id + " not found"));
            return new ResponseDto<>(null,errors);
        }

        return new ResponseDto<>(foundedTaskOptional.get(),errors);
    }

    public ResponseDto<List<Task>> findByName(String name){

        List<CoreError> errors = new ArrayList<>();
        List<Task> matchingTasks = repository.findAll().stream()
                .filter(task -> task.getTaskName().equals(name))
                .toList();

        if (matchingTasks.isEmpty()) {
            errors.add(new CoreError("No tasks found with name " + name));
        }

        return new ResponseDto<>(matchingTasks,errors);

    }
}
