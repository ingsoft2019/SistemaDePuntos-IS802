
package Procedimientos;

/**@author bayron*/

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;

public class ProcedimientosCliente {
    public static void guardarPersona(String pnombre, String snombre,String papellido, String sapellido, 
                                      String identidad, String correo, String sexo, Date fecha_nacimiento, 
                                      int id_zona, String detalle_direccion, String telefono1,String telefono2,
                                      String telefono3)throws SQLException{
        
        //Llamamos al procedimiento almacenado GuardarPersonas
        CallableStatement entrada = Conexion.Conexion.getConexion().prepareCall("{call GuardarPersona (?,?,?,?,?,?,?,?,?,?,?,?,?)}");
        entrada.setString(1,pnombre);
        entrada.setString(2,snombre);
        entrada.setString(3,papellido);
        entrada.setString(4,sapellido);
        entrada.setString(5,identidad);
        entrada.setString(6,correo);
        entrada.setString(7,sexo);
        entrada.setDate(8,fecha_nacimiento);
        entrada.setInt(9,id_zona);
        entrada.setString(10,detalle_direccion);
        entrada.setString(11,telefono1);
        entrada.setString(12,telefono2);
        entrada.setString(13,telefono3);
        entrada.execute();
        
    }
    //Llamamos al procedimiento almacenado GuardarClientes
    public static void guardarCliente(Date fecha_registro, int id_persona)throws SQLException{
        CallableStatement entrada = Conexion.Conexion.getConexion().prepareCall("{call GuardarCliente (?,?)}");
        entrada.setDate(1, fecha_registro);
        entrada.setInt(2, id_persona);
        entrada.execute();
    }

 
}
