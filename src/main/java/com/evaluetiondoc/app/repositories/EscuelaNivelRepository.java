package com.evaluetiondoc.app.repositories;

import com.evaluetiondoc.app.models.EscuelaNivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EscuelaNivelRepository extends JpaRepository<EscuelaNivel, Long> {
}

