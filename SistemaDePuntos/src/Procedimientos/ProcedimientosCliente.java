
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

    //Agregar una nueva Zona si no existe
     public static void guardarZona(String zona)throws SQLException{
        CallableStatement entrada = Conexion.Conexion.getConexion().prepareCall("{call SP_REGISTRAR_ZONA (?)}");
        entrada.setString(1, zona);
        entrada.execute();
    }
     
     public static void actualizarCliente(String pnombre, String snombre,String papellido, String sapellido, 
                                      String identidad, String correo, String sexo, Date fecha_nacimiento, 
                                      String telefono1,String telefono2,String telefono3, int zona, 
                                      String detalle_direccion, int puntos_actuales, String fechavencimiento,
                                      int puntos_rifa, int id)throws SQLException{
        
        //Llamamos al procedimiento almacenado GuardarPersonas
        CallableStatement entrada = Conexion.Conexion.getConexion().prepareCall("{call SP_actualizarCliente (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
        entrada.setString(1,pnombre);
        entrada.setString(2,snombre);
        entrada.setString(3,papellido);
        entrada.setString(4,sapellido);
        entrada.setString(5,identidad);
        entrada.setString(6,correo);
        entrada.setString(7,sexo);
        entrada.setDate(8,fecha_nacimiento);
        entrada.setString(9,telefono1);
        entrada.setString(10,telefono2);
        entrada.setString(11,telefono3);
        entrada.setInt(12,zona);
        entrada.setString(13,detalle_direccion);
        entrada.setInt(14,puntos_actuales);
        entrada.setString(15,fechavencimiento);
        entrada.setInt(16,puntos_rifa);
        entrada.setInt(17,id);
        entrada.execute();
        
    }
    
    public static void deshabilitarCliente(int idPersona) throws SQLException{
        CallableStatement entrada = Conexion.Conexion.getConexion().prepareCall("{Call SP_deshabilitarCliente(?)}");
        entrada.setInt(1, idPersona);
        entrada.execute();
    }
    
    public static void habilitarCliente(int idPersona)throws SQLException{
        CallableStatement entrada = Conexion.Conexion.getConexion().prepareCall("{Call SP_habilitarCliente(?)}");
        entrada.setInt(1, idPersona);
        entrada.execute();
    }
    
    public static void eliminarZona(int idzona)throws SQLException{
        CallableStatement entrada = Conexion.Conexion.getConexion().prepareCall("{Call SP_eliminarZona(?)}");
        entrada.setInt(1, idzona);
        entrada.execute();
    }
    
}
