CREATE PROCEDURE SP_VENCIMIENTO_PUNTOS(
	@pc_mensaje VARCHAR(2000) OUTPUT
)
AS
BEGIN
	DECLARE @vn_conteo INT;
	--Verificar si hay clientes con los puntos vencidos
	SELECT @vn_conteo = COUNT(*) FROM Cliente
	WHERE fecha_vencimiento_puntos <= GETDATE();

	IF @vn_conteo = 0 BEGIN
		SET @pc_mensaje = 'No hay clientes con puntos vencidos.';
		RETURN;
	END;

	BEGIN TRANSACTION
	BEGIN TRY
		--Cambiar los puntos actuales a cero
		UPDATE Cliente 
		SET puntos_actuales = 0,
			fecha_vencimiento_puntos = NULL
		WHERE id_cliente IN (SELECT id_cliente FROM Cliente
							 WHERE fecha_vencimiento_puntos <= GETDATE());
		SET @pc_mensaje = 'Se eliminaron los puntos vencidos.';
	COMMIT TRANSACTION

	END TRY
    BEGIN CATCH
		SET @pc_mensaje = 'Error en la eliminacion de puntos vencidos.';
	END CATCH

END;
