package com.bruno.task.management.enums;

import lombok.Getter;

@Getter
public enum UserRole {
    USER("admin"),
    ADMIN("user");

    private String role;

    UserRole(String role){
        this.role = role;
    }
}
