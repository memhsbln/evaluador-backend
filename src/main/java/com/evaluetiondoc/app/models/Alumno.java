package com.evaluetiondoc.app.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "alumnos")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alumno")
    private Long idAlumno;

    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String email;

    @Column(name = "id_grado")
    private Long idGrado;

    @Column(name = "id_grupo")
    private Long idGrupo;

    @Column(name = "id_escuela")
    private Long idEscuela;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}

