package com.tawfeek.quiz_api.mapper;

import com.tawfeek.quiz_api.entity.User;
import com.tawfeek.quiz_api.model.user.UserRequestDTO;
import com.tawfeek.quiz_api.model.user.UserResponseDTO;

public interface UserMapper {

    public User toEntity(UserRequestDTO userRequestDTO);

    public UserResponseDTO toDTO(User user);
}
