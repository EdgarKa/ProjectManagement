package com.example.projectmanagement.service;

import com.example.projectmanagement.entity.Project;
import com.example.projectmanagement.repo.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ProjectServiceTest {

    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private ProjectService projectService;

    @Test
    void addProject() {
        Project project = new Project(1L, "name1", "description1", 0);

        when(projectRepository.save(project)).thenReturn(project);
        when(projectRepository.findById(1L)).thenReturn(Optional.of(project));

        Project expected = projectService.getProject(1L);

        assertEquals(project.getProjectName(), expected.getProjectName());
        assertEquals(project.getProjectDescription(), expected.getProjectDescription());
    }

    @Test
    void getAllProjects() {
        List<Project> projects = new ArrayList<>();
        projects.add(new Project(1L, "name1", "description1", 0));
        projects.add(new Project(2L, "name2", "description2", 0));
        projects.add(new Project(3L, "name3", "description3", 0));

        when(projectRepository.findAll()).thenReturn(projects);

        List<Project> savedProjects = projectService.getAllProjects();

        assertNotNull(savedProjects);
        assertEquals(projects, savedProjects);
    }

    @Test
    void getProject() {
        Project project = new Project(1L, "name1", "description1", 0);

        when(projectRepository.findById(1L)).thenReturn(Optional.of(project));

        Project savedProject = projectService.getProject(1L);

        assertNotNull(savedProject);
        assertEquals(project, savedProject);
    }

    @Test
    void changeProject() {
        Project project = new Project(1L, "name1", "description1", 0);
        when(projectRepository.save(project)).thenReturn(project);

        assertEquals(project.getProjectId(), 1L);
    }

    @Test
    void deleteProject() {
        Long projectId = 1L;
        projectService.deleteProject(projectId);
        projectService.deleteProject(projectId);
        verify(projectRepository, times(2)).deleteById(projectId);
    }
}