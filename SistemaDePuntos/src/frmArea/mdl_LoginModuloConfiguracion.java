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
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class mdl_LoginModuloConfiguracion extends java.awt.Dialog {

    /**
     * Creates new form mdl_LoginModuloConfiguracion
     */
    public mdl_LoginModuloConfiguracion(java.awt.Frame parent, boolean modal) {
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

        panel_login = new java.awt.Panel();
        jl_Usuario = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        jl_contrasena = new javax.swing.JLabel();
        btn_ingresarLogin = new javax.swing.JButton();
        btn_recuperar = new javax.swing.JButton();
        txt_contrasena = new javax.swing.JPasswordField();

        setMaximumSize(new java.awt.Dimension(480, 192));
        setMinimumSize(new java.awt.Dimension(480, 192));
        setTitle("Login Modulo Configuración");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });
        setLayout(null);

        panel_login.setLayout(null);

        jl_Usuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jl_Usuario.setText("Usuario");
        jl_Usuario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel_login.add(jl_Usuario);
        jl_Usuario.setBounds(20, 50, 100, 30);

        txt_usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_usuarioKeyPressed(evt);
            }
        });
        panel_login.add(txt_usuario);
        txt_usuario.setBounds(120, 50, 312, 30);

        jl_contrasena.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jl_contrasena.setText("Contraseña");
        jl_contrasena.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel_login.add(jl_contrasena);
        jl_contrasena.setBounds(20, 100, 100, 30);

        btn_ingresarLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/ingresar.png"))); // NOI18N
        btn_ingresarLogin.setText("Ingresar");
        btn_ingresarLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ingresarLoginActionPerformed(evt);
            }
        });
        panel_login.add(btn_ingresarLogin);
        btn_ingresarLogin.setBounds(30, 140, 190, 40);

        btn_recuperar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/pass-contrasena.png"))); // NOI18N
        btn_recuperar.setText("Recuperar");
        panel_login.add(btn_recuperar);
        btn_recuperar.setBounds(240, 140, 190, 40);

        txt_contrasena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_contrasenaKeyPressed(evt);
            }
        });
        panel_login.add(txt_contrasena);
        txt_contrasena.setBounds(122, 100, 310, 30);

        add(panel_login);
        panel_login.setBounds(0, 0, 480, 200);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void txt_usuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usuarioKeyPressed

        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            getTxt_usuario().requestFocus();
            getTxt_contrasena().setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_txt_usuarioKeyPressed

    private void btn_ingresarLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ingresarLoginActionPerformed
        // TODO add your handling code here:
        String usuario= "root";
        String contrasena= "asd.456";

        String pass= new String(getTxt_contrasena().getPassword());
        String user= new String(getTxt_usuario().getText());

        if (user.equals(usuario) && pass.equals(contrasena)){
            this.setVisible(false); // ocultar
            frmMenuPrincipal frmMenuPrincipal = new frmMenuPrincipal();
            mdl_MenuConfiguracion ver=new mdl_MenuConfiguracion(frmMenuPrincipal,true);
            ver.setVisible(true); // visible ventana del objeto
            
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrecta.  ");
            getTxt_contrasena().setText("");
        }

    }//GEN-LAST:event_btn_ingresarLoginActionPerformed

    private void txt_contrasenaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contrasenaKeyPressed

        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            getTxt_contrasena().requestFocus();
            btn_ingresarLogin.setBackground(Color.WHITE);
        }

    }//GEN-LAST:event_txt_contrasenaKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                mdl_LoginModuloConfiguracion dialog = new mdl_LoginModuloConfiguracion(new java.awt.Frame(), true);
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
    private javax.swing.JButton btn_ingresarLogin;
    private javax.swing.JButton btn_recuperar;
    private javax.swing.JLabel jl_Usuario;
    private javax.swing.JLabel jl_contrasena;
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