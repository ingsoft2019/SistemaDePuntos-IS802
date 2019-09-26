USE [PR]
GO
/****** Object:  StoredProcedure [dbo].[SP_actualizarNombreZona]    Script Date: 23/09/2019 10:51:23 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- Batch submitted through debugger: SQLQuery2.sql|0|0|C:\Users\bayro\AppData\Local\Temp\~vsF7FA.sql

ALTER PROCEDURE [dbo].[SP_actualizarNombreZona](@idZona int, @zona NVARCHAR(255))
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