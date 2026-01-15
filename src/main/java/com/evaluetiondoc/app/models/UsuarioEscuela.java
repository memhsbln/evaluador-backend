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
@Table(name = "usuario_escuela")
public class UsuarioEscuela {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario_escuela")
    private Long idUsuarioEscuela;

    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "id_escuela")
    private Long idEscuela;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}

