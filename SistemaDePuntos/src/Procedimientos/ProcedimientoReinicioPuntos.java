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
public class ProcedimientoReinicioPuntos {
    public static void reinicioPuntos() throws SQLException{
        CallableStatement entrada = Conexion.Conexion.getConexion().prepareCall("{call SP_REINICIO_PUNTOS(?)}");
        entrada.registerOutParameter(1, java.sql.Types.VARCHAR);
        entrada.execute();

        String mensaje = entrada.getString(1);

        JOptionPane.showMessageDialog(null, mensaje, "Informacion", JOptionPane.INFORMATION_MESSAGE);

    
    }
}
