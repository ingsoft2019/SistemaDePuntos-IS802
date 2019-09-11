create procedure SP_habilitarCliente(
@id_persona int)
as
begin
	update Cliente set estado = 'A'
	where Cliente.id_persona = @id_persona; 
end 