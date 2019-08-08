/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frmArea;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Estrada
 */
public class frmLoginModuloConfiguracion extends javax.swing.JFrame {

    /**
     * Creates new form frmLogin
     */
    public frmLoginModuloConfiguracion() {
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

        panel_login = new java.awt.Panel();
        jl_Usuario = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        jl_contrasena = new javax.swing.JLabel();
        btn_ingresarLogin = new javax.swing.JButton();
        btn_recuperar = new javax.swing.JButton();
        btn_RegresarAlMenuPrincipal = new javax.swing.JButton();
        txt_contrasena = new javax.swing.JPasswordField();
        jl_iconoPersonas = new javax.swing.JLabel();
        jl_fondoLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Configuracion de Sistema De Puntos");
        setMinimumSize(new java.awt.Dimension(488, 541));
        setName("Loguin del Sistema de Puntos"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(null);

        panel_login.setLayout(null);

        jl_Usuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jl_Usuario.setText("Usuario");
        panel_login.add(jl_Usuario);
        jl_Usuario.setBounds(17, 17, 45, 17);

        txt_usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_usuarioKeyPressed(evt);
            }
        });
        panel_login.add(txt_usuario);
        txt_usuario.setBounds(115, 17, 312, 20);

        jl_contrasena.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jl_contrasena.setText("Contraseña");
        panel_login.add(jl_contrasena);
        jl_contrasena.setBounds(17, 69, 70, 17);

        btn_ingresarLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/ingresar.png"))); // NOI18N
        btn_ingresarLogin.setText("Ingresar");
        btn_ingresarLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ingresarLoginActionPerformed(evt);
            }
        });
        panel_login.add(btn_ingresarLogin);
        btn_ingresarLogin.setBounds(17, 123, 130, 41);

        btn_recuperar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/pass-contrasena.png"))); // NOI18N
        btn_recuperar.setText("Recuperar");
        panel_login.add(btn_recuperar);
        btn_recuperar.setBounds(150, 120, 119, 41);

        btn_RegresarAlMenuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/volverMenu.png"))); // NOI18N
        btn_RegresarAlMenuPrincipal.setText("Regresar");
        btn_RegresarAlMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegresarAlMenuPrincipalActionPerformed(evt);
            }
        });
        panel_login.add(btn_RegresarAlMenuPrincipal);
        btn_RegresarAlMenuPrincipal.setBounds(290, 120, 150, 40);

        txt_contrasena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_contrasenaKeyPressed(evt);
            }
        });
        panel_login.add(txt_contrasena);
        txt_contrasena.setBounds(115, 66, 312, 20);

        getContentPane().add(panel_login);
        panel_login.setBounds(20, 330, 450, 180);

        jl_iconoPersonas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/login-Usuario.png"))); // NOI18N
        getContentPane().add(jl_iconoPersonas);
        jl_iconoPersonas.setBounds(120, 40, 260, 240);

        jl_fondoLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/fondo_login.jpg"))); // NOI18N
        jl_fondoLogin.setMaximumSize(new java.awt.Dimension(488, 541));
        jl_fondoLogin.setMinimumSize(new java.awt.Dimension(488, 541));
        jl_fondoLogin.setPreferredSize(new java.awt.Dimension(488, 541));
        getContentPane().add(jl_fondoLogin);
        jl_fondoLogin.setBounds(0, -30, 490, 570);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_RegresarAlMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegresarAlMenuPrincipalActionPerformed
          frmMenuPrincipal ver=new frmMenuPrincipal();
            ver.setVisible(true); // visible ventana del objeto
            this.setVisible(false); // ocultar
       
    }//GEN-LAST:event_btn_RegresarAlMenuPrincipalActionPerformed

    private void btn_ingresarLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ingresarLoginActionPerformed
        // TODO add your handling code here:
         String usuario= "is802";
        String contrasena= "asd.456";
        
        String pass= new String(getTxt_contrasena().getPassword());
        String user= new String(getTxt_usuario().getText());
        
        if (user.equals(usuario) && pass.equals(contrasena)){
            frmMenuPrincipal ver=new frmMenuPrincipal();
            ver.setVisible(true); // visible ventana del objeto
            this.setVisible(false); // ocultar
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrecta.  ");
            txt_contrasena.setText("");
        }
        
        
    }//GEN-LAST:event_btn_ingresarLoginActionPerformed

    private void txt_usuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usuarioKeyPressed

        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
           txt_usuario.requestFocus();
           txt_contrasena.setBackground(Color.WHITE);
        } 
    }//GEN-LAST:event_txt_usuarioKeyPressed

    private void txt_contrasenaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contrasenaKeyPressed

        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
           txt_contrasena.requestFocus();
           btn_ingresarLogin.setBackground(Color.WHITE);
        } 
        
    }//GEN-LAST:event_txt_contrasenaKeyPressed

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
            java.util.logging.Logger.getLogger(frmLoginModuloConfiguracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLoginModuloConfiguracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLoginModuloConfiguracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLoginModuloConfiguracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLoginModuloConfiguracion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_RegresarAlMenuPrincipal;
    private javax.swing.JButton btn_ingresarLogin;
    private javax.swing.JButton btn_recuperar;
    private javax.swing.JLabel jl_Usuario;
    private javax.swing.JLabel jl_contrasena;
    private javax.swing.JLabel jl_fondoLogin;
    private javax.swing.JLabel jl_iconoPersonas;
    private java.awt.Panel panel_login;
    private javax.swing.JPasswordField txt_contrasena;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the txt_contrasena
     */
    public javax.swing.JPasswordField getTxt_contrasena() {
        return txt_contrasena;
    }

    /**
     * @param txt_contrasena the txt_contrasena to set
     */
    public void setTxt_contrasena(javax.swing.JPasswordField txt_contrasena) {
        this.txt_contrasena = txt_contrasena;
    }

    /**
     * @return the txt_usuario
     */
    public javax.swing.JTextField getTxt_usuario() {
        return txt_usuario;
    }

    /**
     * @param txt_usuario the txt_usuario to set
     */
    public void setTxt_usuario(javax.swing.JTextField txt_usuario) {
        this.txt_usuario = txt_usuario;
    }
}

