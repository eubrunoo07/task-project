package com.bruno.task.management.repositories;

import com.bruno.task.management.entities.Task;
import com.bruno.task.management.enums.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
