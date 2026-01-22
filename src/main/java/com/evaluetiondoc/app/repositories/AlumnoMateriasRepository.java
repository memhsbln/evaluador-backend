package com.evaluetiondoc.app.repositories;

import com.evaluetiondoc.app.models.AlumnoMaterias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoMateriasRepository extends JpaRepository<AlumnoMaterias, Long> {
}

