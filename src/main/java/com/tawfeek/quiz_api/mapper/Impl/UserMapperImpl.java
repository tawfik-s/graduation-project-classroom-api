package com.tawfeek.quiz_api.mapper.Impl;


import com.tawfeek.quiz_api.entity.User;
import com.tawfeek.quiz_api.mapper.UserMapper;
import com.tawfeek.quiz_api.model.Role;
import com.tawfeek.quiz_api.model.user.UserRequestDTO;
import com.tawfeek.quiz_api.model.user.UserResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public  User toEntity(UserRequestDTO userRequestDTO) {
        User newUser = new User();
        newUser.setUserName(userRequestDTO.getUserName());
        newUser.setPassword(userRequestDTO.getPassword());
        newUser.setEmail(userRequestDTO.getEmail());
        newUser.setRole(Role.USER);
        return newUser;
    }

    @Override
    public  UserResponseDTO toDTO(User user) {
        UserResponseDTO newUserResponseDTO = new UserResponseDTO();
        newUserResponseDTO.setId(user.getId());
        newUserResponseDTO.setUserName(user.getActualName());
        newUserResponseDTO.setEmail(user.getEmail());
        return newUserResponseDTO;
    }
}
