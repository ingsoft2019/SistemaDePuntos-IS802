package Clases;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author bayron
 */
public class Persona {
    
    //Metodo para buscar el ultimo registro de la base de datos
    //Usado para asignarlo a un cliente
    public static int UltimoRegistro() throws SQLException {
        int ultimoRegistro = 0;
        String consulta = "Select MAX(id_persona) from Persona";
        ResultSet id = Conexion.Conexion.consulta(consulta);
        while (id.next()) {
            ultimoRegistro = id.getInt(1);
        }
        return ultimoRegistro;
    }
}

