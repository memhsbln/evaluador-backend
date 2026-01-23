-- Migración V1: script inicial proporcionado por el usuario

CREATE TABLE IF NOT EXISTS cat_rol (
    id_rol serial PRIMARY KEY,
    nombre varchar(50) UNIQUE NOT NULL,
    created_at timestamp DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS cat_status (
    id_status serial PRIMARY KEY,
    status varchar(50) UNIQUE NOT NULL,
    created_at timestamp DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS cat_grado (
    id_grado serial PRIMARY KEY,
    grado varchar(50) NOT NULL,
    created_at timestamp DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS cat_grupo (
    id_grupo serial PRIMARY KEY,
    grupo varchar(50) NOT NULL,
    created_at timestamp DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS cat_nivel (
    id_nivel serial PRIMARY KEY,
    nivel varchar(100) NOT NULL,
    created_at timestamp DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS cat_materias (
    id_materia serial PRIMARY KEY,
    materia varchar(100) NOT NULL,
    created_at timestamp DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS cat_escuelas (
    id_escuela serial PRIMARY KEY,
    escuela varchar(100) NOT NULL,
    clave varchar(100) UNIQUE,
    created_at timestamp DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS tutores (
    id_tutor serial PRIMARY KEY,
    nombre varchar(100) NOT NULL,
    apellido_paterno varchar(100) NOT NULL,
    apellido_materno varchar(100),
    telefono varchar(20),
    email varchar(100),
    created_at timestamp DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS usuarios (
    id_usuario serial PRIMARY KEY,
    id_rol int REFERENCES cat_rol(id_rol),
    nombre varchar(100) NOT NULL,
    apellido varchar(100) NOT NULL,
    email varchar(100) UNIQUE NOT NULL,
    password varchar(255) NOT NULL,
    nombre_usuario varchar(100) UNIQUE,
    created_at timestamp DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS datos_escuela (
    id_datos_escuela serial PRIMARY KEY,
    id_escuela int REFERENCES cat_escuelas(id_escuela) ON DELETE CASCADE,
    imagen varchar(255),
    created_at timestamp DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS escuela_nivel (
    id_escuela_nivel serial PRIMARY KEY,
    id_nivel int REFERENCES cat_nivel(id_nivel),
    id_escuela int REFERENCES cat_escuelas(id_escuela),
    created_at timestamp DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS alumnos (
    id_alumno serial PRIMARY KEY,
    nombre varchar(100) NOT NULL,
    apellido_paterno varchar(100) NOT NULL,
    apellido_materno varchar(100),
    email varchar(100),
    id_grado int REFERENCES cat_grado(id_grado),
    id_grupo int REFERENCES cat_grupo(id_grupo),
    id_escuela int REFERENCES cat_escuelas(id_escuela),
    created_at timestamp DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS usuario_escuela (
    id_usuario_escuela serial PRIMARY KEY,
    id_usuario int REFERENCES usuarios(id_usuario) ON DELETE CASCADE,
    id_escuela int REFERENCES cat_escuelas(id_escuela) ON DELETE CASCADE,
    created_at timestamp DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS alumno_tutor (
    id_alumno_tutor serial PRIMARY KEY,
    id_alumno int REFERENCES alumnos(id_alumno) ON DELETE CASCADE,
    id_tutor int REFERENCES tutores(id_tutor) ON DELETE CASCADE,
    parentesco varchar(50),
    created_at timestamp DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS profesor_materia_grado_grupo (
    id_asignacion serial PRIMARY KEY,
    id_usuario int REFERENCES usuarios(id_usuario),
    id_materia int REFERENCES cat_materias(id_materia),
    id_grado int REFERENCES cat_grado(id_grado),
    id_grupo int REFERENCES cat_grupo(id_grupo),
    UNIQUE(id_usuario, id_materia, id_grado, id_grupo),
    created_at timestamp DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS observaciones_alumnos (
    id_observacion serial PRIMARY KEY,
    id_alumno int REFERENCES alumnos(id_alumno) ON DELETE CASCADE,
    observacion text,
    id_usuario int REFERENCES usuarios(id_usuario),
    created_at timestamp DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS alumno_materias (
    id_alumno_materia serial PRIMARY KEY,
    id_alumno int REFERENCES alumnos(id_alumno),
    id_materia int REFERENCES cat_materias(id_materia),
    calificacion float,
    created_at timestamp DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS examen_alumno_materia (
    id_examen serial PRIMARY KEY,
    id_alumno int REFERENCES alumnos(id_alumno),
    id_materia int REFERENCES cat_materias(id_materia),
    calificacion float CHECK (calificacion >= 0 AND calificacion <= 10),
    parcial int,
    created_at timestamp DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS alumno_tarea (
    id_tarea serial PRIMARY KEY,
    id_alumno int REFERENCES alumnos(id_alumno),
    tarea varchar(100),
    descripcion text,
    calificacion float CHECK (calificacion >= 0 AND calificacion <= 10),
    created_at timestamp DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS alumno_trabajo_clase (
    id_trabajo serial PRIMARY KEY,
    id_alumno int REFERENCES alumnos(id_alumno),
    trabajo varchar(100),
    calificacion float CHECK (calificacion >= 0 AND calificacion <= 10),
    created_at timestamp DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS datos_pago (
    id_pago serial PRIMARY KEY,
    id_usuario int REFERENCES usuarios(id_usuario),
    id_status int REFERENCES cat_status(id_status),
    monto decimal(10,2),
    fecha_pago timestamp,
    fecha_vencimiento timestamp,
    created_at timestamp DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS profesor_alumno (
    id_profesor_alumno serial PRIMARY KEY,
    id_usuario int REFERENCES usuarios(id_usuario),
    id_alumno int REFERENCES alumnos(id_alumno),
    created_at timestamp DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp DEFAULT CURRENT_TIMESTAMP
);

