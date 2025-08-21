package com.shuvajit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shuvajit.pojo.Task;

@RestController
public class TaskController {
    private List<Task> taskList = new ArrayList<>();
    private int currentId = 1;
    public TaskController() {
        taskList.add(new Task(currentId++, "Learn Spring Boot", "Complete basic CRUD REST API"));
        taskList.add(new Task(currentId++, "Read Documentation", "Go through Spring official docs"));
        taskList.add(new Task(currentId++, "Practice Postman", "Test all API endpoints with JSON"));
        taskList.add(new Task(currentId++, "Database Setup", "Integrate with MySQL using Spring Data JPA"));
    }
    // Create a new task
    @PostMapping("/tasks")
    public Task createTask(@RequestBody Task task) {
        task.setId(currentId++);
        taskList.add(task);
        return task;
    }
//    http://localhost:8080/tasks
    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskList;
    }
//    http://localhost:8080/task/2
    @GetMapping("/task/{id}")
    public Task getTaskById(@PathVariable int id) {
        return taskList.stream().filter(task -> task.getId() == id).findFirst().orElse(null);
    }
    @PutMapping("/task/{id}")
    public Task updateTask(@PathVariable int id, @RequestBody Task updatedTask) {
        for (Task task : taskList) {
            if (task.getId() == id) {
                task.setTitle(updatedTask.getTitle());
                task.setDescription(updatedTask.getDescription());
                return task;
            }
        }
        return null;
    }
    @DeleteMapping("/task/{id}")
    public String deleteTask(@PathVariable int id) {
        boolean removed = taskList.removeIf(task -> task.getId() == id);
        return removed ? "Task deleted successfully!" : "Task not found!";
    }
}