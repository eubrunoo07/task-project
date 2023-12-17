package com.bruno.task.management.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class UserDTO {
    @NotBlank(message = "Username cannot be empty or null")
    private String username;
    @NotBlank(message = "Password cannot be empty or null")
    private String password;
}
