/*
AL crear la base de datos nueva asegurence de elegir el 'COLLATION' COMO: SQL_Latin1_General_CP1_CI_AS
SQL_Latin1_General_CP1_CI_AS ---->  Es el cotejamiento que tiene la base de  datos que nos mando Palma. 
*/

--Fue el nombre que yo le puse a la base de datos pero debemos definir un para todos
USE DineroRegis; 

CREATE TABLE Zona (
  id_zona INT NOT NULL IDENTITY(1,1),
  zona NVARCHAR(50) NOT NULL,
  PRIMARY KEY (id_zona)
  );

CREATE TABLE Persona(
  id_persona INT NOT NULL PRIMARY KEY IDENTITY(1,1),
  pnombre NVARCHAR(45) NOT NULL,
  snombre NVARCHAR(45) NULL,
  papellido NVARCHAR(45) NOT NULL,
  sapellido NVARCHAR(45) NULL,
  identidad NVARCHAR(45) NOT NULL,
  correo NVARCHAR(45) NULL,
  sexo NVARCHAR(45) NULL,
  fecha_nacimiento DATE NULL,
  id_zona INT NOT NULL,
  detalle_direccion NVARCHAR(255) NULL,
  telefono1 NVARCHAR(45) NOT NULL,
  telefono2 NVARCHAR(45) NULL,
  telefono3 NVARCHAR(45) NULL,
  CONSTRAINT fk_Persona_Zona FOREIGN KEY (id_zona) REFERENCES Zona (id_zona)
);

CREATE TABLE Cliente (
  id_cliente INT NOT NULL PRIMARY KEY IDENTITY(1,1),
  fecha_registro DATE NOT NULL,
  id_persona INT NOT NULL,
  estado NVARCHAR(1) NOT NULL,
  puntos_actuales INT NULL,
  puntos_rifa_actuales INT NULL,
  fecha_vencimiento_puntos DATE NULL,
  CONSTRAINT fk_Cliente_Persona FOREIGN KEY (id_persona) REFERENCES Persona(id_persona)
);

CREATE TABLE Admin (
  id_admin INT NOT NULL PRIMARY KEY IDENTITY(1,1),
  usuario NVARCHAR(45) NOT NULL,
  contrasena NVARCHAR(45) NOT NULL
); 

CREATE TABLE Tipo_Movimiento (
  id_tipo_movimiento INT NOT NULL PRIMARY KEY IDENTITY(1,1),
  descripcion NVARCHAR(45) NULL
);

CREATE TABLE Movimiento (
  id_movimiento INT NOT NULL PRIMARY KEY IDENTITY(1,1),
  id_cliente INT NOT NULL,
  fecha_movimiento DATE NOT NULL,
  hora_movimiento DATE NOT NULL,
  porcentaje_puntos DECIMAL NULL,
  costo_total DECIMAL NOT NULL,
  paga_total DECIMAL NOT NULL,
  ganancia DECIMAL NOT NULL,
  puntos_asignados INT NOT NULL,
  id_tipo_movimiento INT NOT NULL,
  GEN_USR_id INT NOT NULL,
  VEN_FAC_id INT NOT NULL,
  CONSTRAINT fk_Puntos_x_Factura_Cliente FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente),
  CONSTRAINT fk_Movimiento_Tipo_Movimiento FOREIGN KEY (id_tipo_movimiento) REFERENCES Tipo_Movimiento(id_tipo_movimiento)
 );

CREATE TABLE Rifa (
  id_rifa INT NOT NULL PRIMARY KEY IDENTITY(1,1),
  cantidad_puntos INT NULL,
  estado NVARCHAR(1) NOT NULL,
  id_movimiento INT NULL,
  CONSTRAINT fk_Rifa_Movimiento FOREIGN KEY (id_movimiento) REFERENCES Movimiento (id_movimiento)
);