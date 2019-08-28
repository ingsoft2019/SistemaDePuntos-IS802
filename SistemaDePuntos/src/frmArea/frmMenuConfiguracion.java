/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frmArea;

import javax.swing.ImageIcon;

/**
 *
 * @author Luis Estrada
 */
public class frmMenuConfiguracion extends javax.swing.JFrame {

    /**
     * Creates new form frmConfiguracion
     */
    public frmMenuConfiguracion() {
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_busqueda = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configuración del Sistema de Puntos");
        setMaximumSize(new java.awt.Dimension(680, 528));
        setMinimumSize(new java.awt.Dimension(680, 528));
        setPreferredSize(new java.awt.Dimension(680, 528));
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Busqueda");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 30, 100, 30);
        jPanel1.add(txt_busqueda);
        txt_busqueda.setBounds(120, 30, 267, 30);

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/buscar.png"))); // NOI18N
        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_buscar);
        btn_buscar.setBounds(420, 20, 140, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(40, 80, 600, 80);

        jPanel2.setLayout(null);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/rifa.png"))); // NOI18N
        jButton2.setText("Realizar Rifa");
        jPanel2.add(jButton2);
        jButton2.setBounds(190, 40, 190, 60);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/limpiar.png"))); // NOI18N
        jButton5.setText("Reinicio de Puntos");
        jPanel2.add(jButton5);
        jButton5.setBounds(190, 120, 190, 60);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(40, 160, 600, 280);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Conguración del Sistema");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(210, 20, 310, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_buscarActionPerformed

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
            java.util.logging.Logger.getLogger(frmMenuConfiguracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMenuConfiguracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMenuConfiguracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMenuConfiguracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMenuConfiguracion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txt_busqueda;
    // End of variables declaration//GEN-END:variables
}
