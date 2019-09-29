CREATE PROCEDURE SP_EDITAR_PARAMETROS(
	@pn_id INT,
	@pn_anchura INT,
	@pn_altura INT,
	@pc_mensaje NVARCHAR(1000) OUT
)AS
BEGIN
	DECLARE @vn_conteo INT;
	DECLARE @vc_mensaje_tem NVARCHAR(1000);

	IF @pn_altura = '' OR @pn_altura IS NULL BEGIN
		SET @vc_mensaje_tem= 'Altura';
	END;
	IF @pn_anchura = '' OR @pn_anchura IS NULL BEGIN
		SET @vc_mensaje_tem= CONCAT(@vc_mensaje_tem, ' Anchura');
	END;
	IF @pn_id = '' OR @pn_id IS NULL BEGIN
		SET @vc_mensaje_tem= CONCAT(@vc_mensaje_tem, ' id');
	END;
	IF @vc_mensaje_tem<>'' BEGIN
		SET @pc_mensaje = CONCAT('Faltan los siguientes campos: ', @vc_mensaje_tem);
		RETURN;
	END;

	SELECT @vn_conteo = COUNT(*) FROM Parametro_Impresion
	WHERE id_parametro_impresion = @pn_id;

	IF @vn_conteo = 0 BEGIN
		SET @pc_mensaje= 'No existe el id.';
		RETURN;
	END;

	IF @pn_altura <0 BEGIN
		SET @pc_mensaje= 'La altura debe ser mayor a cero.';
		RETURN;
	END;
	IF @pn_anchura <0 BEGIN
		SET @pc_mensaje= 'La anchura debe ser mayor a cero.';
		RETURN;
	END;

	BEGIN TRANSACTION
	BEGIN TRY
		--Editar los parametros
		UPDATE Parametro_Impresion 
		SET altura = @pn_altura,
			anchura = @pn_anchura
		WHERE id_parametro_impresion = @pn_id;

		SET @pc_mensaje = 'Se editaron los parametros.';
	COMMIT TRANSACTION

	END TRY
    BEGIN CATCH
		SET @pc_mensaje = 'Error en la edicion de parametros.';
	END CATCH

END;