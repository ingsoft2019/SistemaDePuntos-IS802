package frmArea;

import javax.swing.ImageIcon;
import Clases.PorcentajePuntos;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class frmConfiguracionPorcentajePuntos extends javax.swing.JFrame {

    public frmConfiguracionPorcentajePuntos() {
         initComponents();
        this.setLocationRelativeTo(null); //para ponerse en el centro
        this.setResizable(false); //Desactivar botón maximizar de una ventana
        setIconImage(new ImageIcon(getClass().getResource("../imgSP/icono.png")).getImage()); //cambia el icono del formulario
        mostrarPorcentaje();
        btnGuardar.setVisible(false);
        ValidarIdentidad(txtPorcentajeActual);
        
    }
    
    public void mostrarPorcentaje(){
        double conversion;
        ResultSet porcentaje = PorcentajePuntos.mostrarPorcentaje();
        
        
        try {
            while (porcentaje.next()){
                conversion = Double.parseDouble(porcentaje.getString("porcentaje_puntos"))*100;
                int x = (int) conversion;
                txtPorcentajeActual.setText(String.valueOf(x));
                txtDuracionPuntos.setText(porcentaje.getString("duracion_puntos"));
                txtFechaConfiguracion.setText(porcentaje.getString("fecha_configuracion"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmConfiguracionPorcentajePuntos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpanel_SubMenu = new javax.swing.JPanel();
        btnEditar = new javax.swing.JButton();
        jl_TituloPrincipal = new javax.swing.JLabel();
        lblFechaConfiguracion = new javax.swing.JLabel();
        txtDuracionPuntos = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtFechaConfiguracion = new javax.swing.JTextField();
        lblPorcentajeActual1 = new javax.swing.JLabel();
        txtPorcentajeActual = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configuración porcentaje de puntos");
        setMaximumSize(new java.awt.Dimension(695, 478));
        setMinimumSize(new java.awt.Dimension(695, 478));
        setPreferredSize(new java.awt.Dimension(695, 478));
        getContentPane().setLayout(null);

        jpanel_SubMenu.setMinimumSize(new java.awt.Dimension(680, 530));
        jpanel_SubMenu.setLayout(null);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/modificar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jpanel_SubMenu.add(btnEditar);
        btnEditar.setBounds(240, 310, 120, 50);

        jl_TituloPrincipal.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jl_TituloPrincipal.setText("Configuracion de Puntos");
        jpanel_SubMenu.add(jl_TituloPrincipal);
        jl_TituloPrincipal.setBounds(140, 20, 320, 30);

        lblFechaConfiguracion.setText("Fecha configuracion:");
        jpanel_SubMenu.add(lblFechaConfiguracion);
        lblFechaConfiguracion.setBounds(80, 200, 130, 16);

        txtDuracionPuntos.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        txtDuracionPuntos.setEnabled(false);
        txtDuracionPuntos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDuracionPuntosActionPerformed(evt);
            }
        });
        txtDuracionPuntos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDuracionPuntosKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDuracionPuntosKeyTyped(evt);
            }
        });
        jpanel_SubMenu.add(txtDuracionPuntos);
        txtDuracionPuntos.setBounds(410, 100, 70, 40);

        jLabel1.setText("<html><center>Duracion de Puntos (Meses):");
        jpanel_SubMenu.add(jLabel1);
        jLabel1.setBounds(310, 100, 100, 40);

        txtFechaConfiguracion.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        txtFechaConfiguracion.setEnabled(false);
        txtFechaConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaConfiguracionActionPerformed(evt);
            }
        });
        jpanel_SubMenu.add(txtFechaConfiguracion);
        txtFechaConfiguracion.setBounds(220, 190, 170, 40);

        lblPorcentajeActual1.setText("Porcentaje Actual:");
        jpanel_SubMenu.add(lblPorcentajeActual1);
        lblPorcentajeActual1.setBounds(40, 110, 110, 16);

        txtPorcentajeActual.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        txtPorcentajeActual.setEnabled(false);
        txtPorcentajeActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPorcentajeActualActionPerformed(evt);
            }
        });
        txtPorcentajeActual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPorcentajeActualKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPorcentajeActualKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPorcentajeActualKeyTyped(evt);
            }
        });
        jpanel_SubMenu.add(txtPorcentajeActual);
        txtPorcentajeActual.setBounds(150, 100, 50, 40);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jpanel_SubMenu.add(btnGuardar);
        btnGuardar.setBounds(240, 310, 120, 50);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jLabel2.setText("%");
        jpanel_SubMenu.add(jLabel2);
        jLabel2.setBounds(210, 100, 30, 40);

        getContentPane().add(jpanel_SubMenu);
        jpanel_SubMenu.setBounds(50, 20, 580, 410);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        btnEditar.setVisible(false);
        btnGuardar.setVisible(true);
        
        txtPorcentajeActual.setEnabled(true);
        txtDuracionPuntos.setEnabled(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtDuracionPuntosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDuracionPuntosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDuracionPuntosActionPerformed

    private void txtFechaConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaConfiguracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaConfiguracionActionPerformed

    private void txtPorcentajeActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPorcentajeActualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPorcentajeActualActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        btnGuardar.setVisible(false);
        btnEditar.setVisible(true);
        
        txtPorcentajeActual.setEnabled(false);
        txtDuracionPuntos.setEnabled(false);
        
        //Obtener fecha del sistema para agregarla como fecha de registro del cliente
        //java.util.Date fechaActual = new java.util.Date();
        //java.sql.Date fechaRegistro = new java.sql.Date(fechaActual.getTime());//Convertir a fecha compatible con sql
        
        if (txtPorcentajeActual.getText().isEmpty()|| txtDuracionPuntos.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Hay campos vacios que son obligatorios", "Error", JOptionPane.INFORMATION_MESSAGE);
        } 
        else {try {
                int codigo=JOptionPane.showConfirmDialog(null, "¿Estas seguro de realizar la configuracion?", "Informacion", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (codigo==JOptionPane.YES_OPTION){
                    double porcentaje=Double.parseDouble(txtPorcentajeActual.getText()) ;
                    Procedimientos.ProcedimientoEditarConfiguracion.editarConfiguracion(porcentaje/100, Integer.parseInt(txtDuracionPuntos.getText()));
                }
            } catch (SQLException ex) {
                Logger.getLogger(frmConfiguracionPorcentajePuntos.class.getName()).log(Level.SEVERE, null, ex);
            }
         //
   
        }
        
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtPorcentajeActualKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPorcentajeActualKeyPressed

    }//GEN-LAST:event_txtPorcentajeActualKeyPressed

    private void txtDuracionPuntosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDuracionPuntosKeyPressed
    
    }//GEN-LAST:event_txtDuracionPuntosKeyPressed

    private void txtPorcentajeActualKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPorcentajeActualKeyTyped
        if (txtPorcentajeActual.getText().length()== 2){
            evt.consume(); 
        }
    }//GEN-LAST:event_txtPorcentajeActualKeyTyped

    private void txtDuracionPuntosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDuracionPuntosKeyTyped
        char c = evt.getKeyChar();        
        if (c< '0'|| c>'9') evt.consume();
        
         if (txtDuracionPuntos.getText().length()== 2){
            evt.consume(); 
        }
    }//GEN-LAST:event_txtDuracionPuntosKeyTyped

    public void ValidarIdentidad(JTextField campo){
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                
               if((int)e.getKeyChar()>=32 && (int)e.getKeyChar()<=47
                       || (int)e.getKeyChar()>=58 && (int)e.getKeyChar()<=255){
                   e.consume();
                   JOptionPane.showMessageDialog(null, "No puedes agregar letras o caracteres");
                   //campo.setText(null);
               }
            }
});
    }
    
    private void txtPorcentajeActualKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPorcentajeActualKeyReleased
        
    }//GEN-LAST:event_txtPorcentajeActualKeyReleased

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
            java.util.logging.Logger.getLogger(frmConfiguracionPorcentajePuntos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmConfiguracionPorcentajePuntos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmConfiguracionPorcentajePuntos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmConfiguracionPorcentajePuntos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmConfiguracionPorcentajePuntos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jl_TituloPrincipal;
    private javax.swing.JPanel jpanel_SubMenu;
    private javax.swing.JLabel lblFechaConfiguracion;
    private javax.swing.JLabel lblPorcentajeActual1;
    private javax.swing.JTextField txtDuracionPuntos;
    private javax.swing.JTextField txtFechaConfiguracion;
    private javax.swing.JTextField txtPorcentajeActual;
    // End of variables declaration//GEN-END:variables
}
