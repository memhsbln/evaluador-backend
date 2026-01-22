package com.evaluetiondoc.app.services;

import com.evaluetiondoc.app.models.Usuario;
import com.evaluetiondoc.app.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UsuarioService {

    Usuario findByEmail(String email);

    Usuario save(Usuario usuario);

    Usuario findById(Long id);

    void deleteById(Long id);

    List<Usuario> findAll();


}

