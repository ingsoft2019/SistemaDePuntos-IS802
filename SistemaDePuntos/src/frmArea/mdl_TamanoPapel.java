/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frmArea;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Estrada
 */
public class mdl_TamanoPapel extends java.awt.Dialog {
    private int id=0; 
    /**
     * Creates new form mdl_tamano_papel
     */
    public mdl_TamanoPapel(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null); //para ponerse en el centro
        this.setResizable(false); //Desactivar botón maximizar de una ventana
        setIconImage(new ImageIcon(getClass().getResource("../imgSP/icono.png")).getImage()); //cambia el icono del formulario
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtAnchura = new javax.swing.JTextField();
        txtAltura = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(496, 272));
        setMinimumSize(new java.awt.Dimension(496, 272));
        setPreferredSize(new java.awt.Dimension(496, 272));
        setTitle("Tamaño de papel para impresión");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });
        setLayout(null);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Tamaño de papel para impresión");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(60, 40, 390, 40);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Anchura");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(290, 110, 70, 30);

        txtAnchura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAnchuraKeyTyped(evt);
            }
        });
        jPanel1.add(txtAnchura);
        txtAnchura.setBounds(360, 110, 60, 30);

        txtAltura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAlturaKeyTyped(evt);
            }
        });
        jPanel1.add(txtAltura);
        txtAltura.setBounds(140, 110, 60, 30);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Altura");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(90, 110, 50, 30);

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/guardar.png"))); // NOI18N
        btnAgregar.setText("Guardar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar);
        btnAgregar.setBounds(180, 180, 140, 40);

        jLabel4.setText("MM");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(420, 110, 30, 30);

        jLabel5.setText("MM");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(200, 110, 30, 30);

        add(jPanel1);
        jPanel1.setBounds(0, 0, 500, 280);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void txtAnchuraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnchuraKeyTyped
        char c = evt.getKeyChar();
        if (c< '0'|| c>'9') evt.consume();
    }//GEN-LAST:event_txtAnchuraKeyTyped

    private void txtAlturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAlturaKeyTyped
        char c = evt.getKeyChar();
        if (c< '0'|| c>'9') evt.consume();
    }//GEN-LAST:event_txtAlturaKeyTyped

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if(txtAnchura.getText().isEmpty() || txtAltura.getText().isEmpty() ){
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
        }
        else {
            //1 pulg = 72 puntos// 1 pulg = 2.54 cm // 1 pulg = 25.4 milimetros
            int valtura = Integer.parseInt(txtAltura.getText()), vanchura = Integer.parseInt(txtAnchura.getText());
            
            if (this.id == 0){
                try {
                Procedimientos.ProcedimientosParametrosImpresion.agregarParametros(vanchura, valtura);

                } catch (SQLException ex) {
                    Logger.getLogger(mdl_TamanoPapel.class.getName()).log(Level.SEVERE, null, ex);
                }                
            } else {
                try {
                Procedimientos.ProcedimientosParametrosImpresion.editarParametros(this.id ,vanchura, valtura);
                this.dispose();
                } catch (SQLException ex) {
                    Logger.getLogger(mdl_TamanoPapel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
    }//GEN-LAST:event_btnAgregarActionPerformed
    
    public void recibirId(int id){
        this.id = id;
        
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                mdl_TamanoPapel dialog = new mdl_TamanoPapel(new java.awt.Frame(), true);
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
    private javax.swing.JButton btnAgregar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtAltura;
    private javax.swing.JTextField txtAnchura;
    // End of variables declaration//GEN-END:variables
}
