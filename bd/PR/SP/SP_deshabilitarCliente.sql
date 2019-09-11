create procedure SP_deshabilitarCliente(
@id_persona int)
as
begin
	update Cliente set estado = 'I'
	where Cliente.id_persona = @id_persona; 
end 