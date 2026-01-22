package com.evaluetiondoc.app.services.impl;

import com.evaluetiondoc.app.models.Alumno;
import com.evaluetiondoc.app.repositories.AlumnoRepository;
import com.evaluetiondoc.app.services.AlumnoService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository alumnoRepository;

    public AlumnoServiceImpl(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    @Override
    @Cacheable(value = "alumnos")
    public List<Alumno> findAll() {
        return alumnoRepository.findAll();
    }

    @Override
    @Cacheable(value = "alumno", key = "#id")
    public Optional<Alumno> findById(Long id) {
        return alumnoRepository.findById(id);
    }

    @Override
    public Alumno save(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @Override
    @CachePut(value = "alumno", key = "#id")
    public Alumno update(Long id, Alumno alumno) {
        return alumnoRepository.findById(id).map(existing -> {
            existing.setNombre(alumno.getNombre());
            existing.setApellidoPaterno(alumno.getApellidoPaterno());
            existing.setApellidoMaterno(alumno.getApellidoMaterno());
            existing.setEmail(alumno.getEmail());
            existing.setId(alumno.getId());
            existing.setGrado(alumno.getGrado());
            existing.setEscuela(alumno.getEscuela());
            return alumnoRepository.save(existing);
        }).orElseGet(() -> {
            alumno.setId(id);
            return alumnoRepository.save(alumno);
        });
    }

    @Override
    @CacheEvict(value = "alumno", key = "#id")
    public void delete(Long id) {
        alumnoRepository.deleteById(id);
    }
}
