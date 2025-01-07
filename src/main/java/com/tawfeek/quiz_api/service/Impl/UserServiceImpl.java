package com.tawfeek.quiz_api.service.Impl;

import com.tawfeek.quiz_api.entity.User;
import com.tawfeek.quiz_api.exception.RecordNotFoundException;
import com.tawfeek.quiz_api.mapper.UserMapper;
import com.tawfeek.quiz_api.model.user.UserResponseDTO;
import com.tawfeek.quiz_api.repository.UserRepository;
import com.tawfeek.quiz_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserResponseDTO getUser(Long id) {
       User user= userRepository.findById(id).orElseThrow(RecordNotFoundException::new);
        return userMapper.toDTO(user);
    }

    @Override
    public List<UserResponseDTO> findUsersByName(String name) {
        List<User> users = userRepository.findByUserName(name).orElseThrow(RecordNotFoundException::new);
        return users.stream().map(user->userMapper.toDTO(user)).toList();
    }

    @Override
    public UserResponseDTO findUserByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(RecordNotFoundException::new);
        return userMapper.toDTO(user);
    }
}
