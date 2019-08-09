package Clases;

import java.sql.ResultSet;

public class Zona {

    //Metodo para consultar el ID de la zona para agregarselo a los nuevos registros de cliente
    public static ResultSet consultarIdZona(String zona) {
        String consulta = "Select id_zona from Zona where Zona.zona='" + zona + "'";
        ResultSet id = Conexion.Conexion.consulta(consulta);
        return id;
    }

    //Metdodo para las zonas en el combobox
    public static ResultSet mostrarZonas() {
        String consulta = "Select * from Zona ORDER BY id_zona ASC";
        ResultSet res = Conexion.Conexion.consulta(consulta);
        return res;
        
    }   
}
    
