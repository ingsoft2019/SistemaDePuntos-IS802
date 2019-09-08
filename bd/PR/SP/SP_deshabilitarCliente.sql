create procedure SP_deshabilitarCliente(
@identidad nvarchar(45))
as
begin
	declare @idcliente int = 0;

	select @idcliente = Cliente.id_cliente from Persona inner join 
	Cliente on Cliente.id_persona = Persona.id_persona
	where Persona.identidad = @identidad;

	update Cliente set estado = 'I'
	where Cliente.id_cliente = @idcliente; 
end 