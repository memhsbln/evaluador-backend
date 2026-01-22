package com.evaluetiondoc.app.repositories;

import com.evaluetiondoc.app.models.DatosPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatosPagoRepository extends JpaRepository<DatosPago, Long> {
}

