CREATE DATABASE Moto_Repuesto;

USE Moto_Repuesto;

CREATE TABLE Compras (
ID_Compra INT AUTO_INCREMENT PRIMARY KEY,
Fecha_compra DATE NOT NULL,
ID_Proveedor INT,
FOREIGN KEY (ID_Proveedor) REFERENCES Proveedores (ID_Proveedor)
);

CREATE TABLE Ventas (
ID_Venta INT AUTO_INCREMENT PRIMARY KEY,
Fecha_Venta DATE NOT NULL,
ID_Cliente INT,
FOREIGN KEY (ID_Cliente) REFERENCES Clientes (ID_Cliente)
);

CREATE TABLE Productos(
ID_Producto INT AUTO_INCREMENT PRIMARY KEY,
Nombre_P VARCHAR (100) NOT NULL,
Descripcion VARCHAR (100) NOT NULL,
Cantidad INT NOT NULL,
Preciodecom DOUBLE NOT NULL,
Preciodeven DOUBLE NOT NULL
);

CREATE TABLE Proveedores(
ID_Proveedor INT AUTO_INCREMENT PRIMARY KEY,
Nombre_Prov VARCHAR (100) NOT NULL,
Contacto VARCHAR (12) NOT NULL,
Email VARCHAR (100) NOT NULL
);

CREATE TABLE Clientes(
ID_Cliente INT AUTO_INCREMENT PRIMARY KEY,
Nombre_cli VARCHAR (60),
Apellidos_cli VARCHAR(60),
Cedula VARCHAR (60),
Telefono VARCHAR(12)
);

CREATE TABLE Detalle_Ventas(
ID_Detalle_ven INT AUTO_INCREMENT PRIMARY KEY,
ID_Venta INT NOT NULL,
ID_Producto INT NOT NULL,
Cantidad_ven INT NOT NULL,
Precio_Ven DOUBLE NOT NULL,
FOREIGN KEY (ID_Venta) REFERENCES Ventas (ID_Venta),
FOREIGN KEY (ID_Producto) REFERENCES Productos (ID_Producto)
);

CREATE TABLE Detalle_Compras(
ID_Detales_Com INT AUTO_INCREMENT PRIMARY KEY,
ID_Compra INT NOT NULL,
ID_Producto INT NOT NULL,
Cantidad_com INT NOT NULL,
Precio_Com DOUBLE NOT NULL,
FOREIGN KEY (ID_Producto) REFERENCES Productos (ID_Producto),
FOREIGN KEY (ID_Compra) REFERENCES Compras (ID_Compra)
);

-- Insertar datos en Proveedores
INSERT INTO Proveedores (Nombre_Prov, Contacto, Email) VALUES
('Repuestos Rápidos', '1234567890', 'contacto@repuestosrapidos.com'),
('MotoPartes S.A.', '0987654321', 'ventas@motopartes.com'),
('Speed Moto', '1122334455', 'info@speedmoto.com');

-- Insertar datos en Clientes
INSERT INTO Clientes (Nombre_cli, Apellidos_cli, Cedula, Telefono) VALUES
('Juan', 'Pérez', '123456789', '3216549870'),
('María', 'López', '987654321', '3007894561'),
('Carlos', 'Gómez', '567123890', '3159874562');

-- Insertar datos en Productos
INSERT INTO Productos (Nombre_P, Descripcion, Cantidad, Preciodecom, Preciodeven) VALUES
('Batería Moto X', 'Batería de 12V para motos', 50, 45.00, 70.00),
('Aceite Sintético', 'Aceite 10W-40 para motos', 100, 30.00, 50.00),
('Llantas Pirelli', 'Llantas de alta duración', 30, 100.00, 150.00);

INSERT INTO Productos (Nombre_P, Descripcion, Cantidad, Preciodecom, Preciodeven) VALUES
('Sistema de Rodamiento', 'Rodaminetos de alta calidad', 5, 2500.00, 3000.00);

-- Insertar más datos en la tabla Productos
INSERT INTO Productos (Nombre_P, Descripcion, Cantidad, Preciodecom, Preciodeven) VALUES
('Casco Integral Pro', 'Casco integral de alta seguridad', 20, 150.00, 250.00),
('Kit de Freno ABS', 'Sistema de frenos ABS de última generación', 10, 350.00, 500.00),
('Cadena de Transmisión', 'Cadena reforzada para motos deportivas', 40, 80.00, 120.00),
('Filtro de Aire', 'Filtro de aire para motocicletas estándar', 100, 20.00, 35.00),
('Amortiguadores Racing', 'Amortiguadores ajustables de alto rendimiento', 15, 200.00, 300.00),
('Manillar Deportivo', 'Manillar ergonómico de aluminio', 30, 50.00, 80.00),
('Juego de Pastillas de Freno', 'Pastillas de freno cerámicas', 70, 25.00, 40.00),
('Luces LED Frontales', 'Luces LED de alto brillo para motos', 50, 60.00, 100.00),
('Escape Deportivo', 'Sistema de escape deportivo de acero inoxidable', 5, 400.00, 600.00),
('Protector de Tanque', 'Protector adhesivo para el tanque de combustible', 120, 15.00, 25.00),
('Aceite de Cadena', 'Lubricante especial para cadenas de motos', 90, 10.00, 18.00),
('Claxon Eléctrico', 'Claxon eléctrico de alta potencia', 25, 40.00, 70.00),
('Espejos Retrovisores', 'Par de espejos retrovisores ajustables', 60, 30.00, 55.00),
('Cubierta de Llantas', 'Cubiertas protectoras para llantas', 35, 90.00, 130.00),
('Kit de Herramientas Básicas', 'Kit con herramientas esenciales para motos', 40, 50.00, 85.00);

INSERT INTO Compras (Fecha_compra, ID_Proveedor) VALUES
('2024-03-18', 1),
('2024-03-20', 2),
('2024-03-22', 3),
('2024-03-25', 1),
('2024-03-28', 2);

INSERT INTO Ventas (Fecha_Venta, ID_Cliente) VALUES
('2024-03-18', 1),
('2024-03-20', 2),
('2024-03-22', 3),
('2024-03-26', 1),
('2024-03-30', 2);

-- Insertar datos en Compras
INSERT INTO Compras (Fecha_compra, ID_Proveedor) VALUES
('2024-03-01', 1),
('2024-03-02', 2),
('2024-03-05', 3);

-- Insertar datos en Ventas
INSERT INTO Ventas (Fecha_Venta, ID_Cliente) VALUES
('2024-03-10', 1),
('2024-03-12', 2),
('2024-03-15', 3);

-- Insertar datos en Precio_Compras
INSERT INTO Detalle_Compras (ID_Compra, ID_Producto, Cantidad_com, Precio_Com) VALUES
(1, 1, 20, 45.00),
(2, 2, 50, 30.00),
(3, 3, 15, 100.00);

-- Insertar datos en Precio_Ventas
INSERT INTO Detalle_Ventas (ID_Venta, ID_Producto, Cantidad_ven, Precio_Ven) VALUES
(1, 1, 5, 70.00),
(2, 2, 10, 50.00),
(3, 3, 2, 150.00);

-- Ver todos los datos de la tabla Proveedores
SELECT * FROM Proveedores;

-- Ver todos los datos de la tabla Clientes
SELECT * FROM Clientes;

-- Ver todos los datos de la tabla Productos
SELECT * FROM Productos;

-- Ver todos los datos de la tabla Compras
SELECT * FROM Compras;

-- Ver todos los datos de la tabla Ventas
SELECT * FROM Ventas;

-- Ver todos los datos de la tabla Precio_Compras
SELECT * FROM Detalle_Compras;

-- Ver todos los datos de la tabla Precio_Ventas
SELECT * FROM Detalle_Ventas;

 -- Consultas avanzadas 
 
-- Productos con menos de 10 unidades disponibles

SELECT Nombre_P, Cantidad 
FROM Productos 
WHERE Cantidad > 10;


SELECT Co.ID_Compra, Co.Fecha_compra, P.Nombre_Prov, P.Contacto, P.Email
FROM Compras Co
INNER JOIN Proveedores P ON Co.ID_Proveedor = P.ID_Proveedor;

SELECT DC.ID_Compra, C.Fecha_compra, P.Nombre_P, DC.Cantidad_com, DC.Precio_Com
FROM Detalle_Compras DC
INNER JOIN Compras C ON DC.ID_Compra = C.ID_Compra
INNER JOIN Productos P ON DC.ID_Producto = P.ID_Producto;

SELECT DV.ID_Venta, V.Fecha_Venta, P.Nombre_P, DV.Cantidad_ven, DV.Precio_Ven
FROM Detalle_Ventas DV
INNER JOIN Ventas V ON DV.ID_Venta = V.ID_Venta
INNER JOIN Productos P ON DV.ID_Producto = P.ID_Producto;

SELECT V.ID_Venta, V.Fecha_Venta, C.Nombre_cli, C.Apellidos_cli, C.Cedula, C.Telefono
FROM Ventas V
LEFT JOIN Clientes C ON V.ID_Cliente = C.ID_Cliente;


SELECT Co.ID_Compra, Co.Fecha_compra, P.Nombre_Prov, P.Contacto, P.Email
FROM Compras Co
LEFT JOIN Proveedores P ON Co.ID_Proveedor = P.ID_Proveedor;


SELECT DC.ID_Compra, P.Nombre_P, DC.Cantidad_com, DC.Precio_Com
FROM Detalle_Compras DC
LEFT JOIN Productos P ON DC.ID_Producto = P.ID_Producto;

SELECT DV.ID_Venta, P.Nombre_P, DV.Cantidad_ven, DV.Precio_Ven
FROM Detalle_Ventas DV
LEFT JOIN Productos P ON DV.ID_Producto = P.ID_Producto;


-- Vista de Reporte

-- Mayor Stock
CREATE VIEW Productos_Stock AS
SELECT Nombre_P, Cantidad
FROM Productos
WHERE Cantidad > 10;

SELECT * FROM Productos_Stock;

-- Menor Stock
CREATE VIEW Productos_Bajo_Stock AS
SELECT Nombre_P, Cantidad
FROM Productos
WHERE Cantidad <= 10;

SELECT * FROM Productos_Bajo_Stock;

-- Productos mas Vendidos 

CREATE VIEW Productos_Mas_Vendidos AS
SELECT P.Nombre_P, SUM(DV.Cantidad_ven) AS Total_Vendido
FROM Detalle_Ventas DV
JOIN Productos P ON DV.ID_Producto = P.ID_Producto
GROUP BY P.Nombre_P
ORDER BY Total_Vendido DESC;

SELECT * FROM Productos_Mas_Vendidos;


-- Mayor gasto por compra
CREATE VIEW Gastos_Compras AS
SELECT Co.ID_Compra, Co.Fecha_compra, P.Nombre_Prov,
       SUM(DC.Cantidad_com * DC.Precio_Com) AS Total_Compra
FROM Compras Co
JOIN Proveedores P ON Co.ID_Proveedor = P.ID_Proveedor
JOIN Detalle_Compras DC ON Co.ID_Compra = DC.ID_Compra
GROUP BY Co.ID_Compra;

SELECT * FROM Gastos_Compras;

-- Producto Menos Vendido
CREATE VIEW Productos_No_Vendidos AS
SELECT P.ID_Producto, P.Nombre_P, P.Cantidad
FROM Productos P
LEFT JOIN Detalle_Ventas DV ON P.ID_Producto = DV.ID_Producto
WHERE DV.ID_Producto IS NULL
ORDER BY P.Cantidad DESC;

SELECT * FROM Productos_No_Vendidos;

-- Clientes mas Frecuentes 
CREATE VIEW Clientes_Frecuentes AS
SELECT C.ID_Cliente, C.Nombre_cli, C.Apellidos_cli, COUNT(V.ID_Venta) AS Total_Compras
FROM Clientes C
JOIN Ventas V ON C.ID_Cliente = V.ID_Cliente
GROUP BY C.ID_Cliente
ORDER BY Total_Compras DESC;

SELECT * FROM Clientes_Frecuentes;


-- Ventas Por Fecha 
CREATE VIEW Ventas_Por_Fecha AS
SELECT V.Fecha_Venta,
       P.Nombre_P AS Producto,
       SUM(DV.Cantidad_ven) AS Total_Cantidad_Vendida,
       SUM(DV.Cantidad_ven * DV.Precio_Ven) AS Total_Venta
FROM Ventas V
JOIN Detalle_Ventas DV ON V.ID_Venta = DV.ID_Venta
JOIN Productos P ON DV.ID_Producto = P.ID_Producto
GROUP BY V.Fecha_Venta, P.Nombre_P
ORDER BY V.Fecha_Venta ASC, Total_Venta DESC;
	
DROP VIEW Ventas_Por_Fecha;


DELIMITER //
CREATE PROCEDURE RegistrarCompra(
    IN fecha DATE,
    IN id_proveedor INT,
    IN id_producto INT,
    IN cantidad INT,
    IN precio DOUBLE
)BEGIN
    DECLARE nueva_compra_id INT;
    INSERT INTO Compras (Fecha_compra, ID_Proveedor)
    VALUES (fecha, id_proveedor);
    SET nueva_compra_id = LAST_INSERT_ID();
    INSERT INTO Detalle_Compras (ID_Compra, ID_Producto, Cantidad_com, Precio_Com)
    VALUES (nueva_compra_id, id_producto, cantidad, precio);
    UPDATE Productos
    SET Cantidad = Cantidad + cantidad
    WHERE ID_Producto = id_producto;
END //
DELIMITER ;

CALL RegistrarCompra ('2024-04-20', 1, 2, 10, 30.00);


DELIMITER //
CREATE PROCEDURE RegistrarVenta(
    IN fecha DATE,
    IN id_cliente INT,
    IN id_producto INT,
    IN cantidad INT,
    IN precio DOUBLE
)
BEGIN
    DECLARE nueva_venta_id INT;
    INSERT INTO Ventas (Fecha_Venta, ID_Cliente)
    VALUES (fecha, id_cliente);
    SET nueva_venta_id = LAST_INSERT_ID();
    INSERT INTO Detalle_Ventas (ID_Venta, ID_Producto, Cantidad_ven, Precio_Ven)
    VALUES (nueva_venta_id, id_producto, cantidad, precio);
    UPDATE Productos
    SET Cantidad = Cantidad - cantidad
    WHERE ID_Producto = id_producto;
END //
DELIMITER ;

CALL RegistrarVenta(2024-04-22, 2, 3, 5, 150.00);
