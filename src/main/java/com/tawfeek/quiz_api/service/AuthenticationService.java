package com.tawfeek.quiz_api.service;

import com.tawfeek.quiz_api.model.auth.AuthenticationRequest;
import com.tawfeek.quiz_api.model.auth.AuthenticationResponse;
import com.tawfeek.quiz_api.model.user.UserRequestDTO;

public interface AuthenticationService {

    public AuthenticationResponse register(UserRequestDTO request);

    public AuthenticationResponse authenticate(AuthenticationRequest request);


}
