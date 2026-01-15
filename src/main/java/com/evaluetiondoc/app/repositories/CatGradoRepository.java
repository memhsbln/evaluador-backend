package com.evaluetiondoc.app.repositories;

import com.evaluetiondoc.app.models.CatGrado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatGradoRepository extends JpaRepository<CatGrado, Long> {
}

