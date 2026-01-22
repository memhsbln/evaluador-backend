package com.evaluetiondoc.app.repositories;

import com.evaluetiondoc.app.models.AlumnoTutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoTutorRepository extends JpaRepository<AlumnoTutor, Long> {
}

