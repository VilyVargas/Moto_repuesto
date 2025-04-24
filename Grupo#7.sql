CREATE DATABASE Moto_Repuesto;

USE Moto_Repuesto;

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

CREATE TABLE Ventas (
ID_Venta INT AUTO_INCREMENT PRIMARY KEY,
Fecha_Venta DATE NOT NULL,
ID_Cliente INT,
FOREIGN KEY (ID_Cliente) REFERENCES Clientes (ID_Cliente)
);

CREATE TABLE Compras (
ID_Compra INT AUTO_INCREMENT PRIMARY KEY,
Fecha_compra DATE NOT NULL,
ID_Proveedor INT,
FOREIGN KEY (ID_Proveedor) REFERENCES Proveedores (ID_Proveedor)
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

