CREATE PROCEDURE SP_habilitarZona(
@id_zona int)
AS
BEGIN
	UPDATE Zona SET estado = 'A' WHERE Zona.id_zona = @id_zona; 
END