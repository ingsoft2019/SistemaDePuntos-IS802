--Llamado del procedimiento
BEGIN 
	DECLARE @vc_respuesta VARCHAR(500);
	EXEC SP_SORTEO @vc_respuesta output;
	PRINT CONCAT('Respuesta: ',@vc_respuesta);
END;

--Incio del procedimiento
CREATE PROCEDURE SP_SORTEO(
	@pc_ganador VARCHAR(300) OUT
)
AS
BEGIN
	-- Declaracion de variables para el cursor
	DECLARE @vd_id INT, @vn_puntos_rifa INT, @vc_pnombre VARCHAR(45), @vn_conteo INT
	DECLARE @vn_id_cliente INT
	DECLARE @vc_ganador VARCHAR(200)
	--Verificacion de participantes
	SELECT @vn_conteo = COUNT(*) FROM Cliente 
	WHERE puntos_rifa_actuales <> 0

	IF @vn_conteo = 0 BEGIN
		SET @pc_ganador = 'No hay participantes'
		RETURN
	END;

	-- Declaración del cursor
	DECLARE c_persona CURSOR FOR (SELECT c.id_cliente, concat(p.pnombre, ' ' ,p.snombre, ' ' , p.papellido, ' ', p.sapellido) nombre, c.puntos_rifa_actuales FROM Cliente c
								  INNER JOIN Persona p ON p.id_persona = c.id_persona
								  WHERE c.puntos_rifa_actuales <> 0)
	--tabla para almacenar todos los participantes. (Se guardara cada cliente la cantidad de puntos de rifa acumulados)
	DECLARE @tbl_sorteo TABLE (id_cliente int, nombre varchar(200))
	
	-- Apertura del cursor
	OPEN c_persona
	FETCH c_persona INTO @vd_id, @vc_pnombre, @vn_puntos_rifa
	WHILE (@@FETCH_STATUS = 0 )	BEGIN
		--Insertar todos los registros a la tabla temporal
		WHILE (@vn_puntos_rifa>0) BEGIN
			INSERT INTO @tbl_sorteo VALUES (@vd_id, @vc_pnombre)
			SET @vn_puntos_rifa = @vn_puntos_rifa - 1
		END
		-- Lectura de la siguiente fila del cursor
		FETCH c_persona INTO @vd_id, @vc_pnombre, @vn_puntos_rifa
	END 
	-- Cierre del cursor
	CLOSE c_persona

	-- Liberar los recursos
	DEALLOCATE c_persona

	--Seleccionar al ganador
	SELECT TOP 1 @vn_id_cliente = id_cliente, @vc_ganador = nombre FROM (SELECT * FROM @tbl_sorteo) t1
	ORDER BY NEWID()

	BEGIN TRANSACTION 
		--Cambiar el estado de las rifas que se utilizaron para el sorteo
		UPDATE Rifa 
		SET estado = 'R'
		WHERE estado <> 'R'

		--Resetear puntos rifa a todos los clientes
		UPDATE Cliente
		SET puntos_rifa_actuales = 0
		WHERE puntos_rifa_actuales <> 0
	COMMIT TRANSACTION

	SET @pc_ganador = ('El ganador es: ' + @vc_ganador)
END;