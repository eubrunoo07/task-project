package com.bruno.task.management.services;

import com.bruno.task.management.dtos.TaskDTO;
import com.bruno.task.management.dtos.TaskPatchMappingDTO;
import com.bruno.task.management.dtos.responses.TaskResponseDTO;
import com.bruno.task.management.entities.Task;
import com.bruno.task.management.enums.TaskStatus;

import java.util.List;

public interface TaskService {
    Task transformDtoToEntity(TaskDTO dto);

    Task save(Task task);

    TaskResponseDTO taskById(Long id);

    void update(TaskDTO dto, Long id);

    void delete(Long id);

    List<TaskResponseDTO> allTasks();

    void updateStatusOfExpiredTasks();

    void updateStatus(Long id, TaskPatchMappingDTO status);
}
