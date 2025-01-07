package com.tawfeek.quiz_api.service;

import com.tawfeek.quiz_api.model.user.UserResponseDTO;

import java.util.List;

public interface UserService {

    public UserResponseDTO getUser(Long id);

    public List<UserResponseDTO> findUsersByName(String name);

    public UserResponseDTO findUserByEmail(String email);

}
