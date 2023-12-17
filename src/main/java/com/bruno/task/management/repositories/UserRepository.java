package com.bruno.task.management.repositories;

import com.bruno.task.management.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
