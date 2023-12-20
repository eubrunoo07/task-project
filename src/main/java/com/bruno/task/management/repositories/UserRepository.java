package com.bruno.task.management.repositories;

import com.bruno.task.management.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String username);
}
