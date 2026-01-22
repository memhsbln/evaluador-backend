package com.evaluetiondoc.app.repositories;

import com.evaluetiondoc.app.models.CatNivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatNivelRepository extends JpaRepository<CatNivel, Long> {
}

