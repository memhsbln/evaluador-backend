package com.evaluetiondoc.app.repositories;

import com.evaluetiondoc.app.models.AlumnoTrabajoClase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoTrabajoClaseRepository extends JpaRepository<AlumnoTrabajoClase, Long> {
}

