# kanban-backend-base (proyecto para completar)

Esqueleto limpio con **arquitectura MVC en capas**. Ya trae `pom.xml`, `application.yml`, las migraciones
de Flyway (tabla y datos de ejemplo) y la clase `KanbanApplication`.
Cada paquete tiene un `package-info.java` que indica qué crear (los `TODO`).

Sigue la guía `docs/GUIA-COMPLETA-PASO-A-PASO.md` del material de la clase 03
y compara con el proyecto terminado `kanban-backend`.

```
cl.ipss.kanban
├── enums         <- paso 2   (levantar y verificar)
├── entity        <- paso 2   (Model)
├── repository    <- paso 2
├── dto           <- paso 3   (levantar y verificar)
├── exception     <- paso 3
├── mapper        <- paso 4
├── service       <- paso 4   (interface)  /  service.impl <- paso 4 (levantar y verificar)
├── config        <- paso 5   (Swagger + CORS; levantar y ver Swagger)
└── controller    <- paso 6   (Controller; levantar y probar en Swagger)
```

## Base de datos (una sola vez)

Ejecuta [`crear-bd.sql`](crear-bd.sql) como superusuario `postgres`:

```powershell
psql -U postgres -h localhost -p 5432 -f crear-bd.sql
```

### 2. ¿Con qué usuario se conecta el backend?

Crear la base **no define el usuario**: el usuario es el de la conexión con la que el backend entra a PostgreSQL. El backend lee estas variables (valores por defecto entre paréntesis):

| Variable | Qué es | Por defecto |
|---|---|---|
| `DB_USER` | Usuario de PostgreSQL | `kanban` |
| `DB_PASSWORD` | Su clave | `kanban` |
| `DB_PORT` | Puerto del servidor | `5432` |
| `DB_NAME` | Nombre de la base | `kanban_db` |

**Opción A · Usar el mismo usuario con el que entras a pgAdmin.** Casi siempre es `postgres` con la clave que definiste al instalar PostgreSQL 18. Como el proyecto trae por defecto el usuario `kanban`, aquí **sí** debes indicar el usuario y la clave antes de levantar el backend (y el puerto si no es el 5432):

```powershell
$env:DB_USER = "postgres"
$env:DB_PASSWORD = "la_clave_de_postgres"
# $env:DB_PORT = "5433"     # solo si tu PostgreSQL 18 no usa el 5432
```

> ¿Cuál es mi puerto? En pgAdmin: clic derecho sobre el servidor → *Properties → Connection → Port*. O en el *Query Tool*: `SHOW port;`

**Opción B · Crear un usuario propio para esta aplicación** (es la que usa el proyecto por defecto: usuario `kanban`, clave `kanban`). Es lo habitual: un usuario por aplicación. En pgAdmin abre el **Query Tool sobre la base `kanban_db`** (clic derecho en `kanban_db` → *Query Tool*), pega este script y ejecútalo con **F5**:

```sql
-- Crea el usuario (o le actualiza la clave si ya existe)
DO $$
BEGIN
    IF NOT EXISTS (SELECT FROM pg_roles WHERE rolname = 'kanban') THEN
        CREATE USER kanban WITH PASSWORD 'kanban';
    ELSE
        ALTER USER kanban WITH PASSWORD 'kanban';
    END IF;
END
$$;

-- Lo hace dueño de la base: así Flyway puede crear la tabla y los datos
ALTER DATABASE kanban_db OWNER TO kanban;
GRANT ALL PRIVILEGES ON DATABASE kanban_db TO kanban;
GRANT ALL ON SCHEMA public TO kanban;
```

## Ejecutar

Se necesita Java 21 (`JAVA_HOME` apuntando a un JDK 21).

```powershell
.\mvnw.cmd spring-boot:run
```

Variables: `DB_HOST`, `DB_PORT`, `DB_NAME`, `DB_USER`, `DB_PASSWORD`, `SERVER_PORT` (8083 por defecto), `CORS_ORIGINS`, `LOG_LEVEL_APP`.
Swagger: http://localhost:8083/swagger-ui.html (vacío hasta que completes el paso 6).
