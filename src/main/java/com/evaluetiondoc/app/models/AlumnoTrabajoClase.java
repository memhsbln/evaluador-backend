package com.evaluetiondoc.app.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "alumno_trabajo_clase")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlumnoTrabajoClase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_trabajo")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    private String trabajo;
    private Float calificacion;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}

