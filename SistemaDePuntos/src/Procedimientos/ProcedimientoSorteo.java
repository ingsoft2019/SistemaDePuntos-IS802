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
 * @author JB
 */
public class ProcedimientoSorteo {
    private String mensaje;
    
    public void realizarsorteo() throws SQLException{
        CallableStatement entrada = Conexion.Conexion.getConexion().prepareCall("{call SP_SORTEO (?)}");
        entrada.registerOutParameter(1, java.sql.Types.VARCHAR);
        entrada.execute();
        this.mensaje = entrada.getString(1);
        JOptionPane.showMessageDialog(null, mensaje, "Sorteo", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public  String getMensaje(){
        return mensaje;
    }
    
    
}
