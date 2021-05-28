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
        findProjectById(projectId);
        return projectRepository.findById(projectId).get();
    }

    public void changeProject(Project project, Long projectId) {
        findProjectById(projectId);
        projectRepository.save(project);
    }

    public void deleteProject(Long projectId) {
        projectRepository.deleteById(projectId);
    }

    private void findProjectById(Long projectId) {
        projectRepository.findById(projectId).orElseThrow(() ->
                new NoSuchElementException("Project " + projectId + " was not found"));
    }
}
