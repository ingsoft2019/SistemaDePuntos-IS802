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
public class frmSubMenuPuntos extends javax.swing.JFrame {

    /**
     * Creates new form frmSubMenuPuntos
     */
    public frmSubMenuPuntos() {
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

        jPanel1 = new javax.swing.JPanel();
        btn_RegresarAlMenuPrincipal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu de puntos");
        setMaximumSize(new java.awt.Dimension(680, 528));
        setMinimumSize(new java.awt.Dimension(680, 528));
        setName("Menu Puntos"); // NOI18N
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(680, 528));
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        btn_RegresarAlMenuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgenesProyecto/VolverMenu.png"))); // NOI18N
        btn_RegresarAlMenuPrincipal.setText("Regresar");
        btn_RegresarAlMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegresarAlMenuPrincipalActionPerformed(evt);
            }
        });
        jPanel1.add(btn_RegresarAlMenuPrincipal);
        btn_RegresarAlMenuPrincipal.setBounds(410, 360, 166, 67);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 40, 630, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(frmSubMenuPuntos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmSubMenuPuntos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmSubMenuPuntos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmSubMenuPuntos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmSubMenuPuntos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_RegresarAlMenuPrincipal;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
