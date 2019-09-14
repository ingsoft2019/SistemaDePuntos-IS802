create procedure SP_habilitarCliente(
@identidad int)
as
begin
	update Cliente set estado = 'A'
	where Cliente.id_persona = @identidad; 
end 