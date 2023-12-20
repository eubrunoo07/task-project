package com.bruno.task.management.controllers;


import com.bruno.task.management.dtos.TaskDTO;
import com.bruno.task.management.dtos.TaskPatchMappingDTO;
import com.bruno.task.management.dtos.responses.TaskResponseDTO;
import com.bruno.task.management.entities.Task;
import com.bruno.task.management.enums.TaskStatus;
import com.bruno.task.management.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/management/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody@Valid TaskDTO dto){
        service.save(service.transformDtoToEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body("Task created successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@RequestBody@Valid TaskDTO dto, @PathVariable Long id){
        service.update(dto, id);
        return ResponseEntity.status(HttpStatus.OK).body("Task updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Task deleted successfully");
    }

    @GetMapping("/")
    public List<TaskResponseDTO> allTasks(){
        return service.allTasks();
    }

    @GetMapping("/{id}")
    public TaskResponseDTO taskById(@PathVariable Long id){
        return service.taskById(id);
    }

    @PatchMapping("update/status/{id}")
    public ResponseEntity<Object> updateStatus(@PathVariable Long id, @RequestBody TaskPatchMappingDTO status){
        service.updateStatus(id, status);
        return ResponseEntity.status(HttpStatus.OK).body("Status updated successfully");
    }

}
