package com.bruno.task.management.repositories;

import com.bruno.task.management.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
