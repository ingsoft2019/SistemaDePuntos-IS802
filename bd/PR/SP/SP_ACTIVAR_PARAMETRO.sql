CREATE PROCEDURE SP_ACTIVAR_PARAMETRO(
	@pn_id INT,
	@pc_mensaje NVARCHAR(1000) OUT
)AS
BEGIN
	DECLARE @vn_conteo INT;
	IF @pn_id = '' OR @pn_id IS NULL BEGIN
		SET @pc_mensaje = 'Falta campo id';
	END;
	BEGIN TRANSACTION
	BEGIN TRY
		UPDATE Parametro_Impresion
		SET estado = 'I'
		WHERE estado = 'A'

		UPDATE Parametro_Impresion
		SET estado = 'A'
		WHERE id_parametro_impresion = @pn_id;
		SET @pc_mensaje = 'Se activo el parametro correctamente.'
	COMMIT TRANSACTION
	END TRY
	BEGIN CATCH
		SET @pc_mensaje = 'Error al activar el parametro.'
	END CATCH
END;