package com.evaluetiondoc.app.controllers;

import com.evaluetiondoc.app.common.ResponseUtil;
import com.evaluetiondoc.app.dto.AuthResponseDTO;
import com.evaluetiondoc.app.dto.LoginRequestDTO;
import com.evaluetiondoc.app.dto.RegisterRequestDTO;
import com.evaluetiondoc.app.dto.ResponseDTO;
import com.evaluetiondoc.app.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@Validated
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO<AuthResponseDTO>> login(@Valid @RequestBody LoginRequestDTO request) {
        AuthResponseDTO response = authService.login(request);
        return ResponseEntity.ok(ResponseUtil.ok(response));
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO<AuthResponseDTO>> register(@Valid @RequestBody RegisterRequestDTO request) {
        AuthResponseDTO response = authService.register(request);
        return ResponseEntity.ok(ResponseUtil.ok(response));
    }

    @PostMapping("/refresh")
    public ResponseEntity<ResponseDTO<AuthResponseDTO>> refresh(@RequestParam("refresh_token") String refreshToken) {
        AuthResponseDTO response = authService.refresh(refreshToken);
        return ResponseEntity.ok(ResponseUtil.ok(response));
    }
}
