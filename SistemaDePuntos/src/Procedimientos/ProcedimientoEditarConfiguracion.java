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
public class ProcedimientoEditarConfiguracion {
    public static void editarConfiguracion(double porcentaje, int duracion) throws SQLException{
        CallableStatement entrada = Conexion.Conexion.getConexion().prepareCall("{call SP_EDITAR_CONFIGURACION (?,?,?)}");
        entrada.setDouble(1,porcentaje);
        entrada.setInt(2,duracion);
        entrada.registerOutParameter(3, java.sql.Types.VARCHAR);
        entrada.execute();

        String mensaje = entrada.getString(3);

        JOptionPane.showMessageDialog(null, mensaje, "Editar Configuracion", JOptionPane.INFORMATION_MESSAGE);
    }
}
