Create database foroHub;
USE forohub;
SELECT * FROM flyway_schema_history; -- Ejemplo para Flyway
SELECT * FROM migrations; -- O la tabla que uses
delete from flyway_schema_history where success = 0;