/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frmArea;

import javax.swing.ImageIcon;
import java.sql.*;
import Conexion.Conexion.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis Estrada
 */
public class frmConsultarCliente extends javax.swing.JFrame {

    static ResultSet resultado;
    static ResultSet resultado1;
    static ResultSet resultado2;
    static ResultSet resultado3;
    int contador1;
    int contador2; 
    /**
     * Creates new form frmConsultarCliente
     */
    public frmConsultarCliente() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false); //Desactivar botón maximizar de una ventana
        setIconImage(new ImageIcon(getClass().getResource("../imgSP/icono.png")).getImage()); //cambia el icono del formulario
        
    }
    
    public void buscarInactivos(){
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);
        resultado = Conexion.Conexion.consulta("select (Persona.pnombre+' '+Persona.snombre+' '+Persona.papellido\n" +
        "+' '+Persona.sapellido) NombreCliente, Persona.identidad, \n" +
        "Persona.telefono1, Cliente.puntos_actuales from Persona inner join Cliente on \n" +
        "Cliente.id_persona = Persona.id_persona  \n" +
        "where Cliente.estado = 'a';");
        try{
            while(resultado.next()){
                Vector v = new Vector();
                v.add(resultado.getString(1));
                v.add(resultado.getString(2));
                v.add(resultado.getString(3));
                v.add(resultado.getInt(4));
                modelo.addRow(v);
                jTable1.setModel(modelo);   
            }
        }catch(SQLException e){
            
        }
    }
    
    public void buscarPorNombre(){
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);
        resultado1 = Conexion.Conexion.consulta("select (Persona.pnombre+' '+Persona.snombre+' '+Persona.papellido\n" +
        "+' '+Persona.sapellido) NombreCliente, Persona.identidad, \n" +
        "Persona.telefono1, Cliente.puntos_actuales from persona inner join cliente on\n" +
        "Cliente.id_persona = Persona.id_persona\n" +
        "group by (Persona.pnombre+' '+Persona.snombre+' '+Persona.papellido\n" +
        "+' '+Persona.sapellido), Persona.identidad, \n" +
        "Persona.telefono1, Cliente.puntos_actuales having ((Persona.pnombre+' '+Persona.snombre+' '+Persona.papellido\n" +
        "+' '+Persona.sapellido)\n" + "LIKE '%"+jTextField1.getText()+"%')");
        try{
            while(resultado1.next()){
                Vector v = new Vector();
                v.add(resultado1.getString(1));
                v.add(resultado1.getString(2));
                v.add(resultado1.getString(3));
                v.add(resultado1.getInt(4));
                modelo.addRow(v);
                jTable1.setModel(modelo);   
            }
        }catch(SQLException e){
            
        }        
    }
    
    public void buscarPorIdTelefono(){
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);
        resultado3 = Conexion.Conexion.consulta("select (Persona.pnombre+' '+Persona.snombre+' '+Persona.papellido\n" +
        "+' '+Persona.sapellido) NombreCliente, Persona.identidad, \n" +
        "Persona.telefono1, Cliente.puntos_actuales from persona inner join cliente on\n" +
        "Cliente.id_persona = Persona.id_persona\n" +
        "group by (Persona.pnombre+' '+Persona.snombre+' '+Persona.papellido\n" +
        "+' '+Persona.sapellido), Persona.identidad, \n" +
        "Persona.telefono1, Cliente.puntos_actuales having (Persona.identidad = '"+jTextField1.getText()+"')or \n" +
        "(Persona.telefono1 = '"+jTextField1.getText()+"');");
        try{
            while(resultado3.next()){
                Vector v = new Vector();
                v.add(resultado3.getString(1));
                v.add(resultado3.getString(2));
                v.add(resultado3.getString(3));
                v.add(resultado3.getInt(4));
                modelo.addRow(v);
                jTable1.setModel(modelo);   
            }
        }catch(SQLException e){
            
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jPanel1 = new javax.swing.JPanel();
        btn_buscar = new javax.swing.JButton();
        btn_agregarCliente = new javax.swing.JButton();
        btn_clientes = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        AsignarPuntos = new javax.swing.JButton();
        CanjearPuntos = new javax.swing.JButton();
        jCheckBoxBuscarInactivos = new javax.swing.JCheckBox();
        jl_Titulo = new javax.swing.JLabel();

        jToolBar1.setRollover(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultar Cliente");
        setFocusable(false);
        setMaximumSize(new java.awt.Dimension(600, 530));
        setMinimumSize(new java.awt.Dimension(600, 530));

        jPanel1.setFocusable(false);

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/buscar.png"))); // NOI18N
        btn_buscar.setText("Buscar");
        btn_buscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_buscar.setPreferredSize(new java.awt.Dimension(35, 30));
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        btn_agregarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/agregar.png"))); // NOI18N
        btn_agregarCliente.setText("Agregar");
        btn_agregarCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_agregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarClienteActionPerformed(evt);
            }
        });

        btn_clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/cliente.png"))); // NOI18N
        btn_clientes.setText("Gestion Cliente");
        btn_clientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_clientes.setMultiClickThreshhold(30L);
        btn_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clientesActionPerformed(evt);
            }
        });

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre Cliente", "ID", "Telefono", "Puntos"
            }
        ));
        jTable1.setMaximumSize(new java.awt.Dimension(300, 64));
        jTable1.setMinimumSize(new java.awt.Dimension(300, 64));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        AsignarPuntos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/asignar.png"))); // NOI18N
        AsignarPuntos.setText("Asignar Puntos");
        AsignarPuntos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        AsignarPuntos.setMaximumSize(new java.awt.Dimension(77, 35));
        AsignarPuntos.setMinimumSize(new java.awt.Dimension(77, 35));
        AsignarPuntos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AsignarPuntosActionPerformed(evt);
            }
        });

        CanjearPuntos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/gestion_de_puntos.png"))); // NOI18N
        CanjearPuntos.setText("Canjear Puntos");
        CanjearPuntos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        CanjearPuntos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CanjearPuntosActionPerformed(evt);
            }
        });

        jCheckBoxBuscarInactivos.setText("Buscar Inactivos");
        jCheckBoxBuscarInactivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxBuscarInactivosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBoxBuscarInactivos, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_agregarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CanjearPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AsignarPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jCheckBoxBuscarInactivos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_agregarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addComponent(btn_clientes, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                    .addComponent(CanjearPuntos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AsignarPuntos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jl_Titulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jl_Titulo.setText("Consultar Cliente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_agregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarClienteActionPerformed
        frmRegistroClientes RC = new frmRegistroClientes();
        RC.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_agregarClienteActionPerformed

    private void btn_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clientesActionPerformed

        frmSubMenuCliente SMC = new frmSubMenuCliente();
        SMC.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_clientesActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        if(jCheckBoxBuscarInactivos.isSelected()){
            buscarInactivos();
            jCheckBoxBuscarInactivos.isValid();
        }else{
            try{
                resultado2 = Conexion.Conexion.consulta("select count(Persona.pnombre+' '+Persona.snombre+' '+Persona.papellido\n" +
                "+' '+Persona.sapellido) from persona inner join cliente on\n" +
                "Cliente.id_persona = Persona.id_persona\n" +
                "group by (Persona.pnombre+' '+Persona.snombre+' '+Persona.papellido\n" +
                "+' '+Persona.sapellido) having (Persona.pnombre+' '+Persona.snombre+' '+Persona.papellido\n" +
                "+' '+Persona.sapellido)\n" +
                "LIKE '%"+jTextField1.getText()+"%'");
                try{
                    while(resultado2.next()){
                        contador1 = resultado2.getInt(1);
                    }if(contador1==1){
                        buscarPorNombre();
                        
                    }else{
                 
                    }
                }catch(SQLException e){
                    
                }
            }catch(Exception e){
                
            }
        }
        
          
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void jCheckBoxBuscarInactivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxBuscarInactivosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxBuscarInactivosActionPerformed

    private void CanjearPuntosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CanjearPuntosActionPerformed
        frmCanjeoPuntos canjear = new frmCanjeoPuntos();
        canjear.setVisible(true);
    }//GEN-LAST:event_CanjearPuntosActionPerformed

    private void AsignarPuntosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AsignarPuntosActionPerformed
        frmAsignacionPuntos asiganr = new frmAsignacionPuntos();
        asiganr.setVisible(true);
    }//GEN-LAST:event_AsignarPuntosActionPerformed

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
            java.util.logging.Logger.getLogger(frmConsultarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmConsultarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmConsultarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmConsultarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmConsultarCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AsignarPuntos;
    private javax.swing.JButton CanjearPuntos;
    private javax.swing.JButton btn_agregarCliente;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_clientes;
    private javax.swing.JCheckBox jCheckBoxBuscarInactivos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel jl_Titulo;
    // End of variables declaration//GEN-END:variables
}
