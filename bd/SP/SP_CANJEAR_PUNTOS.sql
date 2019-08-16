--Llamado del procedimiento
BEGIN 
DECLARE @pv_mensaje1 VARCHAR(5000);
EXEC SP_CANJEAR_PUNTOS 6, 10,'ADMIN',478 ,@pv_mensaje1 output;
PRINT(CONCAT('Mensaje: ',@pv_mensaje1));
END;
--Inicio del procedimiento
CREATE PROCEDURE SP_CANJEAR_PUNTOS(
	@pi_id_cliente INT,
	@pi_puntos_canjear INT,
	@pi_GEN_USR_id NVARCHAR(50),
	@pi_VEN_FAC_id INT,
	@pv_mensaje VARCHAR(5000) OUT
) AS
BEGIN
	DECLARE @vn_conteo INT, @diferencia_dias INT, @vn_puntos_canjeados INT;
	DECLARE @vc_temp_mensaje VARCHAR(5000);
	DECLARE @vi_puntos_actuales INT;
	DECLARE @vd_costo_total DECIMAL(18,4), @vd_paga_total DECIMAL(18,4), @vd_ganancia DECIMAL(18,4);
	DECLARE @vi_id_tipo_movimiento INT;
	DECLARE @vi_duracion_puntos INT;
	
	SET @vc_temp_mensaje = '';

	SET @vi_id_tipo_movimiento = 2; --Tipo de movimiento: canjear.

	--validacion de campos
	IF @pi_id_cliente = '' OR @pi_id_cliente IS NULL BEGIN
		SET @vc_temp_mensaje = 'id Cliente, ';
	END;
	IF @pi_GEN_USR_id = '' OR @pi_GEN_USR_id IS NULL BEGIN
		SET @vc_temp_mensaje = CONCAT(@vc_temp_mensaje, 'Usuario, ');
	END;
	IF @pi_VEN_FAC_id = '' OR @pi_VEN_FAC_id IS NULL BEGIN
		SET @vc_temp_mensaje = CONCAT(@vc_temp_mensaje , 'Numero de factura ');
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

	SELECT @vn_conteo = COUNT(*) FROM FA.dbo.VEN_FAC
	WHERE @pi_VEN_FAC_id = FA.dbo.VEN_FAC.id;

	IF @vn_conteo = 0 BEGIN
		SET @vc_temp_mensaje = CONCAT (@vc_temp_mensaje,  'La factura no existe. ');
	END;

	--Clientes activos
	SELECT @vn_conteo = COUNT(*) FROM Cliente
	WHERE  id_cliente = @pi_id_cliente  AND estado = 'A';

	IF @vn_conteo = 0 BEGIN
		SET @vc_temp_mensaje = CONCAT (@vc_temp_mensaje, 'El Usuario no esta activo. ');
	END;

	--Canjear puntos solo a facturas con el campo entrega sea NULL.
	SELECT @vn_conteo =  COUNT(*) FROM FA.dbo.VEN_FAC
	WHERE @pi_VEN_FAC_id = FA.dbo.VEN_FAC.id AND FA.dbo.VEN_FAC.entrega IS NULL; 

	IF @diferencia_dias = 0 BEGIN
		SET @vc_temp_mensaje = CONCAT (@vc_temp_mensaje, 'La factura tiene que tener entrega NULL. ') ;
	END;

	--canjear puntos solo a facturas con status C.
	SELECT @vn_conteo =  COUNT(*) FROM FA.dbo.VEN_FAC
	WHERE @pi_VEN_FAC_id = FA.dbo.VEN_FAC.id AND entrega IS NULL AND FA.dbo.VEN_FAC.status = 'C'; 

	IF @diferencia_dias = 0 BEGIN
		SET @vc_temp_mensaje = CONCAT (@vc_temp_mensaje, 'La factura no tiene un status C. ');
	END;

	--canjear puntos solo a facturas del dia.
	SELECT @diferencia_dias = DATEDIFF(DAY, fec_act, GETDATE()) FROM FA.dbo.VEN_FAC
	WHERE @pi_VEN_FAC_id = FA.dbo.VEN_FAC.id OR fec_act IS NULL; 

	IF @diferencia_dias <> 0 BEGIN
		SET @vc_temp_mensaje = CONCAT (@vc_temp_mensaje, 'La factura tiene que ser de la fecha de hoy. ');
	END;

	--Canjear puntos solo una vez por factura
	SELECT @vn_conteo = COUNT(*) FROM Movimiento
	WHERE VEN_FAC_id = @pi_VEN_FAC_id AND id_tipo_movimiento = 2;

	IF @vn_conteo >0 BEGIN
	  	SET @vc_temp_mensaje = CONCAT (@vc_temp_mensaje, 'A esta factura ya se le a canjeado puntos. ');
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

	--Encontrar el pago total y el costo total de la factura a asignar puntos.
	SELECT @vd_paga_total= SUM(paga), @vd_costo_total= SUM(costo) FROM FA.dbo.VEN_PXF
	WHERE @pi_VEN_FAC_id = FA.dbo.VEN_PXF.fac;

	--Paga total debe ser mayor a costo total
	IF @vd_paga_total < @vd_costo_total BEGIN
		SET @vc_temp_mensaje = CONCAT (@vc_temp_mensaje, 'La paga de la factura debe ser mayor al costo de los productos. ');
	END;

	IF @vc_temp_mensaje <> '' BEGIN
		SET @pv_mensaje = CONCAT('No se puede Canjear puntos: ', @vc_temp_mensaje);
		RETURN;
	END;

	--Calculo de ganancia
	SET @vd_ganancia = @vd_paga_total - @vd_costo_total;

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
           ,@vd_costo_total
           ,@vd_paga_total
           ,@vd_ganancia
           ,@pi_puntos_canjear
           ,@vi_id_tipo_movimiento
           ,@pi_GEN_USR_id
           ,@pi_VEN_FAC_id);

	--actualizacion de los puntos actuales y la fecha de vencimiento de puntos.
	UPDATE [dbo].[Cliente]
	SET [puntos_actuales] = @vi_puntos_actuales - @pi_puntos_canjear,
		[fecha_vencimiento_puntos] = DATEADD(month, @vi_duracion_puntos, GETDATE())--Preguntar si se actualiza fecha
	WHERE id_cliente = @pi_id_cliente;

	
	--Obtner los puntos actuales despues del movimiento
	SELECT @vi_puntos_actuales = puntos_actuales FROM Cliente
	WHERE id_cliente = @pi_id_cliente;
	
	SET @pv_mensaje = CONCAT('Los puntos fueron canjeados correctamente. Los puntos canjeados fueron: ', @pi_puntos_canjear, ' Puntos actuales: ', @vi_puntos_actuales);

END;
