create procedure SP_deshabilitarCliente(
@identidad int)
as
begin
	update Cliente set estado = 'I'
	where Cliente.id_persona = @identidad; 
end 