GO 
CREATE PROCEDURE GuardarCliente(@fecha_registro DATE, @id_persona INT)  								
AS 
	DECLARE
	@estado NVARCHAR = 1;
	BEGIN
	INSERT INTO Cliente(fecha_registro, id_persona, estado) VALUES(@fecha_registro, @id_persona, @estado)
END
GO