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
public class frmSubMenuPuntos extends javax.swing.JFrame {

    /**
     * Creates new form frmSubMenuPuntos
     */
    public frmSubMenuPuntos() {
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

        panel_gestionPuntos = new javax.swing.JPanel();
        btn_RegresarAlMenuPrincipal = new javax.swing.JButton();
        btn_asignarPuntos = new javax.swing.JButton();
        btn_canjearPuntos = new javax.swing.JButton();
        jl_TituloPrincipal = new javax.swing.JLabel();
        barraMenu = new javax.swing.JMenuBar();
        menu_InicioSistema = new javax.swing.JMenu();
        menu_Cliente = new javax.swing.JMenu();
        menu_Puntos = new javax.swing.JMenu();
        menu_Reportes = new javax.swing.JMenu();
        menu_ayuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú Puntos");
        setMaximumSize(new java.awt.Dimension(680, 419));
        setMinimumSize(new java.awt.Dimension(680, 419));
        setName("Menú Puntos"); // NOI18N
        setPreferredSize(new java.awt.Dimension(680, 419));
        getContentPane().setLayout(null);

        panel_gestionPuntos.setLayout(null);

        btn_RegresarAlMenuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/volverMenu.png"))); // NOI18N
        btn_RegresarAlMenuPrincipal.setText("Regresar");
        btn_RegresarAlMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegresarAlMenuPrincipalActionPerformed(evt);
            }
        });
        panel_gestionPuntos.add(btn_RegresarAlMenuPrincipal);
        btn_RegresarAlMenuPrincipal.setBounds(220, 250, 170, 50);

        btn_asignarPuntos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/asignar.png"))); // NOI18N
        btn_asignarPuntos.setText("Asignar Puntos");
        btn_asignarPuntos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_asignarPuntosActionPerformed(evt);
            }
        });
        panel_gestionPuntos.add(btn_asignarPuntos);
        btn_asignarPuntos.setBounds(60, 120, 170, 50);

        btn_canjearPuntos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/gestion_de_puntos.png"))); // NOI18N
        btn_canjearPuntos.setText("Canjear Puntos");
        btn_canjearPuntos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_canjearPuntosActionPerformed(evt);
            }
        });
        panel_gestionPuntos.add(btn_canjearPuntos);
        btn_canjearPuntos.setBounds(390, 120, 160, 50);

        jl_TituloPrincipal.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jl_TituloPrincipal.setText("Menú Puntos");
        panel_gestionPuntos.add(jl_TituloPrincipal);
        jl_TituloPrincipal.setBounds(210, 20, 310, 29);

        getContentPane().add(panel_gestionPuntos);
        panel_gestionPuntos.setBounds(30, 30, 630, 330);

        menu_InicioSistema.setText("Inicio del Sistema ");
        barraMenu.add(menu_InicioSistema);

        menu_Cliente.setText("Clientes");
        barraMenu.add(menu_Cliente);

        menu_Puntos.setText("Puntos");
        barraMenu.add(menu_Puntos);

        menu_Reportes.setText("Reportes");
        barraMenu.add(menu_Reportes);

        menu_ayuda.setText("Ayuda");
        barraMenu.add(menu_ayuda);

        setJMenuBar(barraMenu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_RegresarAlMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegresarAlMenuPrincipalActionPerformed
        frmMenuPrincipal ver=new frmMenuPrincipal();
        ver.setVisible(true); // visible ventana del objeto
        this.setVisible(false); // ocultar
    }//GEN-LAST:event_btn_RegresarAlMenuPrincipalActionPerformed

    private void btn_asignarPuntosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_asignarPuntosActionPerformed
        frmAsignacionPuntos ver1=new frmAsignacionPuntos();
        ver1.setVisible(true); // visible ventana del objeto
        this.setVisible(false); // ocultar

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_asignarPuntosActionPerformed

    private void btn_canjearPuntosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_canjearPuntosActionPerformed
        frmCanjeoPuntos ver2=new frmCanjeoPuntos();
        ver2.setVisible(true); // visible ventana del objeto
        this.setVisible(false); // ocultar
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_canjearPuntosActionPerformed

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
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton btn_RegresarAlMenuPrincipal;
    private javax.swing.JButton btn_asignarPuntos;
    private javax.swing.JButton btn_canjearPuntos;
    private javax.swing.JLabel jl_TituloPrincipal;
    private javax.swing.JMenu menu_Cliente;
    private javax.swing.JMenu menu_InicioSistema;
    private javax.swing.JMenu menu_Puntos;
    private javax.swing.JMenu menu_Reportes;
    private javax.swing.JMenu menu_ayuda;
    private javax.swing.JPanel panel_gestionPuntos;
    // End of variables declaration//GEN-END:variables
}
