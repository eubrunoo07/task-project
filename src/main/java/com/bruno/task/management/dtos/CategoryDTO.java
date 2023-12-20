package com.bruno.task.management.dtos;

import com.bruno.task.management.entities.Task;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter@Setter
@JsonPropertyOrder({"key", "category"})
public class CategoryDTO {
    @JsonProperty("key")
    private Long id;
    @NotBlank(message = "Category cannot be empty or null")
    private String category;
}
