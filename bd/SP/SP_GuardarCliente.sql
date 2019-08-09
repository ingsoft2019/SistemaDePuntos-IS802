GO 
CREATE PROCEDURE GuardarCliente(@fecha_registro DATE, @id_persona INT)  								
AS 
	DECLARE
	@estado NVARCHAR = 1,
	@puntos_actuales INT = 0,
	@puntos_rifa_actuales INT = 0; 

	BEGIN
	INSERT INTO Cliente(fecha_registro, id_persona, estado, puntos_actuales, puntos_rifa_actuales) 
			VALUES(@fecha_registro, @id_persona, @estado, @puntos_actuales, @puntos_rifa_actuales)
END
GO