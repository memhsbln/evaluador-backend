package com.evaluetiondoc.app.services;

import com.evaluetiondoc.app.dto.AuthResponseDTO;
import com.evaluetiondoc.app.dto.LoginRequestDTO;
import com.evaluetiondoc.app.dto.RegisterRequestDTO;

public interface AuthService {
    AuthResponseDTO login(LoginRequestDTO requestDTO);
    AuthResponseDTO register(RegisterRequestDTO requestDTO);
    AuthResponseDTO refresh(String refreshToken);
}

