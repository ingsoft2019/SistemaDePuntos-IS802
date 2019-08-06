--Llamado del procedimiento
BEGIN 
DECLARE @pv_mensaje1 VARCHAR(5000);
DECLARE @pi_codigo1 INT;
EXEC SP_ASIGNAR_PUNTOS 2,0.2,1,'JRODAS',71 ,@pv_mensaje1 output, @pi_codigo1 output;
PRINT(CONCAT('Mensaje: ',@pv_mensaje1, ', Codigo: ' ,@pi_codigo1));
END;


-- Inicio de Procedimiento
CREATE PROCEDURE SP_ASIGNAR_PUNTOS (
	@pi_id_cliente INT,
	@pd_porcentaje_puntos DECIMAL(18,4),
	@pi_id_tipo_movimiento INT,
	@pi_GEN_USR_id NVARCHAR(50),
	@pi_VEN_FAC_id INT,
	@pv_mensaje VARCHAR(5000) OUT,
	@pi_codigo INT OUT
) AS

BEGIN
	DECLARE @vn_conteo INT, @diferencia_dias INT, @vn_puntos_asignados INT;
	DECLARE @vc_temp_mensaje VARCHAR(5000);
	DECLARE @vd_ganancia DECIMAL(18,4), @vd_paga_total DECIMAL(18,4), @vd_costo_total DECIMAL(18,4);
	DECLARE @pi_puntos_actuales INT;
	SET @vc_temp_mensaje = '';

	--validacion de campos
	IF @pi_id_cliente = '' OR @pi_id_cliente IS NULL BEGIN
		SET @vc_temp_mensaje = 'id Cliente, ';
	END;
	IF @pd_porcentaje_puntos IS NULL BEGIN
		SET @vc_temp_mensaje = CONCAT( @vc_temp_mensaje , 'Porcentaje puntos, ');
	END;
	
	IF @pi_id_tipo_movimiento = '' OR @pi_id_tipo_movimiento IS NULL BEGIN
		SET @vc_temp_mensaje = CONCAT(@vc_temp_mensaje, 'Id Tipo Movimiento, ');
	END;
	IF @pi_GEN_USR_id = '' OR @pi_GEN_USR_id IS NULL BEGIN
		SET @vc_temp_mensaje = CONCAT(@vc_temp_mensaje, 'Usuario, ');
	END;
	IF @pi_VEN_FAC_id = '' OR @pi_VEN_FAC_id IS NULL BEGIN
		SET @vc_temp_mensaje = CONCAT(@vc_temp_mensaje , 'Numero de factura ');
	END;
	IF @vc_temp_mensaje <> '' BEGIN
		SET @pv_mensaje = CONCAT('Faltan campos pendientes: ', @vc_temp_mensaje);
		SET @pi_codigo = 1;
	END;

	--verificacion de datos
	SELECT @vn_conteo = COUNT(*) FROM dbo.Cliente
	WHERE id_cliente = @pi_id_cliente;

	IF @vn_conteo = 0 BEGIN
		SET @pv_mensaje = 'El cliente no existe.';
		SET @pi_codigo = 1;
		RETURN;
	END;
	
	SELECT @vn_conteo = COUNT(*) FROM Tipo_Movimiento
	WHERE @pi_id_tipo_movimiento = id_tipo_movimiento;
	
	IF @vn_conteo = 0 BEGIN
		SET @pv_mensaje = 'El Tipo de Movimiento no existe.';
		SET @pi_codigo = 1;
		RETURN;
	END;

	SELECT @vn_conteo = COUNT(*) FROM FA.dbo.GEN_USR
	WHERE @pi_GEN_USR_id = FA.dbo.GEN_USR.id;

	IF @vn_conteo = 0 BEGIN
		SET @pv_mensaje = 'El Usuario no existe.';
		SET @pi_codigo = 1;
		RETURN;
	END;

	SELECT @vn_conteo = COUNT(*) FROM FA.dbo.VEN_FAC
	WHERE @pi_VEN_FAC_id = FA.dbo.VEN_FAC.id;

	IF @vn_conteo = 0 BEGIN
		SET @pv_mensaje = 'La factura no existe.';
		SET @pi_codigo = 1;
		RETURN;
	END;

	--Asignar puntos solo a facturas del dia.
	SELECT @diferencia_dias = DATEDIFF(DAY, fec_act, GETDATE()) FROM FA.dbo.VEN_FAC
	WHERE @pi_VEN_FAC_id = FA.dbo.VEN_FAC.id; 

	IF @diferencia_dias <> 0 BEGIN
		SET @pv_mensaje = 'La factura tiene que ser de la fecha de hoy';
		SET @pi_codigo = 1;
		RETURN;
	END;

	--Asignar puntos solo una vez por factura
	SELECT @vn_conteo = COUNT(*) FROM Movimiento
	WHERE VEN_FAC_id = @pi_VEN_FAC_id;

	IF @vn_conteo >0 BEGIN
	  	SET @pv_mensaje = 'A esta factura ya se le asigno puntos';
		SET @pi_codigo = 1;
		RETURN;
	
	END;

	--Encontrar el pago total y el costo total de la factura a asignar puntos.
	SELECT @vd_paga_total= SUM(paga), @vd_costo_total= SUM(costo) FROM FA.dbo.VEN_PXF
	WHERE @pi_VEN_FAC_id = FA.dbo.VEN_PXF.fac;

	--Paga total debe ser mayor a costo total
	IF @vd_paga_total < @vd_costo_total BEGIN
		SET @pv_mensaje = 'La paga de la factura debe ser mayor al costo de los productos.';
		SET @pi_codigo = 1;
		RETURN;
	END;

	--Calculo de ganancia
	SET @vd_ganancia = @vd_paga_total - @vd_costo_total;

	--Calculo de puntos
	SET @vn_puntos_asignados = @vd_ganancia * @pd_porcentaje_puntos;

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
           ,@pd_porcentaje_puntos
           ,@vd_costo_total
           ,@vd_paga_total
           ,@vd_ganancia
           ,FLOOR(@vn_puntos_asignados)
           ,@pi_id_tipo_movimiento
           ,@pi_GEN_USR_id
           ,@pi_VEN_FAC_id);

	SELECT @pi_puntos_actuales = puntos_actuales FROM Cliente
	WHERE id_cliente = @pi_id_cliente;

	UPDATE [dbo].[Cliente]
	SET [puntos_actuales] = FLOOR(@vn_puntos_asignados)+ @pi_puntos_actuales
	WHERE id_cliente = @pi_id_cliente;
	
	SET @pv_mensaje = 'Los puntos fueron asignados correctamente';
	SET @pi_codigo = 0;


END;
