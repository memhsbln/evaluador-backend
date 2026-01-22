package com.evaluetiondoc.app.repositories;

import com.evaluetiondoc.app.models.ProfesorMateriaGradoGrupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorMateriaGradoGrupoRepository extends JpaRepository<ProfesorMateriaGradoGrupo, Long> {
}

