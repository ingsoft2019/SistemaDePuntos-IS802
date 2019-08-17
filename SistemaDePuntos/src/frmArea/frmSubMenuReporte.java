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
public class frmSubMenuReporte extends javax.swing.JFrame {

    /**
     * Creates new form frmSubMenuReporte
     */
    public frmSubMenuReporte() {
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

        jMenuItem1 = new javax.swing.JMenuItem();
        jpanel_reporte = new javax.swing.JPanel();
        btn_RegresarAlMenuPrincipal = new javax.swing.JButton();
        btn_cliente = new javax.swing.JButton();
        brn_puntos = new javax.swing.JButton();
        btn_graficas = new javax.swing.JButton();
        jl_TituloPrincipal = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Menu Reportes");
        setMaximumSize(new java.awt.Dimension(680, 461));
        setMinimumSize(new java.awt.Dimension(680, 461));
        setName("Menu Reporte"); // NOI18N
        setPreferredSize(new java.awt.Dimension(680, 461));
        getContentPane().setLayout(null);

        jpanel_reporte.setMinimumSize(new java.awt.Dimension(680, 530));
        jpanel_reporte.setPreferredSize(new java.awt.Dimension(680, 530));
        jpanel_reporte.setLayout(null);

        btn_RegresarAlMenuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/volverMenu.png"))); // NOI18N
        btn_RegresarAlMenuPrincipal.setText("Regresar");
        btn_RegresarAlMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegresarAlMenuPrincipalActionPerformed(evt);
            }
        });
        jpanel_reporte.add(btn_RegresarAlMenuPrincipal);
        btn_RegresarAlMenuPrincipal.setBounds(220, 270, 150, 50);

        btn_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/cliente.png"))); // NOI18N
        btn_cliente.setText("Clientes");
        jpanel_reporte.add(btn_cliente);
        btn_cliente.setBounds(40, 90, 130, 60);

        brn_puntos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/estadistica puntos.png"))); // NOI18N
        brn_puntos.setText("Puntos");
        jpanel_reporte.add(brn_puntos);
        brn_puntos.setBounds(220, 90, 150, 60);

        btn_graficas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/grafica.png"))); // NOI18N
        btn_graficas.setText("Graficas");
        jpanel_reporte.add(btn_graficas);
        btn_graficas.setBounds(420, 90, 130, 60);

        jl_TituloPrincipal.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jl_TituloPrincipal.setText("Menú de Reportes");
        jpanel_reporte.add(jl_TituloPrincipal);
        jl_TituloPrincipal.setBounds(180, 20, 230, 30);

        getContentPane().add(jpanel_reporte);
        jpanel_reporte.setBounds(40, 40, 580, 360);

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
            java.util.logging.Logger.getLogger(frmSubMenuReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmSubMenuReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmSubMenuReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmSubMenuReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmSubMenuReporte().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brn_puntos;
    private javax.swing.JButton btn_RegresarAlMenuPrincipal;
    private javax.swing.JButton btn_cliente;
    private javax.swing.JButton btn_graficas;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel jl_TituloPrincipal;
    private javax.swing.JPanel jpanel_reporte;
    // End of variables declaration//GEN-END:variables
}
