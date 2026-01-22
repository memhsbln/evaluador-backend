package com.evaluetiondoc.app.controllers;

import com.evaluetiondoc.app.config.JwtUtil;
import com.evaluetiondoc.app.models.Usuario;
import com.evaluetiondoc.app.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioService usuarioService;

    private final JwtUtil jwtUtil = new JwtUtil("secret-key-por-defecto-cambiar");

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Usuario usuario) {
        Usuario saved = usuarioService.save(usuario);
        return ResponseEntity.ok(Map.of("id", saved.getId(), "email", saved.getEmail()));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        try {
            String email = body.get("email");
            String password = body.get("password");
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
            String access = jwtUtil.generateAccessToken(email);
            String refresh = jwtUtil.generateRefreshToken(email);
            return ResponseEntity.ok(Map.of("access_token", access, "refresh_token", refresh));
        } catch (AuthenticationException ex) {
            return ResponseEntity.status(401).body(Map.of("error", "Credenciales inválidas"));
        }
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(@RequestBody Map<String, String> body) {
        try {
            String refresh = body.get("refresh_token");
            var decoded = jwtUtil.verify(refresh);
            String email = decoded.getSubject();
            String access = jwtUtil.generateAccessToken(email);
            return ResponseEntity.ok(Map.of("access_token", access));
        } catch (Exception ex) {
            return ResponseEntity.status(401).body(Map.of("error", "Refresh token inválido"));
        }
    }
}

