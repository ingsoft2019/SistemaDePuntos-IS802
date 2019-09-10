/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frmArea;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class mdl_NuevaZona extends java.awt.Dialog {

    /**
     * Creates new form mdl_NuevaZona
     */
    ResultSet res = null;
    int cont = 0;
    
    public mdl_NuevaZona(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);// Para que el formulario aparezca en el centro de la pantala
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
        JL_zona = new javax.swing.JLabel();
        txt_nuevaZona = new javax.swing.JTextField();
        btn_guardarZona = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(601, 85));
        setMinimumSize(new java.awt.Dimension(601, 85));
        setTitle("Agregar Nueva Zona");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });
        setLayout(null);

        jPanel1.setLayout(null);

        JL_zona.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        JL_zona.setText("Zona:");
        JL_zona.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        JL_zona.setMaximumSize(new java.awt.Dimension(40, 240));
        JL_zona.setMinimumSize(new java.awt.Dimension(40, 240));
        jPanel1.add(JL_zona);
        JL_zona.setBounds(10, 40, 90, 30);

        txt_nuevaZona.setMaximumSize(new java.awt.Dimension(330, 24));
        txt_nuevaZona.setMinimumSize(new java.awt.Dimension(330, 24));
        txt_nuevaZona.setPreferredSize(new java.awt.Dimension(330, 24));
        jPanel1.add(txt_nuevaZona);
        txt_nuevaZona.setBounds(100, 40, 320, 30);

        btn_guardarZona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/guardar.png"))); // NOI18N
        btn_guardarZona.setText("Guardar");
        btn_guardarZona.setMaximumSize(new java.awt.Dimension(160, 40));
        btn_guardarZona.setMinimumSize(new java.awt.Dimension(160, 40));
        btn_guardarZona.setPreferredSize(new java.awt.Dimension(160, 40));
        btn_guardarZona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_guardarZonaMouseClicked(evt);
            }
        });
        btn_guardarZona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarZonaActionPerformed(evt);
            }
        });
        jPanel1.add(btn_guardarZona);
        btn_guardarZona.setBounds(450, 30, 140, 45);

        add(jPanel1);
        jPanel1.setBounds(0, 0, 610, 90);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void btn_guardarZonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_guardarZonaMouseClicked

    }//GEN-LAST:event_btn_guardarZonaMouseClicked

    private void btn_guardarZonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarZonaActionPerformed
        if (txt_nuevaZona.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo está vacio", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try { //Esta consulta es para validar que no se inserte un registro duplicado
                res = Conexion.Conexion.consulta("SELECT COUNT(zona) from Zona WHERE zona='" + txt_nuevaZona.getText() + "'");
                try {
                    while (res.next()) {
                        cont = res.getInt(1);
                    }
                } catch (SQLException e) {
                }
                if (cont > 0) {
                    JOptionPane.showMessageDialog(this, "Esta zona ya existe", "Informacion", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    Procedimientos.ProcedimientosCliente.guardarZona(txt_nuevaZona.getText());
                    new frmRegistroClientes().actulizarZonas();
                    //                    JOptionPane.showMessageDialog(this, "Zona agregada");

                    dispose();//Para cerrar el formulario al agregar la zona
                }
            } catch (SQLException e) {
            }
        }
    }//GEN-LAST:event_btn_guardarZonaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                mdl_NuevaZona dialog = new mdl_NuevaZona(new java.awt.Frame(), true);
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
    private javax.swing.JLabel JL_zona;
    private javax.swing.JButton btn_guardarZona;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txt_nuevaZona;
    // End of variables declaration//GEN-END:variables
}
