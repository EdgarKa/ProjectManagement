package com.example.projectmanagement.service;

import com.example.projectmanagement.entity.Task;
import com.example.projectmanagement.entity.TaskDifficulty;
import com.example.projectmanagement.entity.TaskStatus;
import com.example.projectmanagement.repo.ProjectRepository;
import com.example.projectmanagement.repo.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatsService {
    private ProjectRepository projectRepository;
    private TaskRepository taskRepository;

    public StatsService(ProjectRepository projectRepository, TaskRepository taskRepository) {
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
    }

    public String getAll() {

        return "Projects: " + projectRepository.count() +
                "\nTasks: " + taskRepository.count() +
                "\nEasy ones: " + getDiff(TaskDifficulty.Easy) +
                "\nMedium ones: " + getDiff(TaskDifficulty.Medium) +
                "\nHard ones: " + getDiff(TaskDifficulty.Hard) +
                "\nTasks to do: " + getStatus(TaskStatus.ToDo) +
                "\nTasks in progress: " + getStatus(TaskStatus.Doing) +
                "\nTasks done: " + getStatus(TaskStatus.Done);
    }

    private int getDiff(TaskDifficulty diff) {
        int i = 0;
        List<Task> tasks = taskRepository.findAll();
        for (Task task : tasks) {
            if (task.getDifficulty() == diff) {
                i++;
            }
        }
        return i;
    }

    private int getStatus(TaskStatus status) {
        int i = 0;
        List<Task> tasks = taskRepository.findAll();
        for (Task task : tasks) {
            if (task.getStatus() == status) {
                i++;
            }
        }
        return i;
    }
}
