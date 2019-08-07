/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frmArea;

/**
 *
 * @author pc
 */
public class frmCanjeoPuntos extends javax.swing.JFrame {

    /**
     * Creates new form frmCanjeoPuntos
     */
    public frmCanjeoPuntos() {
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

        lblCanjeoPuntos = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        lblPuntosCanjear = new javax.swing.JLabel();
        txtPuntosCanjear = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btn_RegresarAlMenuPrincipal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Canjeo de Puntos");
        setMaximumSize(new java.awt.Dimension(446, 323));
        setMinimumSize(new java.awt.Dimension(446, 323));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(446, 323));
        getContentPane().setLayout(null);

        lblCanjeoPuntos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCanjeoPuntos.setText("Canjeo de Puntos");
        getContentPane().add(lblCanjeoPuntos);
        lblCanjeoPuntos.setBounds(140, 30, 150, 38);

        lblCliente.setText("Cliente:");
        getContentPane().add(lblCliente);
        lblCliente.setBounds(58, 112, 37, 14);
        getContentPane().add(txtCliente);
        txtCliente.setBounds(99, 109, 252, 20);

        lblPuntosCanjear.setText("Puntos a canjear:");
        getContentPane().add(lblPuntosCanjear);
        lblPuntosCanjear.setBounds(60, 170, 85, 14);

        txtPuntosCanjear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPuntosCanjearActionPerformed(evt);
            }
        });
        getContentPane().add(txtPuntosCanjear);
        txtPuntosCanjear.setBounds(150, 160, 72, 34);

        btnAceptar.setText("Aceptar");
        getContentPane().add(btnAceptar);
        btnAceptar.setBounds(60, 244, 71, 23);

        btnCancelar.setText("Cancelar");
        getContentPane().add(btnCancelar);
        btnCancelar.setBounds(171, 244, 75, 23);

        btn_RegresarAlMenuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgenesProyecto/VolverMenu.png"))); // NOI18N
        btn_RegresarAlMenuPrincipal.setText("Regresar");
        btn_RegresarAlMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegresarAlMenuPrincipalActionPerformed(evt);
            }
        });
        getContentPane().add(btn_RegresarAlMenuPrincipal);
        btn_RegresarAlMenuPrincipal.setBounds(264, 225, 150, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPuntosCanjearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPuntosCanjearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPuntosCanjearActionPerformed

    private void btn_RegresarAlMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegresarAlMenuPrincipalActionPerformed
        frmMenuPrincipal ver=new frmMenuPrincipal();
        ver.setVisible(true); // visible ventana del objeto
        this.setVisible(false); // ocultar

    }//GEN-LAST:event_btn_RegresarAlMenuPrincipalActionPerformed

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
            java.util.logging.Logger.getLogger(frmCanjeoPuntos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCanjeoPuntos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCanjeoPuntos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCanjeoPuntos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCanjeoPuntos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btn_RegresarAlMenuPrincipal;
    private javax.swing.JLabel lblCanjeoPuntos;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblPuntosCanjear;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtPuntosCanjear;
    // End of variables declaration//GEN-END:variables
}
