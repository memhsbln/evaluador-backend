package com.evaluetiondoc.app.repositories;

import com.evaluetiondoc.app.models.ProfesorAlumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorAlumnoRepository extends JpaRepository<ProfesorAlumno, Long> {
}

