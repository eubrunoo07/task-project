package com.bruno.task.management.services;

import com.bruno.task.management.dtos.UserDTO;
import com.bruno.task.management.entities.User;

public interface UserService {
    User transformDtoToEntity(UserDTO dto);

    User save(User user);

    boolean credentialsIsValid(UserDTO dto);
}
