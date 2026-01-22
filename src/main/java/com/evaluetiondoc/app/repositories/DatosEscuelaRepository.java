package com.evaluetiondoc.app.repositories;

import com.evaluetiondoc.app.models.DatosEscuela;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatosEscuelaRepository extends JpaRepository<DatosEscuela, Long> {
}

