package com.bruno.task.management.controllers;

import com.bruno.task.management.dtos.UserDTO;
import com.bruno.task.management.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/management/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public String register(@RequestBody@Valid UserDTO dto){
        return "token";
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody@Valid UserDTO dto){
        if(service.credentialsIsValid(dto)){
            return ResponseEntity.status(HttpStatus.OK).body("Successfully login");
        }
        else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Credentials is invalid");
        }
    }

    @PutMapping("/update/{id}")
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
