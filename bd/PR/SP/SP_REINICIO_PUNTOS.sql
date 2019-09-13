CREATE PROCEDURE SP_PROCEDURE(
    @pc_mensaje VARCHAR(2000);
)
AS
begin
    BEGIN TRANSACTION 
    BEGIN TRY
		--Cambiar el estado de las rifas que se utilizaron para el sorteo
		UPDATE Rifa 
		SET estado = 'R'
		WHERE estado <> 'R';

		--Resetear puntos rifa a todos los clientes
		UPDATE Cliente
		SET puntos_rifa_actuales = 0
		WHERE puntos_rifa_actuales <> 0;

        SET @pc_mensaje = 'Los puntos "rifa" fueron reseteados correctamente.';
	COMMIT TRANSACTION
    END TRY
    BEGIN CATCH
    ROLLBACK TRANSACTION
        SET @pc_mensaje = 'Error en el reseteo de puntos.';

    END CATCH
end;