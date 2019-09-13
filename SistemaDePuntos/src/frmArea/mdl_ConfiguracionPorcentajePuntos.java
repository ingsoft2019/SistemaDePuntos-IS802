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

public class mdl_ConfiguracionPorcentajePuntos extends java.awt.Dialog {

    /**
     * Creates new form mdl_ConfiguracionPorcentajePuntos
     */
    public mdl_ConfiguracionPorcentajePuntos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null); //para ponerse en el centro
        this.setResizable(false); //Desactivar botón maximizar de una ventana
        setIconImage(new ImageIcon(getClass().getResource("../imgSP/icono.png")).getImage()); //cambia el icono del formulario
        mostrarPorcentaje();
        btnGuardar.setVisible(false);
        ValidarIdentidad(txtPorcentajeActual);
   }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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

        setMaximumSize(new java.awt.Dimension(577, 346));
        setMinimumSize(new java.awt.Dimension(577, 346));
        setTitle("Configuración de Porcentaje de Puntos");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });
        setLayout(null);

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
        btnEditar.setBounds(230, 250, 140, 40);

        jl_TituloPrincipal.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jl_TituloPrincipal.setText("Configuración de Porcentaje  Puntos");
        jpanel_SubMenu.add(jl_TituloPrincipal);
        jl_TituloPrincipal.setBounds(70, 40, 450, 30);

        lblFechaConfiguracion.setText("Fecha configuracion:");
        jpanel_SubMenu.add(lblFechaConfiguracion);
        lblFechaConfiguracion.setBounds(80, 200, 130, 16);

        txtDuracionPuntos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
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
        txtDuracionPuntos.setBounds(410, 100, 90, 30);

        jLabel1.setText("<html><center>Duracion de Puntos (Meses):");
        jpanel_SubMenu.add(jLabel1);
        jLabel1.setBounds(310, 100, 100, 40);

        txtFechaConfiguracion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtFechaConfiguracion.setEnabled(false);
        txtFechaConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaConfiguracionActionPerformed(evt);
            }
        });
        jpanel_SubMenu.add(txtFechaConfiguracion);
        txtFechaConfiguracion.setBounds(220, 190, 280, 30);

        lblPorcentajeActual1.setText("Porcentaje Actual:");
        jpanel_SubMenu.add(lblPorcentajeActual1);
        lblPorcentajeActual1.setBounds(40, 110, 110, 16);

        txtPorcentajeActual.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
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
        txtPorcentajeActual.setBounds(150, 100, 60, 30);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jpanel_SubMenu.add(btnGuardar);
        btnGuardar.setBounds(230, 250, 140, 40);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jLabel2.setText("%");
        jpanel_SubMenu.add(jLabel2);
        jLabel2.setBounds(220, 90, 30, 40);

        add(jpanel_SubMenu);
        jpanel_SubMenu.setBounds(0, 0, 580, 350);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

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
            Logger.getLogger(mdl_ConfiguracionPorcentajePuntos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
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
    
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        btnEditar.setVisible(false);
        btnGuardar.setVisible(true);

        getTxtPorcentajeActual().setEnabled(true);
        getTxtDuracionPuntos().setEnabled(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtDuracionPuntosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDuracionPuntosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDuracionPuntosActionPerformed

    private void txtDuracionPuntosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDuracionPuntosKeyPressed

    }//GEN-LAST:event_txtDuracionPuntosKeyPressed

    private void txtDuracionPuntosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDuracionPuntosKeyTyped
        char c = evt.getKeyChar();
        if (c< '0'|| c>'9') evt.consume();

        if (getTxtDuracionPuntos().getText().length()== 2){
            evt.consume();
        }
    }//GEN-LAST:event_txtDuracionPuntosKeyTyped

    private void txtFechaConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaConfiguracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaConfiguracionActionPerformed

    private void txtPorcentajeActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPorcentajeActualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPorcentajeActualActionPerformed

    private void txtPorcentajeActualKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPorcentajeActualKeyPressed

    }//GEN-LAST:event_txtPorcentajeActualKeyPressed

    private void txtPorcentajeActualKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPorcentajeActualKeyReleased

    }//GEN-LAST:event_txtPorcentajeActualKeyReleased

    private void txtPorcentajeActualKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPorcentajeActualKeyTyped
        if (getTxtPorcentajeActual().getText().length()== 2){
            evt.consume();
        }
    }//GEN-LAST:event_txtPorcentajeActualKeyTyped

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        btnGuardar.setVisible(false);
        btnEditar.setVisible(true);

        getTxtPorcentajeActual().setEnabled(false);
        getTxtDuracionPuntos().setEnabled(false);

        //Obtener fecha del sistema para agregarla como fecha de registro del cliente
        //java.util.Date fechaActual = new java.util.Date();
        //java.sql.Date fechaRegistro = new java.sql.Date(fechaActual.getTime());//Convertir a fecha compatible con sql

        if (getTxtPorcentajeActual().getText().isEmpty()|| getTxtDuracionPuntos().getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Hay campos vacios que son obligatorios", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        else {try {
            int codigo=JOptionPane.showConfirmDialog(null, "¿Estas seguro de realizar la configuracion?", "Informacion", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (codigo==JOptionPane.YES_OPTION){
                double porcentaje=Double.parseDouble(getTxtPorcentajeActual().getText()) ;
                Procedimientos.ProcedimientoEditarConfiguracion.editarConfiguracion(porcentaje/100, Integer.parseInt(getTxtDuracionPuntos().getText()));
            }
        } catch (SQLException ex) {
            Logger.getLogger(mdl_ConfiguracionPorcentajePuntos.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                mdl_ConfiguracionPorcentajePuntos dialog = new mdl_ConfiguracionPorcentajePuntos(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
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

    /**
     * @return the txtDuracionPuntos
     */
    public javax.swing.JTextField getTxtDuracionPuntos() {
        return txtDuracionPuntos;
    }

    /**
     * @param txtDuracionPuntos the txtDuracionPuntos to set
     */
    public void setTxtDuracionPuntos(javax.swing.JTextField txtDuracionPuntos) {
        this.txtDuracionPuntos = txtDuracionPuntos;
    }

    /**
     * @return the txtFechaConfiguracion
     */
    public javax.swing.JTextField getTxtFechaConfiguracion() {
        return txtFechaConfiguracion;
    }

    /**
     * @param txtFechaConfiguracion the txtFechaConfiguracion to set
     */
    public void setTxtFechaConfiguracion(javax.swing.JTextField txtFechaConfiguracion) {
        this.txtFechaConfiguracion = txtFechaConfiguracion;
    }

    /**
     * @return the txtPorcentajeActual
     */
    public javax.swing.JTextField getTxtPorcentajeActual() {
        return txtPorcentajeActual;
    }

    /**
     * @param txtPorcentajeActual the txtPorcentajeActual to set
     */
    public void setTxtPorcentajeActual(javax.swing.JTextField txtPorcentajeActual) {
        this.txtPorcentajeActual = txtPorcentajeActual;
    }
}
