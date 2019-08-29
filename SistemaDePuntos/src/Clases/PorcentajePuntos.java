package Clases;

import java.sql.ResultSet;


public class PorcentajePuntos {
    public static ResultSet mostrarPorcentaje() {
        String consulta = "Select * from Configuracion";
        ResultSet res = Conexion.Conexion.consulta(consulta);
        return res;
    }
    
    public static ResultSet mostrarDuracion() {
        String consulta = "Select duracion_puntos from Configuracion";
        ResultSet res = Conexion.Conexion.consulta(consulta);
        return res;
    }
    
    public static ResultSet mostrarFecha() {
        String consulta = "Select fecha_configuracion from Configuracion";
        ResultSet res = Conexion.Conexion.consulta(consulta);
        return res;
    }
    
}
