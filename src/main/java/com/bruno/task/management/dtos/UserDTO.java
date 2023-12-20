package com.bruno.task.management.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@JsonPropertyOrder({"key", "username", "password"})
public class UserDTO {
    @JsonProperty("key")
    private Long id;
    @NotBlank(message = "Username cannot be empty or null")
    private String username;
    @NotBlank(message = "Password cannot be empty or null")
    private String password;
}
