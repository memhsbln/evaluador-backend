package com.evaluetiondoc.app.services.impl;

import com.evaluetiondoc.app.config.JwtUtil;
import com.evaluetiondoc.app.dto.AuthResponseDTO;
import com.evaluetiondoc.app.dto.LoginRequestDTO;
import com.evaluetiondoc.app.dto.RegisterRequestDTO;
import com.evaluetiondoc.app.exceptions.CredencialesInvalidasException;
import com.evaluetiondoc.app.exceptions.EmailYaRegistradoException;
import com.evaluetiondoc.app.exceptions.NombreUsuarioYaRegistradoException;
import com.evaluetiondoc.app.exceptions.RefreshTokenInvalidoException;
import com.evaluetiondoc.app.models.Usuario;
import com.evaluetiondoc.app.repositories.UsuarioRepository;
import com.evaluetiondoc.app.services.AuthService;
import org.mapstruct.factory.Mappers;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(AuthenticationManager authenticationManager,
                          UsuarioRepository usuarioRepository,
                          PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = new JwtUtil("secret-key-por-defecto-cambiar"); // Debe ser configurable
    }

    @Override
    public AuthResponseDTO login(LoginRequestDTO requestDTO) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestDTO.getEmail(), requestDTO.getPassword()));
            String access = jwtUtil.generateAccessToken(requestDTO.getEmail());
            String refresh = jwtUtil.generateRefreshToken(requestDTO.getEmail());
            return new AuthResponseDTO(access, refresh);
        } catch (AuthenticationException ex) {
            throw new CredencialesInvalidasException("Credenciales inválidas");
        }
    }

    @Override
    public AuthResponseDTO register(RegisterRequestDTO requestDTO) {
        if (usuarioRepository.findByEmail(requestDTO.getEmail()).isPresent()) {
            throw new EmailYaRegistradoException("El email ya está registrado");
        }
        if (usuarioRepository.findByNombreUsuario(requestDTO.getUsername()).isPresent()) {
            throw new NombreUsuarioYaRegistradoException("El nombre de usuario ya está registrado");
        }
        if (!requestDTO.getPassword().equals(requestDTO.getConfirmPassword())) {
            throw new IllegalArgumentException("Las contraseñas no coinciden");
        }
        Usuario usuario = new Usuario();
        usuario.setNombre(requestDTO.getName());
        usuario.setNombreUsuario(requestDTO.getUsername());
        usuario.setEmail(requestDTO.getEmail());
        usuario.setApellido(requestDTO.getApellido());
        usuario.setPassword(passwordEncoder.encode(requestDTO.getPassword()));
        usuarioRepository.save(usuario);

        String access = jwtUtil.generateAccessToken(usuario.getEmail());
        String refresh = jwtUtil.generateRefreshToken(usuario.getEmail());
        return new AuthResponseDTO(access, refresh);
    }

    @Override
    public AuthResponseDTO refresh(String refreshToken) {
        try {
            var decoded = jwtUtil.verify(refreshToken);
            String email = decoded.getSubject();
            String access = jwtUtil.generateAccessToken(email);
            return new AuthResponseDTO(access, refreshToken);
        } catch (Exception ex) {
            throw new RefreshTokenInvalidoException("Refresh token inválido");
        }
    }
}

