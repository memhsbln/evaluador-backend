package com.evaluetiondoc.app.services;

import com.evaluetiondoc.app.models.Alumno;


import java.util.List;
import java.util.Optional;

public interface AlumnoService {

    List<Alumno> findAll();

    Optional<Alumno> findById(Long id);

    Alumno save(Alumno alumno);

    Alumno update(Long id, Alumno alumno);

    void delete(Long id);
}

