package com.example.projectmanagement.repo;

import com.example.projectmanagement.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
