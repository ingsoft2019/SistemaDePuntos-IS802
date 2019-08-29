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
public class ProcedimientoCanjeoPuntos{
    public static void guardarMovimiento(int idCliente, String usuario, int puntosCanjeo) throws SQLException{
        CallableStatement entrada = Conexion.Conexion.getConexion().prepareCall("{call SP_CANJEAR_PUNTOS (?,?,?,?)}");
        entrada.setInt(1,idCliente);
        entrada.setInt(2,puntosCanjeo);
        entrada.setString(3,usuario);
        entrada.registerOutParameter(4, java.sql.Types.VARCHAR);
        entrada.execute();

        String mensaje = entrada.getString(4);

        JOptionPane.showMessageDialog(null, mensaje, "Informacion", JOptionPane.INFORMATION_MESSAGE);
    }
}
