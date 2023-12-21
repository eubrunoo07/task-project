package com.bruno.task.management.services;

import com.bruno.task.management.dtos.UserDTO;
import com.bruno.task.management.dtos.UserRegisterDTO;
import com.bruno.task.management.entities.User;

import java.util.List;

public interface UserService {
    User transformDtoToEntity(UserDTO dto);

    User save(User user);

    boolean credentialsIsValid(UserDTO dto);

    void update(UserDTO dto, Long id);

    void delete(Long id);

    List<UserDTO> allUsers();


    UserDTO userById(Long id);

    String login(UserDTO dto);

    void register(UserRegisterDTO dto);
}
