CREATE DATABASE Calificacion_convocatoria;
USE Calificacion_convocatoria;

CREATE TABLE Calificacion_convocatoria (
    carnet VARCHAR(20),
    nombre VARCHAR(100),
    CALF_CNV_1 DECIMAL(5,2),
    CALF_CNV_2 DECIMAL(5,2),
    CALF_FINAL DECIMAL(5,2)
);

INSERT INTO Calificacion_convocatoria (carnet, nombre, CALF_CNV_1, CALF_CNV_2, CALF_FINAL)
VALUES ('A001', 'Ana López', 85.5, 90.0, (85.5 + 90.0) / 2);

INSERT INTO Calificacion_convocatoria (carnet, nombre, CALF_CNV_1, CALF_CNV_2, CALF_FINAL)
VALUES ('B002', 'Carlos Martínez', 78.0, 82.5, (78.0 + 82.5) / 2);

INSERT INTO Calificacion_convocatoria (carnet, nombre, CALF_CNV_1, CALF_CNV_2, CALF_FINAL)
VALUES ('C003', 'Lucía Gómez', 92.0, 88.0, (92.0 + 88.0) / 2);

-- FUNCION
DELIMITER //

CREATE FUNCTION actualizar_promedio(carnet_input VARCHAR(20))
RETURNS DECIMAL(5,2)
DETERMINISTIC
BEGIN
    DECLARE promedio DECIMAL(5,2);
    
    UPDATE Calificacion_convocatoria
    SET CALF_FINAL = (CALF_CNV_1 + CALF_CNV_2) / 2
    WHERE carnet = carnet_input;

    SELECT CALF_FINAL INTO promedio
    FROM Calificacion_convocatoria
    WHERE carnet = carnet_input;

    RETURN promedio;
END;
//

DELIMITER ;

SELECT * FROM Calificacion_convocatoria WHERE carnet = 'A001';

-- PROCEDIMIENTO ALMACENADO
DELIMITER //

CREATE PROCEDURE RegistrarCalificacion(
    IN p_carnet VARCHAR(20),
    IN p_nombre VARCHAR(100),
    IN p_calf1 DECIMAL(5,2),
    IN p_calf2 DECIMAL(5,2)
)
BEGIN
    INSERT INTO Calificacion_convocatoria (carnet, nombre, CALF_CNV_1, CALF_CNV_2, CALF_FINAL)
    VALUES (p_carnet, p_nombre, p_calf1, p_calf2, (p_calf1 + p_calf2) / 2);
END;
//

DELIMITER ;

CALL RegistrarCalificacion('A001', 'Ana Aleman', 85.5, 90.0);

-- Vista
CREATE VIEW vista_calificaciones AS
SELECT carnet, nombre, CALF_CNV_1, CALF_CNV_2, CALF_FINAL
FROM Calificacion_convocatoria;

-- ejecutado
SELECT * FROM vista_calificaciones;

SELECT * FROM Calificacion_convocatoria;

