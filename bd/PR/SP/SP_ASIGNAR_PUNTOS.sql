-- Inicio de Procedimiento
CREATE PROCEDURE SP_ASIGNAR_PUNTOS (
	@pi_id_cliente INT,
	@pi_GEN_USR_id NVARCHAR(50),
	@pi_VEN_FAC_id INT,
	@pv_mensaje VARCHAR(5000) OUT,
	@pi_codigo INT OUT,
	@pi_puntos_actuales INT OUT,
	@pi_puntos_anteriores INT OUT,
	@pi_puntos_asignados INT OUT,
	@pi_cliente NVARCHAR(1000) OUT
) AS

BEGIN
	DECLARE @vn_conteo INT, @diferencia_dias INT, @vn_puntos_asignados INT;
	DECLARE @vc_temp_mensaje VARCHAR(5000);
	DECLARE @vd_ganancia DECIMAL(18,4), @vd_paga_total DECIMAL(18,4), @vd_costo_total DECIMAL(18,4);
	DECLARE @vi_puntos_actuales INT;
	DECLARE @vi_id_tipo_movimiento INT;
	DECLARE @vi_duracion_puntos INT;
	DECLARE @vd_porcentaje_puntos DECIMAL(5,4);
	DECLARE @vn_id_movimiento INT, @vi_puntos_actuales_rifa INT, @vn_cliente VARCHAR(100);
	
	SET @vc_temp_mensaje = '';

	SET @vi_id_tipo_movimiento = 1; --Tipo de movimiento: asignar.

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
		SET @pi_codigo = 1;
		SET @pi_puntos_actuales= 0;
		SET @pi_puntos_anteriores= 0;
		SET @pi_puntos_asignados= 0;
		SET @pi_cliente = '';
	END;

	--verificacion de datos
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

	--Asignar puntos solo a facturas con el campo entrega sea NULL.
	SELECT @vn_conteo =  COUNT(*) FROM FA.dbo.VEN_FAC
	WHERE @pi_VEN_FAC_id = FA.dbo.VEN_FAC.id AND FA.dbo.VEN_FAC.entrega IS NULL; 

	IF @diferencia_dias = 0 BEGIN
		SET @vc_temp_mensaje = CONCAT (@vc_temp_mensaje, 'La factura tiene que tener entrega NULL. ') ;
	END;

	--	--Asignar puntos solo a facturas con status C.
	SELECT @vn_conteo =  COUNT(*) FROM FA.dbo.VEN_FAC
	WHERE @pi_VEN_FAC_id = FA.dbo.VEN_FAC.id AND entrega IS NULL AND FA.dbo.VEN_FAC.status = 'C'; 

	IF @diferencia_dias = 0 BEGIN
		SET @vc_temp_mensaje = CONCAT (@vc_temp_mensaje, 'La factura no tiene un status C. ');
	END;

	--Asignar puntos solo a facturas del dia.
	SELECT @diferencia_dias = DATEDIFF(DAY, fec_act, GETDATE()) FROM FA.dbo.VEN_FAC
	WHERE @pi_VEN_FAC_id = FA.dbo.VEN_FAC.id; 

	IF @diferencia_dias <> 0 BEGIN
		SET @vc_temp_mensaje = CONCAT (@vc_temp_mensaje, 'La factura tiene que ser de la fecha de hoy. ');
	END;

	--Verificar que la fecha fec_act no sea null
	SELECT @vn_conteo = COUNT(*) FROM FA.dbo.VEN_FAC
	WHERE @pi_VEN_FAC_id = FA.dbo.VEN_FAC.id AND fec_act IS NULL; 

	IF @vn_conteo <> 0 BEGIN
		SET @vc_temp_mensaje = CONCAT (@vc_temp_mensaje, 'La factura tiene fecha null. ');
	END;

	--Asignar puntos solo una vez por factura
	SELECT @vn_conteo = COUNT(*) FROM Movimiento
	WHERE VEN_FAC_id = @pi_VEN_FAC_id;

	IF @vn_conteo >0 BEGIN
	  	SET @vc_temp_mensaje = CONCAT (@vc_temp_mensaje, 'A esta factura ya se le asigno puntos. ');
	END;

	--Verificar si hay datos en la tabla Configuracion
	SELECT @vn_conteo = COUNT(*) FROM Configuracion;

	IF @vn_conteo <> 1 BEGIN
		SET @vc_temp_mensaje = CONCAT (@vc_temp_mensaje, 'No hay datos en la tabla configuracion. ');
	END;

	--Encontrar el pago total y el costo total de la factura a asignar puntos.
	SELECT @vd_paga_total= SUM(paga), @vd_costo_total= SUM(costo) FROM FA.dbo.VEN_PXF
	WHERE @pi_VEN_FAC_id = FA.dbo.VEN_PXF.fac;

	--Paga total debe ser mayor a costo total
	IF @vd_paga_total < @vd_costo_total BEGIN
		SET @vc_temp_mensaje = CONCAT (@vc_temp_mensaje, 'La paga de la factura debe ser mayor al costo de los productos. ');
	END;

	IF @vc_temp_mensaje <> '' BEGIN
		SET @pv_mensaje = CONCAT('No se puede agregar puntos: ', @vc_temp_mensaje);
		SET @pi_codigo = 1;
		SET @pi_puntos_actuales= 0;
		SET @pi_puntos_anteriores= 0;
		SET @pi_puntos_asignados= 0;
		SET @pi_cliente = '';
		RETURN;
	END;

	BEGIN TRANSACTION

		--Encontrar porcentaje de puntos y duracion de puntos
		SELECT @vd_porcentaje_puntos = porcentaje_puntos, @vi_duracion_puntos = duracion_puntos FROM Configuracion;

		--Calculo de ganancia
		SET @vd_ganancia = @vd_paga_total - @vd_costo_total;

		--Calculo de puntos
		SET @vn_puntos_asignados = @vd_ganancia * @vd_porcentaje_puntos;

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
			,@vd_porcentaje_puntos
			,@vd_costo_total
			,@vd_paga_total
			,@vd_ganancia
			,FLOOR(@vn_puntos_asignados)
			,@vi_id_tipo_movimiento
			,@pi_GEN_USR_id
			,@pi_VEN_FAC_id);

		--Obtener el nombre del cliente
		SELECT @vn_cliente = CONCAT(p.pnombre,' ', p.snombre, ' ', p.papellido, ' ',p.sapellido)  FROM Cliente c 
		INNER JOIN Persona p  ON p.id_persona = c.id_persona
		WHERE c.id_cliente = @pi_id_cliente

		--obtener los puntos que tiene y los puntos actuales de rifa, antes de asignara los nuevos puntos
		SELECT @vi_puntos_actuales = puntos_actuales, @vi_puntos_actuales_rifa = puntos_rifa_actuales FROM Cliente
		WHERE id_cliente = @pi_id_cliente;

		--Obtener el ultimo id de movimiento
		SELECT @vn_id_movimiento = MAX(id_movimiento) FROM Movimiento
		IF @vn_id_movimiento IS NULL BEGIN
			SET @vn_id_movimiento = 1;
		END;

		--Insertar puntos en la tabla rifa
		INSERT INTO Rifa (cantidad_puntos, estado, id_movimiento)
		VALUES (FLOOR(@vn_puntos_asignados), 'S', @vn_id_movimiento);

		--actualizacion de los puntos actuales y la fecha de vencimiento de puntos.
		UPDATE [dbo].[Cliente]
		SET [puntos_actuales] = FLOOR(@vn_puntos_asignados)+ @vi_puntos_actuales,
			[puntos_rifa_actuales] = FLOOR(@vn_puntos_asignados) + @vi_puntos_actuales_rifa,
			[fecha_vencimiento_puntos] = DATEADD(month, @vi_duracion_puntos, GETDATE())
		WHERE id_cliente = @pi_id_cliente;

		SET @pv_mensaje = CONCAT('Los puntos fueron asignados correctamente. Los puntos asignados fueron: ',FLOOR(@vn_puntos_asignados) ,'. Puntos actuales: ', FLOOR(@vn_puntos_asignados)+ @vi_puntos_actuales);
		SET @pi_codigo = 0;
		SET @pi_puntos_actuales= FLOOR(@vn_puntos_asignados)+ @vi_puntos_actuales;
		SET @pi_puntos_anteriores= @vi_puntos_actuales - FLOOR(@vn_puntos_asignados);
		SET @pi_puntos_asignados= FLOOR(@vn_puntos_asignados);
		SET @pi_cliente = @vn_cliente;

		IF @pi_puntos_anteriores<0 begin
		  SET @pi_puntos_anteriores = 0;
		end;

	COMMIT TRANSACTION


END;
