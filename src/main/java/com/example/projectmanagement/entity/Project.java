package com.example.projectmanagement.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long projectId;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "project_description")
    private String projectDescription;

    @OneToMany
    @JoinTable(name = "project_task", joinColumns
            = @JoinColumn(name = "project_id",
    referencedColumnName = "project_id"),
    inverseJoinColumns = @JoinColumn(name = "task_id",
    referencedColumnName = "task_id"))
    private List<Task> tasks;

    @Column(name = "progress")
    private Integer progress;

    public Project(Long projectId, String projectName, String projectDescription, List<Task> tasks, Integer progress) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.tasks = tasks;
        this.progress = progress;
    }

    public Project(Long projectId, String projectName, String projectDescription, Integer progress) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.progress = progress;
    }

    public Project() {
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }
}
