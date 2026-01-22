package com.evaluetiondoc.app.repositories;

import com.evaluetiondoc.app.models.CatMaterias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatMateriasRepository extends JpaRepository<CatMaterias, Long> {
}

