package com.example.projectmanagement.service;

import com.example.projectmanagement.entity.Project;
import com.example.projectmanagement.repo.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProjectService {
    private ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public void addProject(Project project) {
        projectRepository.save(project);
    }

    public List<Project> getAllProjects() {
        return new ArrayList<>(projectRepository.findAll());
    }

    public Project getProject(Long projectId) {
        return projectRepository.findById(projectId).get();
    }

    public void changeProject(Project project, Long projectId) {
        projectRepository.save(project);
    }

    public void deleteProject(Long projectId) {
        projectRepository.deleteById(projectId);
    }

    private Project findProjectById(Long projectId) {
        return projectRepository.findById(projectId).orElseThrow(() ->
                new NoSuchElementException("Project " + projectId + " was not found"));
    }
}
