package com.bruno.task.management.controllers;

import com.bruno.task.management.dtos.CategoryDTO;
import com.bruno.task.management.entities.Category;
import com.bruno.task.management.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/management/categories")
@CrossOrigin(origins = "*")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody@Valid CategoryDTO dto){
        service.save(service.transformDtoToEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body("Category created successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@RequestBody@Valid CategoryDTO dto, @PathVariable Long id){
        service.update(dto, id);
        return ResponseEntity.status(HttpStatus.OK).body("Category updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Category deleted successfully");
    }

    @GetMapping("/")
    public List<CategoryDTO> allCategories(){
        return service.allCategories();
    }

    @GetMapping("/{id}")
    public CategoryDTO categoryById(@PathVariable Long id){
        return service.categoryById(id);
    }
}
