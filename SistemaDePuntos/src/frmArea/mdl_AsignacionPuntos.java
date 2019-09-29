/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frmArea;

/**
 *
 * @author Luis Estrada
 */
import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class mdl_AsignacionPuntos extends java.awt.Dialog {
    private int id;
    private String cliente;
    /**
     * Creates new form mdl_AsignacionPuntos
     */
    public mdl_AsignacionPuntos( java.awt.Frame parent, boolean modal) {
        super(parent , modal);
        initComponents();
        this.setLocationRelativeTo(null); //para ponerse en el centro
        this.setResizable(false); //Desactivar botón maximizar de una ventana
        setIconImage(new ImageIcon(getClass().getResource("../imgSP/icono.png")).getImage()); //cambia el icono del formulario
        txtNombreCliente.setEditable(false);
    }
    
    public void recibirIdCliente(int idCliente){
        this.id = idCliente;
        
    }
    public void recibirCliente(String nombreCliente){
        this.cliente = nombreCliente;
        this.getTxtNombreCliente().setText(nombreCliente);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lblAsignacionPuntos = new javax.swing.JLabel();
        lblIdFactura = new javax.swing.JLabel();
        txtIdFactura = new javax.swing.JTextField();
        txtNombreCliente = new javax.swing.JTextField();
        lblNombreCliente = new javax.swing.JLabel();
        btn_asignar = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(478, 245));
        setMinimumSize(new java.awt.Dimension(478, 245));
        setTitle("Asignación de puntos ");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });
        setLayout(null);

        jPanel2.setLayout(null);

        lblAsignacionPuntos.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblAsignacionPuntos.setText("Asignación de puntos");
        jPanel2.add(lblAsignacionPuntos);
        lblAsignacionPuntos.setBounds(110, 20, 270, 38);

        lblIdFactura.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblIdFactura.setText("Id Facura:");
        jPanel2.add(lblIdFactura);
        lblIdFactura.setBounds(60, 130, 80, 30);

        txtIdFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdFacturaKeyTyped(evt);
            }
        });
        jPanel2.add(txtIdFactura);
        txtIdFactura.setBounds(140, 130, 320, 30);

        txtNombreCliente.setEnabled(false);
        txtNombreCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreClienteKeyTyped(evt);
            }
        });
        jPanel2.add(txtNombreCliente);
        txtNombreCliente.setBounds(140, 80, 320, 30);

        lblNombreCliente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblNombreCliente.setText("Cliente:");
        jPanel2.add(lblNombreCliente);
        lblNombreCliente.setBounds(60, 80, 80, 30);

        btn_asignar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/asignar.png"))); // NOI18N
        btn_asignar.setText("Asignar");
        btn_asignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_asignarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_asignar);
        btn_asignar.setBounds(180, 180, 140, 40);

        add(jPanel2);
        jPanel2.setBounds(0, 0, 490, 250);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void txtIdFacturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdFacturaKeyTyped
        char c = evt.getKeyChar();

        if (c< '0'|| c>'9') evt.consume();
    }//GEN-LAST:event_txtIdFacturaKeyTyped

    private void txtNombreClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreClienteKeyTyped
        char c = evt.getKeyChar();

        if (c< '0'|| c>'9') evt.consume();
    }//GEN-LAST:event_txtNombreClienteKeyTyped

    private void btn_asignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_asignarActionPerformed
        if (getTxtIdFactura().getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Hay campos vacios que son obligatorios", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        } else {try {
            int codigo=JOptionPane.showConfirmDialog(null, "¿Estas seguro de asignar los puntos?", "Informacion", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (codigo==JOptionPane.YES_OPTION){
                Procedimientos.ProcedimientoAsignacionPuntos.guardarMovimiento(this.id, "ADMIN", Integer.parseInt(getTxtIdFactura().getText()) );
            }
        } catch (SQLException ex) {
            Logger.getLogger(mdl_AsignacionPuntos.class.getName()).log(Level.SEVERE, null, ex);
        }   catch (FileNotFoundException ex) {
                Logger.getLogger(mdl_AsignacionPuntos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException ex) {
                Logger.getLogger(mdl_AsignacionPuntos.class.getName()).log(Level.SEVERE, null, ex);
            }

    }
        
    }//GEN-LAST:event_btn_asignarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                mdl_AsignacionPuntos dialog = new mdl_AsignacionPuntos(new java.awt.Frame(), true);
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
    private javax.swing.JButton btn_asignar;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblAsignacionPuntos;
    private javax.swing.JLabel lblIdFactura;
    private javax.swing.JLabel lblNombreCliente;
    private javax.swing.JTextField txtIdFactura;
    private javax.swing.JTextField txtNombreCliente;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the txtIdFactura
     */
    public javax.swing.JTextField getTxtIdFactura() {
        return txtIdFactura;
    }

    /**
     * @param txtIdFactura the txtIdFactura to set
     */
    public void setTxtIdFactura(javax.swing.JTextField txtIdFactura) {
        this.txtIdFactura = txtIdFactura;
    }

    /**
     * @return the txtNombreCliente
     */
    public javax.swing.JTextField getTxtNombreCliente() {
        return txtNombreCliente;
    }

    /**
     * @param txtNombreCliente the txtNombreCliente to set
     */
    public void setTxtNombreCliente(javax.swing.JTextField txtNombreCliente) {
        this.txtNombreCliente = txtNombreCliente;
    }

    /**
     * @return the btn_asignar
     */
    public javax.swing.JButton getBtn_asignar() {
        return btn_asignar;
    }

    /**
     * @param btn_asignar the btn_asignar to set
     */
    public void setBtn_asignar(javax.swing.JButton btn_asignar) {
        this.btn_asignar = btn_asignar;
    }

    /**
     * @return the jPanel2
     */
    public javax.swing.JPanel getjPanel2() {
        return jPanel2;
    }

    /**
     * @param jPanel2 the jPanel2 to set
     */
    public void setjPanel2(javax.swing.JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    /**
     * @return the lblAsignacionPuntos
     */
    public javax.swing.JLabel getLblAsignacionPuntos() {
        return lblAsignacionPuntos;
    }

    /**
     * @param lblAsignacionPuntos the lblAsignacionPuntos to set
     */
    public void setLblAsignacionPuntos(javax.swing.JLabel lblAsignacionPuntos) {
        this.lblAsignacionPuntos = lblAsignacionPuntos;
    }

    /**
     * @return the lblIdFactura
     */
    public javax.swing.JLabel getLblIdFactura() {
        return lblIdFactura;
    }

    /**
     * @param lblIdFactura the lblIdFactura to set
     */
    public void setLblIdFactura(javax.swing.JLabel lblIdFactura) {
        this.lblIdFactura = lblIdFactura;
    }

    /**
     * @return the lblNombreCliente
     */
    public javax.swing.JLabel getLblNombreCliente() {
        return lblNombreCliente;
    }

    /**
     * @param lblNombreCliente the lblNombreCliente to set
     */
    public void setLblNombreCliente(javax.swing.JLabel lblNombreCliente) {
        this.lblNombreCliente = lblNombreCliente;
    }
    
}
