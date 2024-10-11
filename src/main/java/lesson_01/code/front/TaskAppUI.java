package lesson_01.code.front;

import lesson_01.code.back.dto.RequestDto;
import lesson_01.code.back.dto.ResponseDto;
import lesson_01.code.back.service.AddTaskService;
import lesson_01.code.back.service.FindTaskService;
import lesson_01.code.back.entity.Task;

import java.util.List;
import java.util.Scanner;

public class TaskAppUI {

    private final AddTaskService addTaskService;
    private final FindTaskService findTaskService;
    private final Scanner scanner;

    public TaskAppUI(AddTaskService addTaskService, FindTaskService findTaskService) {
        this.addTaskService = addTaskService;
        this.findTaskService = findTaskService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            printMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addNewTask();
                    break;
                case 2:
                    findAllTasks();
                    break;
                case 3:
                    findTaskById();
                    break;
                case 4:
                    findTaskByName();
                    break;
                case 5:
                    deleteTaskById();
                    break;
                case 6:
                    updateTask();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Incorrect ....");
            }
        }
    }

    private void updateTask() {
        System.out.println("Пока что я не умею это делать");
    }

    private void deleteTaskById() {
        System.out.println("Пока что я не умею это делать");
    }

    private void findTaskByName() {
        System.out.println("Enter task name:");
        String taskName = scanner.nextLine();

        ResponseDto<List<Task>> response = findTaskService.findByName(taskName);

        if (response.getErrors().isEmpty()) {
            System.out.println(response.getResult());
        } else {
            System.out.println(response.getErrors());
        }
    }

    private void findTaskById() {
        System.out.println("Enter task id:");
        Integer taskId = Integer.parseInt(scanner.nextLine());

        ResponseDto<Task> response = findTaskService.findById(taskId);

        if (response.getErrors().isEmpty()) {
            System.out.println(response.getResult());
        } else {
            System.out.println(response.getErrors());
        }
    }

    private void findAllTasks() {
        ResponseDto<List<Task>> response = findTaskService.findAll();

        if (response.getErrors().isEmpty()) {
            System.out.println(response.getResult());
        } else {
            System.out.println(response.getErrors());
        }
    }

    private void addNewTask() {
        System.out.println("Enter task name:");
        String name = scanner.nextLine();

        System.out.println("Enter task description:");
        String description = scanner.nextLine();

        RequestDto request = new RequestDto(name,description);

        ResponseDto<Task> response = addTaskService.addNewTask(request);

        if (response.getErrors().isEmpty()) {
            System.out.println(response.getResult());
        } else {
            System.out.println(response.getErrors());
        }

    }

    private void printMenu() {
        System.out.println("---------------------------------");
        System.out.println("User menu:");
        System.out.println("1. Add new task");
        System.out.println("2. Find all tasks");
        System.out.println("3. Find task by ID");
        System.out.println("4. Find tasks by name");
        System.out.println("5. Delete task by ID");
        System.out.println("6. Update task");
        System.out.println("7. Exit");

        System.out.println("Enter your choice:");
    }
}
