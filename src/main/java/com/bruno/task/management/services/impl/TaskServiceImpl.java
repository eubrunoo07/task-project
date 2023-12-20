package com.bruno.task.management.services.impl;

import com.bruno.task.management.dtos.CategoryDTO;
import com.bruno.task.management.dtos.TaskDTO;
import com.bruno.task.management.dtos.TaskPatchMappingDTO;
import com.bruno.task.management.dtos.responses.TaskResponseDTO;
import com.bruno.task.management.entities.Category;
import com.bruno.task.management.entities.Task;
import com.bruno.task.management.entities.User;
import com.bruno.task.management.enums.TaskStatus;
import com.bruno.task.management.repositories.CategoryRepository;
import com.bruno.task.management.repositories.TaskRepository;
import com.bruno.task.management.services.TaskService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Task transformDtoToEntity(TaskDTO dto) {
        Category category = categoryRepository
                .findById(dto.getCategory())
                .orElseThrow(() -> new IllegalArgumentException("Category with id " + dto.getCategory() + " not found"));
        Task task = new Task();
        BeanUtils.copyProperties(dto, task);
        task.setCategory(category);
        return task;
    }

    @Override
    public Task save(Task task) {
        if(task.getEnd_time().isBefore(LocalDate.now())){
            throw new IllegalArgumentException("The due date cannot be earlier than this date");
        }
        if(task.getEnd_time().isEqual(LocalDate.now())){
            throw new IllegalArgumentException("The due date must be at least one day after the current date");
        }
        task.setStatus(TaskStatus.valueOf("PENDENT"));
        task.setStart_time(LocalDate.now());
        return taskRepository.save(task);
    }

    @Override
    public TaskResponseDTO taskById(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Task with id " + id + " not found"));
        Category category = categoryRepository.findById(task.getCategory().getId()).orElseThrow(() -> new IllegalArgumentException("Category with id " + task.getCategory().getId() + " not found"));
        return TaskResponseDTO.builder()
                .task_name(task.getTask_name())
                .description(task.getDescription())
                .start_time(task.getStart_time())
                .end_time(task.getEnd_time())
                .priorities(task.getPriorities())
                .category(category.getCategory())
                .status(task.getStatus())
                .id(task.getId())
                .build();
    }

    @Override
    public void update(TaskDTO dto, Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Task with id " + id + " not found"));
        Long taskID = task.getId();
        LocalDate start_time = task.getStart_time();
        BeanUtils.copyProperties(dto, task);
        task.setId(taskID);
        taskRepository.save(task);
    }

    @Override
    public void delete(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Task with id " + id + " not found"));
        taskRepository.delete(task);
    }

    @Override
    public List<TaskResponseDTO> allTasks() {
        List<TaskResponseDTO> dtos = new ArrayList<>();
        for (Task task : taskRepository.findAll()) {
            TaskResponseDTO dto = TaskResponseDTO.builder()
                    .id(task.getId())
                    .task_name(task.getTask_name())
                    .category(task.getCategory().getCategory())
                    .priorities(task.getPriorities())
                    .end_time(task.getEnd_time())
                    .start_time(task.getStart_time())
                    .description(task.getDescription())
                    .status(task.getStatus())
                    .build();
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public void updateStatusOfExpiredTasks() {
        List<Task> expiredTasks = new ArrayList<>();
        for (Task task : taskRepository.findAll()) {
            if(task.getEnd_time().isBefore(LocalDate.now()) && task.getStatus().toString().equals("PENDENT")){
                expiredTasks.add(task);
            }
        }

        for(Task task : expiredTasks){
            task.setStatus(TaskStatus.EXPIRED);
            taskRepository.save(task);
        }
    }

    @Override
    public void updateStatus(Long id, TaskPatchMappingDTO status) {
         Task task = taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Task with id " + id + " not found"));
         task.setStatus(TaskStatus.valueOf(status.getStatus()));
         taskRepository.save(task);
    }
}
