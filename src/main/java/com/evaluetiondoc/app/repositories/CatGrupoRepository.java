package com.evaluetiondoc.app.repositories;

import com.evaluetiondoc.app.models.CatGrupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatGrupoRepository extends JpaRepository<CatGrupo, Long> {
}

