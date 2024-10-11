package lesson_01.code.back.repository;

import lesson_01.code.back.entity.Task;

import java.util.List;
import java.util.Optional;

public interface InMemoryRepository {

    Task add(Task task);

    Optional<Task> findTaskById(Integer id);

    List<Task> findAll();

    List<Task> findTasksByName(String name);


}
