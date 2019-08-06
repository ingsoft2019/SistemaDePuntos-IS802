/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procedimientos;

import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;
import java.sql.ResultSet;

/**
 *
 * @author pc
 */
public class ProcedimientoAsignacionPuntos {
    public static void guardarMovimiento(int idCliente, double porcentajePuntos, int tipoMovimiento, String usuario, int idFactura)throws SQLException{
        CallableStatement entrada = Conexion.Conexion.getConexion().prepareCall("{call SP_ASIGNAR_PUNTOS (?,?,?,?,?,?,?)}");
        entrada.setInt(1,idCliente);
        entrada.setDouble(2,porcentajePuntos);
        entrada.setInt(3,tipoMovimiento);
        entrada.setString(4,usuario);
        entrada.setInt(5,idFactura);
        entrada.registerOutParameter(6, java.sql.Types.VARCHAR);
        entrada.registerOutParameter(7, java.sql.Types.INTEGER);
        entrada.execute();
        
        String mensaje = entrada.getString(6);
        Integer codigo = entrada.getInt(7);
        
        JOptionPane.showMessageDialog(null, "Mensaje: "+mensaje + ", Codigo: "+codigo, "Informacion", JOptionPane.INFORMATION_MESSAGE);
        
    }
}
