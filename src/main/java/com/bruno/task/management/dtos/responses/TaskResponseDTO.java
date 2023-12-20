package com.bruno.task.management.dtos.responses;

import com.bruno.task.management.enums.TaskStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter@Setter
@Builder
@JsonPropertyOrder({"key", "task_name", "description", "start_time", "end_time", "category", "priorities"})
public class TaskResponseDTO {
    @JsonProperty("key")
    private Long id;
    private String task_name;
    private String description;
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "America/Sao_Paulo")
    private LocalDate start_time;
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "America/Sao_Paulo")
    private LocalDate end_time;
    private String category;
    private String priorities;
    private TaskStatus status;
}
