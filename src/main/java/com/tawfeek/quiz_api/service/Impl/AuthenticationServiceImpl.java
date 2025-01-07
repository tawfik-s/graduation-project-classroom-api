package com.tawfeek.quiz_api.service.Impl;


import com.tawfeek.quiz_api.mapper.UserMapper;
import com.tawfeek.quiz_api.model.auth.AuthenticationRequest;
import com.tawfeek.quiz_api.model.auth.AuthenticationResponse;
import com.tawfeek.quiz_api.model.user.UserRequestDTO;
import com.tawfeek.quiz_api.repository.UserRepository;
import com.tawfeek.quiz_api.security.JwtService;
import com.tawfeek.quiz_api.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder passwordEncoder;


    public AuthenticationResponse register(UserRequestDTO request) {
        var user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .userResponseDTO(userMapper.toDTO(user))
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .userResponseDTO(userMapper.toDTO(user))
                .build();
    }
}
