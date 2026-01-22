package com.evaluetiondoc.app.repositories;

import com.evaluetiondoc.app.models.CatEscuelas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatEscuelasRepository extends JpaRepository<CatEscuelas, Long> {
}

