CREATE PROCEDURE SP_ELIMINAR_PARAMETROS(
	@pn_id INT,
	@pc_mensaje NVARCHAR(1000) OUT
)AS
BEGIN
	DECLARE @vn_conteo INT;
	DECLARE @vc_mensaje_tem NVARCHAR(1000);

	IF @pn_id = '' OR @pn_id IS NULL BEGIN
		SET @pc_mensaje='Falta el campo id.';
		RETURN;
	END;

	SELECT @vn_conteo = COUNT(*) FROM Parametro_Impresion
	WHERE id_parametro_impresion = @pn_id;

	IF @vn_conteo = 0 BEGIN
		SET @pc_mensaje= 'No existe registro con el id.';
		RETURN;
	END;

	SELECT @vn_conteo = COUNT(*) FROM Parametro_Impresion
	WHERE id_parametro_impresion = @pn_id AND estado = 'A';

	IF @vn_conteo > 0 BEGIN
		SET @pc_mensaje= 'Para eliminar este parametro debe activar otro parametro';
		RETURN;
	END;
	
	BEGIN TRANSACTION
	BEGIN TRY
		--Editar los parametros
		DELETE FROM Parametro_Impresion
		WHERE id_parametro_impresion = @pn_id;

		SET @pc_mensaje = 'Se eliminaron los parametros.';
	COMMIT TRANSACTION

	END TRY
    BEGIN CATCH
		SET @pc_mensaje = 'Error en la eliminacion de parametros.';
	END CATCH

END;