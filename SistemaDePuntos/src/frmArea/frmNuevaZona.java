/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frmArea;

import Clases.Persona;
import Clases.Zona;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author bayron
 */
public class frmNuevaZona extends javax.swing.JFrame {

    ResultSet res = null;
    int cont = 0;

    /**
     * Creates new form frmNuevaZona
     */
    public frmNuevaZona() {
        initComponents();
        setLocationRelativeTo(null);// Para que el formulario aparezca en el centro de la pantala
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JL_zona = new javax.swing.JLabel();
        txt_nuevaZona = new javax.swing.JTextField();
        btn_guardarZona = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nueva zona");
        setLocation(new java.awt.Point(0, 0));
        setMaximumSize(new java.awt.Dimension(591, 96));
        setMinimumSize(new java.awt.Dimension(591, 96));
        setName("Jpanel_NuevaZona"); // NOI18N
        setPreferredSize(new java.awt.Dimension(591, 96));
        setResizable(false);
        getContentPane().setLayout(null);

        JL_zona.setText("Zona:");
        JL_zona.setMaximumSize(new java.awt.Dimension(40, 240));
        JL_zona.setMinimumSize(new java.awt.Dimension(40, 240));
        getContentPane().add(JL_zona);
        JL_zona.setBounds(10, 30, 40, 24);

        txt_nuevaZona.setMaximumSize(new java.awt.Dimension(330, 24));
        txt_nuevaZona.setMinimumSize(new java.awt.Dimension(330, 24));
        txt_nuevaZona.setPreferredSize(new java.awt.Dimension(330, 24));
        getContentPane().add(txt_nuevaZona);
        txt_nuevaZona.setBounds(60, 30, 330, 24);

        btn_guardarZona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/guardar.png"))); // NOI18N
        btn_guardarZona.setText("Guardar");
        btn_guardarZona.setMaximumSize(new java.awt.Dimension(160, 40));
        btn_guardarZona.setMinimumSize(new java.awt.Dimension(160, 40));
        btn_guardarZona.setPreferredSize(new java.awt.Dimension(160, 40));
        btn_guardarZona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_guardarZonaMouseClicked(evt);
            }
        });
        btn_guardarZona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarZonaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_guardarZona);
        btn_guardarZona.setBounds(400, 20, 160, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarZonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarZonaActionPerformed
        if (txt_nuevaZona.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo está vacio", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try { //Esta consulta es para validar que no se inserte un registro duplicado
                res = Conexion.Conexion.consulta("SELECT COUNT(zona) from Zona WHERE zona='" + txt_nuevaZona.getText() + "'");
                try {
                    while (res.next()) {
                        cont = res.getInt(1);
                    }
                } catch (SQLException e) {
                }
                if (cont > 0) {
                    JOptionPane.showMessageDialog(this, "Esta zona ya existe", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                     
                } else {
                    Procedimientos.ProcedimientosCliente.guardarZona(txt_nuevaZona.getText());
                        new frmRegistroClientes().actulizarZonas();
//                    JOptionPane.showMessageDialog(this, "Zona agregada");
                    
                    dispose();//Para cerrar el formulario al agregar la zona
                }
            } catch (SQLException e) {
            }
        }
    }//GEN-LAST:event_btn_guardarZonaActionPerformed

    private void btn_guardarZonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_guardarZonaMouseClicked
          
    }//GEN-LAST:event_btn_guardarZonaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmNuevaZona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmNuevaZona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmNuevaZona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmNuevaZona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmNuevaZona().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JL_zona;
    private javax.swing.JButton btn_guardarZona;
    private javax.swing.JTextField txt_nuevaZona;
    // End of variables declaration//GEN-END:variables
}
