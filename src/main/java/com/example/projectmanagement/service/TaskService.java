package com.example.projectmanagement.service;

import com.example.projectmanagement.entity.Task;
import com.example.projectmanagement.repo.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void addTask(Task task) {
        taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }


    public Task getTask(Long taskId) {
        findTaskById(taskId);
        return taskRepository.getById(taskId);
    }

    public void changeTask(Task task, Long taskId) {
        findTaskById(taskId);
        taskRepository.save(task);
    }

    public void deleteTask(Long taskId) {
        Task task = findTaskById(taskId);
        taskRepository.delete(task);
    }

    private Task findTaskById(Long taskId) {
        return taskRepository.findById(taskId).orElseThrow(() ->
                new NoSuchElementException("Task with id " + taskId + " was not found"));

    }
}
