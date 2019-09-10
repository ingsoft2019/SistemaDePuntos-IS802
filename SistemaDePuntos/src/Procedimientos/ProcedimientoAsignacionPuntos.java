/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procedimientos;


import com.itextpdf.text.DocumentException;
import java.awt.print.PrinterException;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author pc
 */
public class ProcedimientoAsignacionPuntos {
    public static void guardarMovimiento(int idCliente, String usuario, int idFactura)throws SQLException, FileNotFoundException, DocumentException{
        CallableStatement entrada = Conexion.Conexion.getConexion().prepareCall("{call SP_ASIGNAR_PUNTOS (?,?,?,?,?,?,?,?,?)}");
        entrada.setInt(1,idCliente);
        entrada.setString(2,usuario);        
        entrada.setInt(3,idFactura);
        
        entrada.registerOutParameter(4, java.sql.Types.VARCHAR);
        entrada.registerOutParameter(5, java.sql.Types.INTEGER);
        entrada.registerOutParameter(6, java.sql.Types.INTEGER);
        entrada.registerOutParameter(7, java.sql.Types.INTEGER);
        entrada.registerOutParameter(8, java.sql.Types.INTEGER);
        entrada.registerOutParameter(9, java.sql.Types.VARCHAR);
        entrada.execute();
        
        String mensaje = entrada.getString(4);
        Integer codigo = entrada.getInt(5);
        Integer puntosActuales = entrada.getInt(6);
        Integer puntosAnteriores = entrada.getInt(7);
        Integer puntosAsignados = entrada.getInt(8);
        String cliente = entrada.getString(9);
        
        String[] options = {"Imprimir", "No Imprimir"};
        
        Date fechaActual = new Date();
        String fechaActualCon = fechaActual.toString();
        
        if (codigo== 0){
            int respuesta = JOptionPane.showOptionDialog(null, mensaje, "Imprimir Factura", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (respuesta == 0){
                try {
                    //Imprimir
                    Clases.GeneraraPDF2.generarPdf(String.valueOf(puntosActuales), String.valueOf(puntosAnteriores), String.valueOf(puntosAsignados), cliente);
                } catch (PrinterException ex) {
                    Logger.getLogger(ProcedimientoAsignacionPuntos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ProcedimientoAsignacionPuntos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                //No imprimir
            }            
        }
        else {
            JOptionPane.showMessageDialog(null, mensaje, "Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
