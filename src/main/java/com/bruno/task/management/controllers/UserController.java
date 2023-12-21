package com.bruno.task.management.controllers;

import com.bruno.task.management.dtos.UserDTO;
import com.bruno.task.management.dtos.UserRegisterDTO;
import com.bruno.task.management.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/management/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody@Valid UserDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(service.login(dto));
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody@Valid UserRegisterDTO dto){
        service.register(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("#id == authentication.principal.id")
    public ResponseEntity<Object> update(@RequestBody@Valid UserDTO dto, @PathVariable Long id){
        service.update(dto, id);
        return ResponseEntity.status(HttpStatus.OK).body("User updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully");
    }

    @GetMapping("/")
    public List<UserDTO> users(){
        return service.allUsers();
    }

    @GetMapping("/{id}")
    public UserDTO userById(@PathVariable Long id){
        return service.userById(id);
    }

}
