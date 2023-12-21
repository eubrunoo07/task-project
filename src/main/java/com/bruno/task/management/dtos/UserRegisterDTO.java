package com.bruno.task.management.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class UserRegisterDTO {
    @NotBlank(message = "Username cannot be null or empty")
    private String username;
    @NotBlank(message = "Password cannot be null or empty")
    private String password;
    @NotBlank(message = "Role cannot be null or empty")
    private String role;
}
