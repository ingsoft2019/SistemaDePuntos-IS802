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
public class mdl_tamano_papel extends java.awt.Dialog {

    /**
     * Creates new form mdl_tamano_papel
     */
    public mdl_tamano_papel(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
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
        txt_ancho_papel = new javax.swing.JTextField();
        txt_largo_papel = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btn_cambiar = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(656, 353));
        setMinimumSize(new java.awt.Dimension(656, 353));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });
        setLayout(null);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Tamaño de papel para impresión");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(100, 40, 430, 40);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Ancho ");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 130, 70, 19);
        jPanel1.add(txt_ancho_papel);
        txt_ancho_papel.setBounds(120, 130, 120, 24);
        jPanel1.add(txt_largo_papel);
        txt_largo_papel.setBounds(420, 130, 130, 24);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Largo");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(370, 130, 50, 20);

        btn_cambiar.setText("Cambiar");
        jPanel1.add(btn_cambiar);
        btn_cambiar.setBounds(240, 230, 160, 60);

        add(jPanel1);
        jPanel1.setBounds(0, 0, 660, 360);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                mdl_tamano_papel dialog = new mdl_tamano_papel(new java.awt.Frame(), true);
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
    private javax.swing.JButton btn_cambiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txt_ancho_papel;
    private javax.swing.JTextField txt_largo_papel;
    // End of variables declaration//GEN-END:variables
}