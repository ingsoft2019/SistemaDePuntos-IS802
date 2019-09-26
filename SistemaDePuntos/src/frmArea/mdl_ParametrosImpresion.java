/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frmArea;

import static Conexion.Conexion.consulta;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pc
 */
public class mdl_ParametrosImpresion extends javax.swing.JDialog {

    /**
     * Creates new form mdl_parametrosImpresion
     */
    public mdl_ParametrosImpresion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null); //para ponerse en el centro
        this.setResizable(false); //Desactivar botón maximizar de una ventana
        setIconImage(new ImageIcon(getClass().getResource("../imgSP/icono.png")).getImage()); //cambia el icono del formulario
        
        lblMensaje.setVisible(false);
        cargarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlParametrosImpresion = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblParametros = new javax.swing.JTable();
        lblMensaje = new javax.swing.JLabel();
        btnAgregarParametros = new javax.swing.JButton();
        btnEditarParametros = new javax.swing.JButton();
        btnEliminarParametros = new javax.swing.JButton();
        btnActivarParametros = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblParametros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Altura (mm)", "Anchura (mm)", "Estado", "id"
            }
        ));
        jScrollPane1.setViewportView(tblParametros);

        lblMensaje.setText("No hay parametros de impresion para el tamaño de hoja.");

        btnAgregarParametros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/agregar.png"))); // NOI18N
        btnAgregarParametros.setText("Agregar");
        btnAgregarParametros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarParametrosActionPerformed(evt);
            }
        });

        btnEditarParametros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/modificar.png"))); // NOI18N
        btnEditarParametros.setText("Editar");
        btnEditarParametros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarParametrosActionPerformed(evt);
            }
        });

        btnEliminarParametros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/deshabilitar.png"))); // NOI18N
        btnEliminarParametros.setText("Eliminar");
        btnEliminarParametros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarParametrosActionPerformed(evt);
            }
        });

        btnActivarParametros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/asignar.png"))); // NOI18N
        btnActivarParametros.setText("Activar");
        btnActivarParametros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivarParametrosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlParametrosImpresionLayout = new javax.swing.GroupLayout(pnlParametrosImpresion);
        pnlParametrosImpresion.setLayout(pnlParametrosImpresionLayout);
        pnlParametrosImpresionLayout.setHorizontalGroup(
            pnlParametrosImpresionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlParametrosImpresionLayout.createSequentialGroup()
                .addGroup(pnlParametrosImpresionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlParametrosImpresionLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(192, 192, 192))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlParametrosImpresionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(pnlParametrosImpresionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEliminarParametros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregarParametros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnActivarParametros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditarParametros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 11, Short.MAX_VALUE))
        );
        pnlParametrosImpresionLayout.setVerticalGroup(
            pnlParametrosImpresionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlParametrosImpresionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlParametrosImpresionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlParametrosImpresionLayout.createSequentialGroup()
                        .addComponent(btnActivarParametros)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregarParametros)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditarParametros)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarParametros)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlParametrosImpresionLayout.createSequentialGroup()
                        .addComponent(lblMensaje)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(pnlParametrosImpresion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlParametrosImpresion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarParametrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarParametrosActionPerformed
        // TODO add your handling code here:
        frmMenuPrincipal frmMenuPrincipal =  new frmMenuPrincipal();
        mdl_TamanoPapel  ver=new mdl_TamanoPapel(frmMenuPrincipal,true);
        ver.setVisible(true); // visible ventana del objeto

    }//GEN-LAST:event_btnAgregarParametrosActionPerformed

    private void btnEditarParametrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarParametrosActionPerformed
        try {
            int row = tblParametros.getSelectedRow();
            int idParametros = (int)tblParametros.getValueAt(row, 3);

            ResultSet res = consulta("SELECT * FROM Parametro_Impresion\n" +
                                     "WHERE id_parametro_impresion = '" + idParametros + "'; ");

            frmMenuPrincipal menuprin = new frmMenuPrincipal();
            mdl_TamanoPapel tamanoPapel = new mdl_TamanoPapel(menuprin, true);

            try {
                while (res.next()) {
                    
                    tamanoPapel.recibirId(idParametros);
                    tamanoPapel.setVisible(true);
                }

            } catch (SQLException e) {

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione un registro");

        }

        /*frmMenuPrincipal frmMenuPrincipal = new frmMenuPrincipal();
        mdl_CanjeoPuntos canjear = new mdl_CanjeoPuntos(frmMenuPrincipal, true);
        canjear.setVisible(true); // visible ventana del objeto*/
    }//GEN-LAST:event_btnEditarParametrosActionPerformed

    private void btnEliminarParametrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarParametrosActionPerformed
        try {
            int row = tblParametros.getSelectedRow();
            int idParametros = (int)tblParametros.getValueAt(row, 3);
            
            Procedimientos.ProcedimientosParametrosImpresion.eliminarParametros(idParametros);
            cargarTabla();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione un registro: ");

        }
    }//GEN-LAST:event_btnEliminarParametrosActionPerformed

    private void btnActivarParametrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivarParametrosActionPerformed
        try {
            int row = tblParametros.getSelectedRow();
            int idParametros = (int)tblParametros.getValueAt(row, 3);
            
            Procedimientos.ProcedimientosParametrosImpresion.activarParametro(idParametros);
            cargarTabla();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione un registro: ");

        }
    }//GEN-LAST:event_btnActivarParametrosActionPerformed

    public void cargarTabla(){
        int contador= 0;
        DefaultTableModel modelo = (DefaultTableModel) tblParametros.getModel();
        modelo.setRowCount(0);
        ResultSet respuesta = Conexion.Conexion.consulta("SELECT altura, anchura, estado, id_parametro_impresion FROM Parametro_Impresion");
        try{
            while (respuesta.next()){
                Vector v  = new Vector();
                v.add(respuesta.getDouble(1));
                v.add(respuesta.getDouble(2));
                v.add(respuesta.getString(3));
                v.add(respuesta.getInt(4));
                
                modelo.addRow(v);
                tblParametros.setModel(modelo);
                contador+=1;
            }
            if(contador==0){
                //JOptionPane.showMessageDialog(null, "No hay parametros de imp con puntos vencidos");
                lblMensaje.setVisible(true);
                lblMensaje.setForeground(Color.RED);
            }
            //System.out.println(contador);
        
        }catch(SQLException e){
            System.out.println(e);
        }
    
    }
    
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
            java.util.logging.Logger.getLogger(mdl_ParametrosImpresion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mdl_ParametrosImpresion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mdl_ParametrosImpresion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mdl_ParametrosImpresion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                mdl_ParametrosImpresion dialog = new mdl_ParametrosImpresion(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnActivarParametros;
    private javax.swing.JButton btnAgregarParametros;
    private javax.swing.JButton btnEditarParametros;
    private javax.swing.JButton btnEliminarParametros;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JPanel pnlParametrosImpresion;
    private javax.swing.JTable tblParametros;
    // End of variables declaration//GEN-END:variables
}
