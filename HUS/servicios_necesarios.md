# Servicios Backend Necesarios según Análisis de Vistas

Este documento lista los servicios REST que deben implementarse (o mejorarse) en el backend para cubrir las funcionalidades descritas en el análisis de vistas del frontend Angular. Se detallan validaciones y requerimientos esperados para cada endpoint.

---

## 1. Autenticación

### POST `/api/auth/login`
- **Descripción:** Iniciar sesión de usuario.
- **Request:** `{ "email": string, "password": string }`
- **Validaciones:**
  - Ambos campos requeridos.
  - Email debe existir en la base de datos.
  - Contraseña debe ser válida (comparar hash).
- **Response:**
  - 200: `{ "access_token": string, "refresh_token": string }`
  - 401: `{ "error": "Credenciales inválidas" }`

### POST `/api/auth/register`
- **Descripción:** Registrar nuevo usuario.
- **Request:** `{ "name": string, "username": string, "email": string, "password": string, "confirmPassword": string }`
- **Validaciones:**
  - Todos los campos requeridos.
  - Email con formato válido y único.
  - Username único.
  - Contraseña con longitud mínima (ej. 8 caracteres).
  - `password` y `confirmPassword` deben coincidir.
- **Response:**
  - 200: `{ "id": number, "email": string }`
  - 400: `{ "error": "Mensaje de validación" }`

### POST `/api/auth/refresh`
- **Descripción:** Renovar access token usando refresh token.
- **Request:** `{ "refresh_token": string }`
- **Validaciones:**
  - Token válido y no expirado.
- **Response:**
  - 200: `{ "access_token": string }`
  - 401: `{ "error": "Refresh token inválido" }`

---

## 2. Usuarios

### GET `/api/usuarios`
- **Descripción:** Listar todos los usuarios (requiere autenticación y permisos adecuados).

### GET `/api/usuarios/{id}`
- **Descripción:** Obtener usuario por ID.

### POST `/api/usuarios`
- **Descripción:** Crear usuario (usualmente solo admins).

### DELETE `/api/usuarios/{id}`
- **Descripción:** Eliminar usuario.

---

## 3. Alumnos

### GET `/api/alumnos`
- **Descripción:** Listar alumnos.

### GET `/api/alumnos/{id}`
- **Descripción:** Obtener alumno por ID.

### POST `/api/alumnos`
- **Descripción:** Crear alumno.

### PUT `/api/alumnos/{id}`
- **Descripción:** Actualizar alumno.

### DELETE `/api/alumnos/{id}`
- **Descripción:** Eliminar alumno.

---

## 4. Chatbot (Pendiente de Implementar)
- **Descripción:** Servicio para recibir y responder mensajes del chatbot.
- **Sugerencia:**
  - POST `/api/chatbot/message` con `{ "message": string }`
  - Validar autenticación y tamaño del mensaje.
  - Responder con `{ "reply": string }`.

---

## Observaciones Generales
- Los formularios de login y registro en frontend requieren integración real con estos servicios.
- Validar exhaustivamente los datos recibidos en cada endpoint.
- Implementar manejo de errores y mensajes claros para el frontend.
- Revisar duplicidad de lógica (por ejemplo, validaciones de email único en registro y creación de usuario).

---

*Generado automáticamente a partir del análisis de vistas y el código backend actual.*

