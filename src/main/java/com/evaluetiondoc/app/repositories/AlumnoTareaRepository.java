package com.evaluetiondoc.app.repositories;

import com.evaluetiondoc.app.models.AlumnoTarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoTareaRepository extends JpaRepository<AlumnoTarea, Long> {
}

