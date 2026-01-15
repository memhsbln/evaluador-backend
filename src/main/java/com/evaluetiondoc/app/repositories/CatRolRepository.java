package com.evaluetiondoc.app.repositories;

import com.evaluetiondoc.app.models.CatRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRolRepository extends JpaRepository<CatRol, Long> {
}

