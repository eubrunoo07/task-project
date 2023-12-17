package com.bruno.task.management.repositories;

import com.bruno.task.management.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
