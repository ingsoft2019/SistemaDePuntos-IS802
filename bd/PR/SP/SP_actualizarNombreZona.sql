CREATE PROCEDURE [dbo].[SP_actualizarNombreZona](@idZona int, @zona NVARCHAR(255))
	AS
	BEGIN
		DECLARE @conteo int;
		SET @conteo = 0;
		
		IF(@zona = '' OR @zona IS NULL OR @idZona = '' OR @idZona IS NULL)
		BEGIN
			RETURN;
		END;
		
		SELECT @conteo = COUNT(*) from Zona where Zona.zona = @zona;
		
		IF(@conteo=0)
			BEGIN
				UPDATE Zona SET zona = @zona WHERE Zona.id_zona = @idZona
			END;
		ELSE
			BEGIN
				RETURN;
			END;
	END;