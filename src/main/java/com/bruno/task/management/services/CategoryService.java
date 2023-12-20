package com.bruno.task.management.services;

import com.bruno.task.management.dtos.CategoryDTO;
import com.bruno.task.management.entities.Category;

import java.util.List;

public interface CategoryService {
    Category transformDtoToEntity(CategoryDTO dto);

    Category save(Category category);

    void update(CategoryDTO dto, Long id);

    void delete(Long id);

    List<CategoryDTO> allCategories();

    CategoryDTO categoryById(Long id);
}
