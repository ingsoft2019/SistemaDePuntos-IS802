create procedure SP_actualizarCliente(
	@pnombre nvarchar(45),
	@snombre nvarchar(45),
	@papellido nvarchar(45),
	@sapellido nvarchar(45),
	@identidad nvarchar(45),
	@correoElectronico nvarchar(45),
	@sexo nvarchar(45),
	@fechanacimiento date,
	@telefono1 nvarchar(45),
	@telefono2 nvarchar(45),
	@telefono3 nvarchar(45),
	@zona int,
	@direccion nvarchar(255),
	@puntosactuales int,
	@fechavencimiento date,
	@puntosrifa int
	)
	as
	begin
		declare @identificar int = 0;
		declare @identificar2 int = 0;
		
		begin
			select @identificar = Persona.id_persona from Persona inner join cliente on 
			Cliente.id_persona = Persona.id_persona
			where Persona.identidad = @identidad;

			select @identificar2 = Zona.id_zona from Persona inner join Zona
			on Zona.id_zona = Persona.id_zona
			where Persona.identidad = @identidad;

			update Persona set pNombre = @pnombre,sNombre=@snombre,pApellido=@papellido,
			sApellido = @sapellido,identidad = @identidad,correo = @correoElectronico,sexo = @sexo,
			fecha_nacimiento = @fechanacimiento,id_zona = @zona, detalle_direccion = @direccion, telefono1 = @telefono1,
			telefono2 = @telefono2, telefono3 = @telefono3
			where Persona.identidad = @identidad;
			update Cliente set puntos_actuales = @puntosactuales, puntos_rifa_actuales = @puntosrifa,
			fecha_vencimiento_puntos = @fechavencimiento
			where Cliente.id_persona = @identificar;
		end;
	end;