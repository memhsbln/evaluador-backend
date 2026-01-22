package com.evaluetiondoc.app.repositories;

import com.evaluetiondoc.app.models.ObservacionAlumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObservacionAlumnoRepository extends JpaRepository<ObservacionAlumno, Long> {
}

