package com.example.projectmanagement.service;

import com.example.projectmanagement.entity.Project;
import com.example.projectmanagement.entity.Task;
import com.example.projectmanagement.entity.TaskStatus;
import com.example.projectmanagement.repo.ProjectRepository;
import com.example.projectmanagement.repo.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;

    public TaskService(TaskRepository taskRepository, ProjectRepository projectRepository) {
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
    }

    public void addTask(Task task) {
        taskRepository.save(task);
    }

    public void addTaskToProject(Task task, Long projectId) {
        findProjectById(projectId);
        Project project = projectRepository.getById(projectId);
        List<Task> tasks = project.getTasks();
        tasks.add(task);

        int i = 0;
        for (Task doneTasks : tasks) {
            if (doneTasks.getStatus() == TaskStatus.Done) {
                i++;
            }
        }
        int progress = (i * 100) / tasks.size();
        project.setTasks(tasks);
        project.setProgress(progress);
        projectRepository.save(project);
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

    private void findProjectById(Long projectId) {
        projectRepository.findById(projectId).orElseThrow(() ->
                new NoSuchElementException("Project with id " + projectId + " was not found"));
    }
}
