package com.bruno.task.management.services.impl;

import com.bruno.task.management.dtos.UserDTO;
import com.bruno.task.management.entities.User;
import com.bruno.task.management.repositories.UserRepository;
import com.bruno.task.management.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User transformDtoToEntity(UserDTO dto) {
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        return user;
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public boolean credentialsIsValid(UserDTO dto) {
        String username = dto.getUsername();
        String password = dto.getPassword();
        boolean isValid = false;
        for (User user : repository.findAll()) {
            isValid = user.getUsername().equals(username) && user.getPassword().equals(password);
        }
        return isValid;
    }

    @Override
    public void update(UserDTO dto, Long id) {
        User user = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("User with id " + id + " not found"));
        Long userID = user.getId();
        BeanUtils.copyProperties(dto, user);
        user.setId(userID);
        repository.save(user);
    }

    @Override
    public void delete(Long id) {
        User user = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("User with id " + id + " not found"));
        repository.delete(user);
    }

    @Override
    public List<UserDTO> allUsers() {
        List<UserDTO> dtos = new ArrayList<>();
        for (User user : repository.findAll()) {
            UserDTO dto = new UserDTO();
            BeanUtils.copyProperties(user, dto);
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public UserDTO userById(Long id) {
        User user = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("User with id " + id + " not found"));
        UserDTO dto = new UserDTO();
        BeanUtils.copyProperties(user, dto);
        return dto;
    }
}
