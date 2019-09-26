/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procedimientos;

import java.sql.CallableStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class ProcedimientosParametrosImpresion {
    public static void agregarParametros(int anchura,int altura)throws SQLException{
        CallableStatement entrada = Conexion.Conexion.getConexion().prepareCall("{call SP_AGREGAR_PARAMETROS(?,?,?)}");
        entrada.setInt(1,anchura);
        entrada.setInt(2,altura);
        entrada.registerOutParameter(3, java.sql.Types.VARCHAR);
        entrada.execute();

        String mensaje = entrada.getString(3);

        JOptionPane.showMessageDialog(null, mensaje, "Informacion", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void editarParametros(int id,int anchura,int altura)throws SQLException{
        CallableStatement entrada = Conexion.Conexion.getConexion().prepareCall("{call SP_EDITAR_PARAMETROS(?,?,?,?)}");
        entrada.setInt(1,id);
        entrada.setInt(2,anchura);
        entrada.setInt(3,altura);
        entrada.registerOutParameter(4, java.sql.Types.VARCHAR);
        entrada.execute();

        String mensaje = entrada.getString(4);

        JOptionPane.showMessageDialog(null, mensaje, "Informacion", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void eliminarParametros(int id)throws SQLException{
        CallableStatement entrada = Conexion.Conexion.getConexion().prepareCall("{call SP_ELIMINAR_PARAMETROS(?,?)}");
        entrada.setInt(1,id);
        entrada.registerOutParameter(2, java.sql.Types.VARCHAR);
        entrada.execute();

        String mensaje = entrada.getString(2);

        JOptionPane.showMessageDialog(null, mensaje, "Informacion", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void activarParametro(int id)throws SQLException{
        CallableStatement entrada = Conexion.Conexion.getConexion().prepareCall("{call SP_ACTIVAR_PARAMETRO(?,?)}");
        entrada.setInt(1,id);
        entrada.registerOutParameter(2, java.sql.Types.VARCHAR);
        entrada.execute();

        String mensaje = entrada.getString(2);

        JOptionPane.showMessageDialog(null, mensaje, "Informacion", JOptionPane.INFORMATION_MESSAGE);
    }
}
