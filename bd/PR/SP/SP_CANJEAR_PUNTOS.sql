CREATE PROCEDURE [dbo].[SP_CANJEAR_PUNTOS](
	@pi_id_cliente INT,
	@pi_puntos_canjear INT,
	@pi_GEN_USR_id NVARCHAR(50),
	@pv_mensaje VARCHAR(5000) OUT
) AS
BEGIN
	DECLARE @vn_conteo INT, @diferencia_dias INT, @vn_puntos_canjeados INT;
	DECLARE @vc_temp_mensaje VARCHAR(5000);
	DECLARE @vi_puntos_actuales INT;
	DECLARE @vi_id_tipo_movimiento INT;
	DECLARE @vi_duracion_puntos INT;
	DECLARE @vd_fecha_vencimiento DATE;
	
	SET @vc_temp_mensaje = '';

	SET @vi_id_tipo_movimiento = 2; --Tipo de movimiento: canjear.

	--validacion de campos
	IF @pi_id_cliente = '' OR @pi_id_cliente IS NULL BEGIN
		SET @vc_temp_mensaje = 'id Cliente, ';
	END;
	IF @pi_GEN_USR_id = '' OR @pi_GEN_USR_id IS NULL BEGIN
		SET @vc_temp_mensaje = CONCAT(@vc_temp_mensaje, 'Usuario, ');
	END;
	IF @vc_temp_mensaje <> '' BEGIN
		SET @pv_mensaje = CONCAT('Faltan campos pendientes: ', @vc_temp_mensaje);
		RETURN;
	END;

	--verificacion de parametros
	SELECT @vn_conteo = COUNT(*) FROM dbo.Cliente
	WHERE id_cliente = @pi_id_cliente;

	IF @vn_conteo = 0 BEGIN
		SET  @vc_temp_mensaje = 'El cliente no existe. ';		
	END;
	
	SELECT @vn_conteo = COUNT(*) FROM FA.dbo.GEN_USR
	WHERE @pi_GEN_USR_id = FA.dbo.GEN_USR.id;

	IF @vn_conteo = 0 BEGIN
		SET @vc_temp_mensaje = CONCAT (@vc_temp_mensaje, 'El Usuario no existe. ');
	END;

	--Clientes activos
	SELECT @vn_conteo = COUNT(*) FROM Cliente
	WHERE  id_cliente = @pi_id_cliente  AND estado = 'A';

	IF @vn_conteo = 0 BEGIN
		SET @vc_temp_mensaje = CONCAT (@vc_temp_mensaje, 'El Usuario no esta activo. ');
	END;

	--Verificar si hay datos en la tabla Configuracion
	SELECT @vn_conteo = COUNT(*) FROM Configuracion;

	IF @vn_conteo <> 1 BEGIN
		SET @vc_temp_mensaje = CONCAT (@vc_temp_mensaje, 'No hay datos en la tabla configuracion. ');
	END;

	--Los puntos deben ser menor o igual a los puntos actuales
	SELECT @vi_puntos_actuales = puntos_actuales FROM Cliente
	WHERE id_cliente = @pi_id_cliente;

	IF @pi_puntos_canjear > @vi_puntos_actuales BEGIN
		SET @vc_temp_mensaje = CONCAT (@vc_temp_mensaje, 'Los puntos que desea canjear son mayores a los acumulados. ');
	END;

	--Verificar la fecha de vencimiento de puntos actuales del cliente
	SELECT @vd_fecha_vencimiento = fecha_vencimiento_puntos FROM Cliente
	WHERE id_cliente = @pi_id_cliente;

	IF GETDATE() >= @vd_fecha_vencimiento  BEGIN
		SET @vc_temp_mensaje = CONCAT (@vc_temp_mensaje, 'Los puntos actuales estan vencidos. ');
	END;

	IF @vc_temp_mensaje <> '' BEGIN
		SET @pv_mensaje = CONCAT('No se puede Canjear puntos: ', @vc_temp_mensaje);
		RETURN;
	END;

	BEGIN TRANSACTION

		INSERT INTO [dbo].[Movimiento]
				([id_cliente]
				,[fecha_movimiento]
				,[hora_movimiento]
				,[porcentaje_puntos]
				,[costo_total]
				,[paga_total]
				,[ganancia]
				,[puntos_asignados]
				,[id_tipo_movimiento]
				,[GEN_USR_id]
				,[VEN_FAC_id])
		VALUES
				(@pi_id_cliente
				,GETDATE()
				,SYSDATETIME()
				,null
				,null
				,null
				,null
				,@pi_puntos_canjear
				,@vi_id_tipo_movimiento
				,@pi_GEN_USR_id
				,null);
		
		--Encontrar porcentaje de puntos y duracion de puntos
		SELECT @vi_duracion_puntos = duracion_puntos FROM Configuracion;

		--actualizacion de los puntos actuales y la fecha de vencimiento de puntos.
		UPDATE [dbo].[Cliente]
		SET [puntos_actuales] = @vi_puntos_actuales - @pi_puntos_canjear,
			[fecha_vencimiento_puntos] = DATEADD(month, @vi_duracion_puntos, GETDATE())--Preguntar si se actualiza fecha
		WHERE id_cliente = @pi_id_cliente;
	
		--Obtner los puntos actuales despues del movimiento
		SELECT @vi_puntos_actuales = puntos_actuales FROM Cliente
		WHERE id_cliente = @pi_id_cliente;

	COMMIT TRANSACTION

	SET @pv_mensaje = CONCAT('Los puntos fueron canjeados correctamente. Los puntos canjeados fueron: ', @pi_puntos_canjear, ' Puntos actuales: ', @vi_puntos_actuales);

END;
