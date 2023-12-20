package com.bruno.task.management.services.impl;

import com.bruno.task.management.dtos.CategoryDTO;
import com.bruno.task.management.dtos.UserDTO;
import com.bruno.task.management.entities.Category;
import com.bruno.task.management.entities.User;
import com.bruno.task.management.repositories.CategoryRepository;
import com.bruno.task.management.services.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Override
    public Category transformDtoToEntity(CategoryDTO dto) {
        Category category = new Category();
        BeanUtils.copyProperties(dto, category);
        return category;
    }

    @Override
    public Category save(Category category) {
        return repository.save(category);
    }

    @Override
    public void update(CategoryDTO dto, Long id) {
        Category category = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Category with id " + id + " not found"));
        Long categoryID = category.getId();
        BeanUtils.copyProperties(dto, category);
        category.setId(categoryID);
        repository.save(category);
    }

    @Override
    public void delete(Long id) {
        Category category = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Category with id " + id + " not found"));
        repository.delete(category);
    }

    @Override
    public List<CategoryDTO> allCategories() {
        List<CategoryDTO> dtos = new ArrayList<>();
        for (Category category : repository.findAll()) {
            CategoryDTO dto = new CategoryDTO();
            BeanUtils.copyProperties(category, dto);
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public CategoryDTO categoryById(Long id) {
        Category category = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Category with id " + id + " not found"));
        CategoryDTO dto = new CategoryDTO();
        BeanUtils.copyProperties(category, dto);
        return dto;
    }
}
