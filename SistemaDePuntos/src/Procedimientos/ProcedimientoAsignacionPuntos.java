/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procedimientos;

import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.CallableStatement;


/**
 *
 * @author pc
 */
public class ProcedimientoAsignacionPuntos {
    public static void guardarMovimiento(int idCliente, String usuario, int idFactura)throws SQLException{
        CallableStatement entrada = Conexion.Conexion.getConexion().prepareCall("{call SP_ASIGNAR_PUNTOS (?,?,?,?,?)}");
        entrada.setInt(1,idCliente);
        entrada.setString(2,usuario);
        entrada.setInt(3,idFactura);
        entrada.registerOutParameter(4, java.sql.Types.VARCHAR);
        entrada.registerOutParameter(5, java.sql.Types.INTEGER);
        entrada.execute();
        
        String mensaje = entrada.getString(4);
        Integer codigo = entrada.getInt(5);
        
        JOptionPane.showMessageDialog(null, mensaje, "Informacion", JOptionPane.INFORMATION_MESSAGE);
        
    }
}
