package com.example.projectmanagement.controller;

import com.example.projectmanagement.entity.Task;
import com.example.projectmanagement.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/addtask")
    @ResponseStatus(HttpStatus.CREATED)
    public Long addTask(@RequestBody Task task) {
        taskService.addTask(task);
        return task.getTaskId();
    }

    @PostMapping("/addtask/{projectid}")
    public Long addTaskToProject(@RequestBody Task task, @PathVariable("projectid") Long projectId) {
        taskService.addTaskToProject(task, projectId);
        return task.getTaskId();
    }

    @GetMapping
    public List<Task> getAllTasks() { return taskService.getAllTasks(); }

    @GetMapping("/task/{taskid}")
    public Task getTask(@PathVariable("taskid")Long taskId) {
        return taskService.getTask(taskId);
    }

    @PutMapping("/task/{taskid}")
    public void changeTask(@RequestBody Task task, @PathVariable("taskid") Long taskId) {
        taskService.changeTask(task, taskId);
    }

    @DeleteMapping("/task/{taskid}")
    public void deleteTask(@PathVariable("taskid") Long taskId) {
        taskService.deleteTask(taskId);
    }

}
