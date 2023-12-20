package com.bruno.task.management.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter@Setter
public class TaskDTO {
    @NotBlank(message = "Task name cannot be null or empty")
    private String task_name;
    @NotBlank(message = "Description cannot be null or empty")
    private String description;
    @NotNull(message = "End date cannot be null or empty")
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "America/Sao_Paulo")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDate end_time;
    @NotNull(message = "Category cannot be null or empty")
    private Long category;
    @NotBlank(message = "Priorities cannot be null or empty")
    private String priorities;
}
