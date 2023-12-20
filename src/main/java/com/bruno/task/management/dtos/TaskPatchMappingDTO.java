package com.bruno.task.management.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class TaskPatchMappingDTO {
    @NotBlank(message = "Status cannot be null or empty")
    private String status;
}
