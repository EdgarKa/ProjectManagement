package com.example.projectmanagement.controller;

import com.example.projectmanagement.entity.Project;
import com.example.projectmanagement.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/addproject")
    @ResponseStatus(HttpStatus.CREATED)
    public Long addProject(@RequestBody Project project) {
        projectService.addProject(project);
        return project.getProjectId();
    }

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/project/{projectid}")
    public Project getProect(@PathVariable("projectid") Long projectId) {
        return projectService.getProject(projectId);
    }

    @PutMapping("/project/{projectid}")
    public void changeProject(@PathVariable("projectid")Long projectId,
                              @RequestBody Project project) {
        projectService.changeProject(project, projectId);
    }

    @DeleteMapping("/project/{projectid}")
    public void deleteProject(@PathVariable("projectid")Long projectId) {
        projectService.deleteProject(projectId);
    }
}
