package frmArea;

import Conexion.Conexion;
import java.awt.Toolkit;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author pc
 */
public class mdl_rangoEdad extends javax.swing.JDialog {

    private int edadInicio;
    private int edadFin;
    
    public mdl_rangoEdad(){}
    
    
    
    public mdl_rangoEdad(java.awt.Frame parent, boolean modal) {
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlRangoEdad = new javax.swing.JPanel();
        lblRangoPorEdad = new javax.swing.JLabel();
        lblEdadInicial = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtEdadFinal = new javax.swing.JTextField();
        txtEdadInicial = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reporte rango por edad");
        setMaximumSize(new java.awt.Dimension(492, 266));
        setMinimumSize(new java.awt.Dimension(492, 266));
        setPreferredSize(new java.awt.Dimension(492, 266));
        getContentPane().setLayout(null);

        pnlRangoEdad.setLayout(null);

        lblRangoPorEdad.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblRangoPorEdad.setText("Reporte por rango por edad");
        pnlRangoEdad.add(lblRangoPorEdad);
        lblRangoPorEdad.setBounds(60, 20, 380, 29);

        lblEdadInicial.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblEdadInicial.setText("Edad Incial:");
        pnlRangoEdad.add(lblEdadInicial);
        lblEdadInicial.setBounds(54, 88, 110, 19);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Edad Final:");
        pnlRangoEdad.add(jLabel1);
        jLabel1.setBounds(58, 130, 110, 19);

        txtEdadFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEdadFinalKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEdadFinalKeyTyped(evt);
            }
        });
        pnlRangoEdad.add(txtEdadFinal);
        txtEdadFinal.setBounds(166, 126, 270, 24);

        txtEdadInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdadInicialActionPerformed(evt);
            }
        });
        txtEdadInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEdadInicialKeyTyped(evt);
            }
        });
        pnlRangoEdad.add(txtEdadInicial);
        txtEdadInicial.setBounds(166, 84, 270, 24);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/reportes.png"))); // NOI18N
        jButton1.setText("Generar reporte");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnlRangoEdad.add(jButton1);
        jButton1.setBounds(180, 180, 157, 40);

        getContentPane().add(pnlRangoEdad);
        pnlRangoEdad.setBounds(0, 0, 500, 280);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEdadInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdadInicialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadInicialActionPerformed

    private void txtEdadInicialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdadInicialKeyTyped
        char c = evt.getKeyChar();        
        if (c< '0'|| c>'9') evt.consume();
    }//GEN-LAST:event_txtEdadInicialKeyTyped

    private void txtEdadFinalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdadFinalKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadFinalKeyReleased

    private void txtEdadFinalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdadFinalKeyTyped
        char c = evt.getKeyChar();        
        if (c< '0'|| c>'9') evt.consume();
    }//GEN-LAST:event_txtEdadFinalKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     
        Conexion con= new Conexion();

        
        int edadInicial = Integer.parseInt(getTxtEdadInicial().getText());
        int edadFinal = Integer.parseInt(getTxtEdadFinal().getText());
        
        JOptionPane.showMessageDialog(null, edadInicial +" de " +edadFinal);
            Map parametros = new HashMap();
            parametros.clear();
            parametros.put("EdadInicial", edadInicial);
            parametros.put("EdadFinal", edadFinal);
  
        try{
            con.getConexion();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(),
                    "Error de conexion", JOptionPane.ERROR_MESSAGE);
        }
     
        //JOptionPane.showMessageDialog(null, edadInicial +" de " +edadFinal);
        
        parametros.put("EdadInicial", edadInicial);
        parametros.put("EdadFinal", edadFinal);
        
        
        URL archivo = this.getClass().getResource("/reportes/report_cliente_x_rango_edad.jasper");
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(archivo);
            JasperPrint jp = JasperFillManager.fillReport(jr,null, Conexion.getConexion());
            JasperViewer jv = new JasperViewer(jp, false);
            JDialog dialog = new JDialog(this);
            dialog.setContentPane(jv.getContentPane());
            dialog.setSize(jv.getSize());
            dialog.setTitle("Visor de Reporte Farmacia Regis - Las Casitas");
            dialog.setIconImage(Toolkit.getDefaultToolkit().getImage(
            getClass().getResource("../imgSP/icono.png")));
            dialog.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(mdl_rangoEdad.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(mdl_rangoEdad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mdl_rangoEdad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mdl_rangoEdad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mdl_rangoEdad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                mdl_rangoEdad dialog = new mdl_rangoEdad(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblEdadInicial;
    private javax.swing.JLabel lblRangoPorEdad;
    private javax.swing.JPanel pnlRangoEdad;
    private javax.swing.JTextField txtEdadFinal;
    private javax.swing.JTextField txtEdadInicial;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the txtEdadFinal
     */
    public javax.swing.JTextField getTxtEdadFinal() {
        return txtEdadFinal;
    }

    /**
     * @param txtEdadFinal the txtEdadFinal to set
     */
    public void setTxtEdadFinal(javax.swing.JTextField txtEdadFinal) {
        this.txtEdadFinal = txtEdadFinal;
    }

    /**
     * @return the txtEdadInicial
     */
    public javax.swing.JTextField getTxtEdadInicial() {
        return txtEdadInicial;
    }

    /**
     * @param txtEdadInicial the txtEdadInicial to set
     */
    public void setTxtEdadInicial(javax.swing.JTextField txtEdadInicial) {
        this.txtEdadInicial = txtEdadInicial;
    }

    /**
     * @return the edadInicio
     */
    public int getEdadInicio() {
        return edadInicio;
    }

    /**
     * @param edadInicio the edadInicio to set
     */
    public void setEdadInicio(int edadInicio) {
        this.edadInicio = edadInicio;
    }

    /**
     * @return the edadFin
     */
    public int getEdadFin() {
        return edadFin;
    }

    /**
     * @param edadFin the edadFin to set
     */
    public void setEdadFin(int edadFin) {
        this.edadFin = edadFin;
    }
}