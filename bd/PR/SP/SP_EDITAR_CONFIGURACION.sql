CREATE PROCEDURE SP_EDITAR_CONFIGURACION(
	@pi_porcentaje DECIMAL(18,2),
	@pi_duracion INT,
	@pi_mensaje VARCHAR(5000) OUT
) AS
BEGIN
	DECLARE @vn_conteo INT;
	DECLARE @vc_tem_mensaje VARCHAR(5000);

    SET @vc_tem_mensaje = '';

	IF @pi_porcentaje IS NULL BEGIN
		SET @vc_tem_mensaje = 'Porcentaje.';
	END;
	IF @pi_duracion = '' OR @pi_duracion IS NULL BEGIN
		SET @vc_tem_mensaje = CONCAT(@vc_tem_mensaje, 'duracion.');
	END;

	IF @vc_tem_mensaje <> '' BEGIN
		SET @pi_mensaje = CONCAT('Faltan los campos siguientes:', @vc_tem_mensaje);
		RETURN;
	END;

	IF @pi_porcentaje > 1 OR @pi_porcentaje <= 0 BEGIN
		SET @pi_mensaje = 'El porcentaje esta mal ingresado. Tiene que ingresar valores desde 0.01 hasta 0.99';
		RETURN;
	END;

    IF @pi_duracion < 1 BEGIN
		SET @pi_mensaje = 'La duracion en meses no debe ser un valor negativo y no debe ser 0';
		RETURN;
	END;

	BEGIN TRANSACTION
		UPDATE Configuracion
		SET porcentaje_puntos = @pi_porcentaje,
			duracion_puntos = @pi_duracion,
			fecha_configuracion = GETDATE();

		SET @pi_mensaje = 'La configuracion ha sido modificada.';
	COMMIT TRANSACTION;

END;