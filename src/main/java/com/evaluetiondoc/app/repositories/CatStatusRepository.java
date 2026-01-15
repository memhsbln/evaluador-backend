package com.evaluetiondoc.app.repositories;

import com.evaluetiondoc.app.models.CatStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatStatusRepository extends JpaRepository<CatStatus, Long> {
}

