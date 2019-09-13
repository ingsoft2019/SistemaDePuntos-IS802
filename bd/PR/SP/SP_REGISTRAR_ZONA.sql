CREATE PROCEDURE SP_REGISTRAR_ZONA( @zona NVARCHAR(255))
	AS
	BEGIN
		DECLARE @conteo int;
		SET @conteo = 0;
		DECLARE @estado VARCHAR(1);
		SET  @estado = 'A';
		
		IF(@zona = '' OR @zona IS NULL)
		BEGIN
			RETURN;
		END;

		SELECT @conteo = COUNT(*) from Zona where Zona.zona = @zona;
		IF(@conteo=0)
		BEGIN
			INSERT INTO Zona(zona, estado)VALUES(@zona, @estado);
		END;
		ELSE
		BEGIN
			RETURN;
		END;
	END;