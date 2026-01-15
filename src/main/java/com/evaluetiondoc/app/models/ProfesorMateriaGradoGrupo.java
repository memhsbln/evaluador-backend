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
@Table(name = "profesor_materia_grado_grupo")
public class ProfesorMateriaGradoGrupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignacion")
    private Long idAsignacion;

    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "id_materia")
    private Long idMateria;

    @Column(name = "id_grado")
    private Long idGrado;

    @Column(name = "id_grupo")
    private Long idGrupo;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}

