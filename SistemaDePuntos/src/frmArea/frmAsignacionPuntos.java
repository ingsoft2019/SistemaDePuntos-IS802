/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frmArea;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class frmAsignacionPuntos extends javax.swing.JFrame {

    /**
     * Creates new form frmAsignacionPuntos
     */
    public frmAsignacionPuntos() {
         initComponents();
        this.setLocationRelativeTo(null); //para ponerse en el centro
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAsignacionPuntos = new javax.swing.JLabel();
        lblIdFactura = new javax.swing.JLabel();
        lblNombreCliente = new javax.swing.JLabel();
        txtIdFactura = new javax.swing.JTextField();
        txtNombreCliente = new javax.swing.JTextField();
        btn_asignar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        btn_VolverMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Asignación de Puntos");
        setMaximumSize(new java.awt.Dimension(445, 291));
        setMinimumSize(new java.awt.Dimension(445, 291));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(445, 291));
        getContentPane().setLayout(null);

        lblAsignacionPuntos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblAsignacionPuntos.setText("Asignación de Puntos");
        getContentPane().add(lblAsignacionPuntos);
        lblAsignacionPuntos.setBounds(110, 20, 194, 38);

        lblIdFactura.setText("Id Facura:");
        getContentPane().add(lblIdFactura);
        lblIdFactura.setBounds(60, 100, 50, 14);

        lblNombreCliente.setText("ID del Cliente:");
        getContentPane().add(lblNombreCliente);
        lblNombreCliente.setBounds(40, 150, 68, 14);

        txtIdFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdFacturaKeyTyped(evt);
            }
        });
        getContentPane().add(txtIdFactura);
        txtIdFactura.setBounds(110, 100, 240, 20);

        txtNombreCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreClienteKeyTyped(evt);
            }
        });
        getContentPane().add(txtNombreCliente);
        txtNombreCliente.setBounds(110, 150, 240, 20);

        btn_asignar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/asignar.png"))); // NOI18N
        btn_asignar.setText("Asignar");
        getContentPane().add(btn_asignar);
        btn_asignar.setBounds(30, 220, 105, 41);

        btn_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/limpiar.png"))); // NOI18N
        btn_limpiar.setText("Limpiar");
        getContentPane().add(btn_limpiar);
        btn_limpiar.setBounds(150, 220, 101, 41);

        btn_VolverMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/volverMenu.png"))); // NOI18N
        btn_VolverMenu.setText("Volver");
        getContentPane().add(btn_VolverMenu);
        btn_VolverMenu.setBounds(270, 220, 110, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_asignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_asignarActionPerformed

    
    }//GEN-LAST:event_btn_asignarActionPerformed

    private void btn_limpiarCamposActionPerformed(java.awt.event.ActionEvent evt) {                                                  

        // TODO add your handling code here:
        if (txtIdFactura.getText().isEmpty()|| txtNombreCliente.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Hay campos vacios que son obligatorios", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        } 
        else {try {
                int codigo=JOptionPane.showConfirmDialog(null, "¿Estas seguro de asignar los puntos?", "Informacion", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (codigo==JOptionPane.YES_OPTION){
                    Procedimientos.ProcedimientoAsignacionPuntos.guardarMovimiento(Integer.parseInt( txtNombreCliente.getText()), 0.02, 1, "JRODAS", Integer.parseInt(txtIdFactura.getText()) );
                }
            } catch (SQLException ex) {
                Logger.getLogger(frmAsignacionPuntos.class.getName()).log(Level.SEVERE, null, ex);
            }
         //
   
        }
    }                                          

    private void txtIdFacturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdFacturaKeyTyped
        char c = evt.getKeyChar();
        
        if (c< '0'|| c>'9') evt.consume();
    }//GEN-LAST:event_txtIdFacturaKeyTyped

    private void txtNombreClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreClienteKeyTyped
        char c = evt.getKeyChar();
        
        if (c< '0'|| c>'9') evt.consume();
    }//GEN-LAST:event_txtNombreClienteKeyTyped

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
            java.util.logging.Logger.getLogger(frmAsignacionPuntos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAsignacionPuntos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAsignacionPuntos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAsignacionPuntos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAsignacionPuntos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_VolverMenu;
    private javax.swing.JButton btn_asignar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JLabel lblAsignacionPuntos;
    private javax.swing.JLabel lblIdFactura;
    private javax.swing.JLabel lblNombreCliente;
    private javax.swing.JTextField txtIdFactura;
    private javax.swing.JTextField txtNombreCliente;
    // End of variables declaration//GEN-END:variables
}
