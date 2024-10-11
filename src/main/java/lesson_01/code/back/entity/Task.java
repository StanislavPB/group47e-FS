package lesson_01.code.back.entity;

public class Task {
    private Integer taskId;
    private String taskName;
    private String taskDescription;

    public Task(Integer taskId, String taskName, String taskDescription) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                '}';
    }
}
