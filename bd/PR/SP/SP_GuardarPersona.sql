GO
CREATE PROCEDURE GuardarPersona(@pnombre NVARCHAR(45), @snombre NVARCHAR(45), @papellido NVARCHAR(45),
								@sapellido NVARCHAR(45), @identidad NVARCHAR(45), @correo NVARCHAR(45),
								@sexo NVARCHAR(45),@fecha_nacimiento DATE, @id_zona INT, @detalle_direccion NVARCHAR(255), 
								@telefono1 NVARCHAR(45),@telefono2 NVARCHAR(45),@telefono3 NVARCHAR(45)
								)
AS BEGIN
								
	INSERT INTO Persona VALUES(@pnombre, @snombre, @papellido,@sapellido, @identidad, @correo,
							   @sexo,@fecha_nacimiento, @id_zona, @detalle_direccion, @telefono1, 
							   @telefono2, @telefono3)

END 
GO