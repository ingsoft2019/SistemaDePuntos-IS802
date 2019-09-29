CREATE PROCEDURE SP_AGREGAR_PARAMETROS(
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
	IF @vc_mensaje_tem<>'' BEGIN
		SET @pc_mensaje = CONCAT('Faltan los siguientes campos: ', @vc_mensaje_tem);
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

	SELECT @vn_conteo = COUNT(*) FROM Parametro_Impresion

	IF @vn_conteo = 0 BEGIN
		BEGIN TRANSACTION
		BEGIN TRY
			--Insertar parametros por primera vez
			INSERT INTO Parametro_Impresion VALUES(@pn_altura ,@pn_anchura, 'A'); --Se agrega con el estado activo
			SET @pc_mensaje = 'Se Agregaron los parametros correctamente.';
		COMMIT TRANSACTION
		END TRY
		BEGIN CATCH
			SET @pc_mensaje = 'No se pudo agregar los parametros.';
		END CATCH
	END;
	IF @vn_conteo > 0 BEGIN
		BEGIN TRANSACTION
		BEGIN TRY
			--Insertar nuevos parametros
			INSERT INTO Parametro_Impresion VALUES(@pn_altura, @pn_anchura, 'I'); --Se agrega con el estado activo			

			SET @pc_mensaje = 'Se Agregaron los parametros correctamente.';
		COMMIT TRANSACTION
		END TRY
		BEGIN CATCH
			SET @pc_mensaje = 'No se pudo agregar los parametros.';
		END CATCH
	END;

END;