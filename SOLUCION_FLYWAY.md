# Solución: Flyway no crea las tablas

## Problema
La aplicación conecta a la base de datos `evaluador_db` pero Flyway no está ejecutando las migraciones, por lo que no se crean las tablas. Probablemente Flyway se conectó a otra base de datos y creó `flyway_schema_history` ahí.

## ✅ Solución Implementada

He configurado Flyway para que **limpie y migre automáticamente** la base de datos cada vez que inicies la aplicación.

### Cambios realizados:

1. **application.properties** - Configuración de Flyway:
   ```properties
   spring.flyway.clean-disabled=false
   spring.flyway.clean-on-validation-error=true
   spring.flyway.validate-on-migrate=false
   ```

2. **FlywayConfig.java** - Bean que ejecuta limpieza y migración automática:
   - Ejecuta `flyway.clean()` para eliminar todas las tablas (incluyendo `flyway_schema_history`)
   - Ejecuta `flyway.migrate()` para crear todas las tablas desde cero

### Cómo usar:

1. **Reinicia tu aplicación Spring Boot**
2. **Flyway automáticamente:**
   - Limpiará la base de datos `evaluador_db` (eliminará todas las tablas)
   - Ejecutará el script `V1__initial.sql`
   - Creará todas las tablas necesarias

3. **Verás este mensaje en la consola:**
   ```
   ✅ Flyway: Base de datos limpiada y migraciones ejecutadas correctamente
   ```

### ⚠️ IMPORTANTE - Solo para desarrollo

Esta configuración **ELIMINA TODAS LAS TABLAS** cada vez que inicias la aplicación. Es perfecta para desarrollo, pero **NO uses esto en producción**.

### Para producción (cuando ya tengas datos reales):

Cambia en `application.properties`:
```properties
spring.flyway.clean-disabled=true
spring.flyway.clean-on-validation-error=false
spring.flyway.validate-on-migrate=true
```

Y **elimina o comenta** el archivo `FlywayConfig.java`.

## Verificación

Después de reiniciar la aplicación, verifica que las tablas se crearon:

```sql
SELECT table_name 
FROM information_schema.tables 
WHERE table_schema = 'public'
ORDER BY table_name;
```

Deberías ver: `usuarios`, `cat_rol`, `alumnos`, `tutores`, `flyway_schema_history`, etc.

## Logs útiles para debugging

Cuando inicies la aplicación, busca en los logs líneas como:

```
INFO  o.f.core.internal.command.DbClean - Successfully cleaned schema "public"
INFO  o.f.core.internal.command.DbMigrate - Migrating schema "public" to version "1 - initial"
INFO  o.f.core.internal.command.DbMigrate - Successfully applied 1 migration to schema "public"
✅ Flyway: Base de datos limpiada y migraciones ejecutadas correctamente
```
