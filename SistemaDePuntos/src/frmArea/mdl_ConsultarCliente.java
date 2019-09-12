/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frmArea;

import javax.swing.ImageIcon;
import java.sql.*;
//import Conexion.Conexion.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Clases.Validar;
import static Conexion.Conexion.consulta;
import static frmArea.frmConsultarCliente.resultado;
import javax.swing.JTextField;

public class mdl_ConsultarCliente extends java.awt.Dialog {

    private static ResultSet resultado;
    private static ResultSet resultado1;
    private static ResultSet resultado2;
    private static ResultSet resultado4;
    private int contador1;
    private int contador2;
    private static String texto;
    private Validar valido = new Validar();

    public mdl_ConsultarCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jTextField1.requestFocus();
        valido.ValidarBusqueda(jTextField1);
        this.setLocationRelativeTo(null);
        this.setResizable(false); //Desactivar botón maximizar de una ventana
        setIconImage(new ImageIcon(getClass().getResource("../imgSP/icono.png")).getImage()); //cambia el icono del formulario
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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

        setMaximumSize(new java.awt.Dimension(750, 523));
        setMinimumSize(new java.awt.Dimension(750, 523));
        setTitle("Consultar Cliente");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });
        setLayout(null);

        jPanel1.setFocusable(false);
        jPanel1.setLayout(null);

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/buscar.png"))); // NOI18N
        btn_buscar.setText("Buscar");
        btn_buscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_buscar.setPreferredSize(new java.awt.Dimension(35, 30));
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_buscar);
        btn_buscar.setBounds(472, 6, 130, 30);

        btn_agregarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/agregar.png"))); // NOI18N
        btn_agregarCliente.setText("Agregar");
        btn_agregarCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_agregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarClienteActionPerformed(evt);
            }
        });
        jPanel1.add(btn_agregarCliente);
        btn_agregarCliente.setBounds(260, 440, 140, 40);

        btn_clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/cliente.png"))); // NOI18N
        btn_clientes.setText("Gestion Cliente");
        btn_clientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_clientes.setMultiClickThreshhold(30L);
        btn_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clientesActionPerformed(evt);
            }
        });
        jPanel1.add(btn_clientes);
        btn_clientes.setBounds(90, 440, 140, 40);

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
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(6, 54, 737, 368);

        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jTextField1);
        jTextField1.setBounds(6, 8, 448, 27);

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
        jPanel1.add(AsignarPuntos);
        AsignarPuntos.setBounds(600, 440, 140, 40);

        CanjearPuntos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/gestion_de_puntos.png"))); // NOI18N
        CanjearPuntos.setText("Canjear Puntos");
        CanjearPuntos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        CanjearPuntos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CanjearPuntosActionPerformed(evt);
            }
        });
        jPanel1.add(CanjearPuntos);
        CanjearPuntos.setBounds(430, 440, 140, 40);

        jCheckBoxBuscarInactivos.setText("Buscar Inactivos");
        jCheckBoxBuscarInactivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxBuscarInactivosActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBoxBuscarInactivos);
        jCheckBoxBuscarInactivos.setBounds(610, 9, 130, 23);

        add(jPanel1);
        jPanel1.setBounds(0, 30, 750, 490);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void buscarCliente() {
        DefaultTableModel modelo = (DefaultTableModel) getjTable1().getModel();
        modelo.setRowCount(0);
        setResultado(Conexion.Conexion.consulta("select concat(Persona.pnombre,' ',Persona.snombre,' ',Persona.papellido,' ',\n"
                + "Persona.sapellido) NombreCLiente, Persona.identidad, Persona.telefono1, \n"
                + "Cliente.puntos_actuales from Persona inner join cliente on \n"
                + "Cliente.id_persona = Persona.id_persona\n"
                + "where (concat(Persona.pnombre,' ',Persona.snombre,' ',Persona.papellido,' ',\n"
                + "Persona.sapellido) like '%" + getjTextField1().getText() + "%' or Persona.identidad like '%" + getjTextField1().getText() + "%' \n" + "or Persona.telefono1 like '%" + getjTextField1().getText() + "%') and Cliente.estado = 'a';"));
        try {
            while (getResultado().next()) {
                Vector v = new Vector();
                v.add(getResultado().getString(1));
                v.add(getResultado().getString(2));
                v.add(getResultado().getString(3));
                v.add(getResultado().getInt(4));
                modelo.addRow(v);
                getjTable1().setModel(modelo);
            }
        } catch (SQLException e) {

        }
    }

    public void buscarClienteInactivo() {
        DefaultTableModel modelo = (DefaultTableModel) getjTable1().getModel();
        modelo.setRowCount(0);
        setResultado(Conexion.Conexion.consulta("select concat(Persona.pnombre,' ',Persona.snombre,' ',Persona.papellido,' ',\n"
                + "Persona.sapellido) NombreCLiente, Persona.identidad, Persona.telefono1, \n"
                + "Cliente.puntos_actuales from Persona inner join cliente on \n"
                + "Cliente.id_persona = Persona.id_persona\n"
                + "where (concat(Persona.pnombre,' ',Persona.snombre,' ',Persona.papellido,' ',\n"
                + "Persona.sapellido) like '%" + getjTextField1().getText() + "%' or Persona.identidad like '%" + getjTextField1().getText() + "%' \n" + "or Persona.telefono1 like '%" + getjTextField1().getText() + "%') and Cliente.estado = 'i';"));
        try {
            while (getResultado().next()) {
                Vector v = new Vector();
                v.add(getResultado().getString(1));
                v.add(getResultado().getString(2));
                v.add(getResultado().getString(3));
                v.add(getResultado().getInt(4));
                modelo.addRow(v);
                getjTable1().setModel(modelo);
            }
        } catch (SQLException e) {

        }
    }

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        if (getjTextField1().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo de busqueda vacio");
        } else {
            try {
                setResultado1(Conexion.Conexion.consulta("select count(Persona.identidad) from Persona inner join cliente on \n"
                        + "Cliente.id_persona = Persona.id_persona\n"
                        + "where concat(Persona.pnombre,' ',Persona.snombre,' ',Persona.papellido,' ',\n"
                        + "Persona.sapellido) like '%" + getjTextField1().getText() + "%' or Persona.identidad like '%" + getjTextField1().getText() + "%' \n" + "or Persona.telefono1 like '%" + getjTextField1().getText() + "%' "));
                setResultado2(Conexion.Conexion.consulta("select count(Persona.identidad) from Persona inner join cliente on \n"
                        + "Cliente.id_persona = Persona.id_persona\n"
                        + "where (concat(Persona.pnombre,' ',Persona.snombre,' ',Persona.papellido,' ',\n"
                        + "Persona.sapellido) like '%" + getjTextField1().getText() + "%' or Persona.identidad like '%" + getjTextField1().getText() + "%' \n" + "or Persona.telefono1 like '%" + getjTextField1().getText() + "%') and Cliente.estado = 'i';"));
                try {
                    while (getResultado1().next()) {
                        setContador1(getResultado1().getInt(1));
                    }
                    while (getResultado2().next()) {
                        setContador2(getResultado2().getInt(1));
                    }
                    if (getjCheckBoxBuscarInactivos().isSelected()) {
                        buscarClienteInactivo();
                        getjCheckBoxBuscarInactivos().setSelected(false);
                    } else if (getContador1() >= 1) {
                        buscarCliente();
                        CanjearPuntos.setEnabled(true);
                        AsignarPuntos.setEnabled(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "El registro que busca no existe");
                    }
                } catch (SQLException e) {

                }

            } catch (Exception e) {

            }
        }
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_agregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarClienteActionPerformed
        frmMenuPrincipal frmMenuPrincipal = new frmMenuPrincipal();
        mdl_RegistroClientes RC = new mdl_RegistroClientes(frmMenuPrincipal, true);
        RC.setVisible(true); // visible ventana del objeto
    }//GEN-LAST:event_btn_agregarClienteActionPerformed

    private void btn_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clientesActionPerformed

        try {
            int row = getjTable1().getSelectedRow(); //OBTENGO LA FILA SELECCIONADA
            String identidad = (String) getjTable1().getValueAt(row, 1); //OBTENGO EL VALOR DEL NUMERO DE IDENTIDAD

            //Consulto todos los datos relacioados con el ID
            ResultSet res = consulta("Select * from Persona inner join Cliente on Persona.id_persona = Cliente.id_persona\n"
                    + "inner join zona on Persona.id_zona = Zona.id_zona where Persona.identidad = '" + identidad + "';");
            //Hago visible el formulario
            frmMenuPrincipal frmMenuPrincipal = new frmMenuPrincipal();
            mdl_SubMenuCliente subMenuCli = new mdl_SubMenuCliente(frmMenuPrincipal, true);

            try {
                while (res.next()) {
                    //Llamo al metodo para llenar los campos con los datos a editar
                    subMenuCli.llenarCampos(res.getString("pnombre"), res.getString("snombre"), res.getString("papellido"),
                            res.getString("sapellido"), res.getString("identidad"), res.getString("sexo"), res.getString("telefono1"),
                            res.getString("telefono2"), res.getString("telefono3"), res.getString("correo"),
                            res.getDate("fecha_nacimiento"), res.getString("detalle_direccion"),
                            res.getString("puntos_actuales"), res.getString("puntos_rifa_actuales"),
                            res.getString("fecha_vencimiento_puntos"), res.getString("id_persona"), res.getString("estado"));

                    subMenuCli.cargarZonas(res.getString("zona"));
                    subMenuCli.setVisible(true); // visible ventana del objeto

                }

            } catch (SQLException ex) {
                Logger.getLogger(mdl_ConsultarCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Busque y seleccione un registro");
        }
    }//GEN-LAST:event_btn_clientesActionPerformed

    private void AsignarPuntosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AsignarPuntosActionPerformed
        try {
            int row = getjTable1().getSelectedRow();
            String identidad = (String) getjTable1().getValueAt(row, 1);

            ResultSet res = consulta("select * from Persona\n"
                    + "where Persona.identidad = '"+identidad+"';");
            
            frmMenuPrincipal menuprin = new frmMenuPrincipal();
            mdl_AsignacionPuntos asigpuntos = new mdl_AsignacionPuntos(menuprin, true);
            
            try{
                while(res.next()){
                    asigpuntos.campoAsignarPuntos(res.getString("identidad"));
                    asigpuntos.setVisible(true);
                    
                }
                
            }catch(SQLException e){
                
            }
        }catch(Exception e){
            
        }
        
        
        /*frmMenuPrincipal frmMenuPrincipal = new frmMenuPrincipal();
        mdl_AsignacionPuntos asiganr = new mdl_AsignacionPuntos(frmMenuPrincipal, true);
        asiganr.setVisible(true); // visible ventana del objeto */ 
    }//GEN-LAST:event_AsignarPuntosActionPerformed

    private void CanjearPuntosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CanjearPuntosActionPerformed
        try {
            int row = getjTable1().getSelectedRow();
            String identidad = (String) getjTable1().getValueAt(row, 1);

            ResultSet res = consulta("select * from Persona\n"
                    + "where Persona.identidad = '"+identidad+"';");
            
            frmMenuPrincipal menuprin = new frmMenuPrincipal();
            mdl_CanjeoPuntos canjeopuntos = new mdl_CanjeoPuntos(menuprin, true);
            
            try{
                while(res.next()){
                    canjeopuntos.campoCanjeoPuntos(res.getString("pnombre"),res.getString("snombre"),res.getString("papellido"),res.getString("sapellido"));
                    canjeopuntos.setVisible(true);
                }
                
            }catch(SQLException e){
                
            }
        }catch(Exception e){
            
        }

        /*frmMenuPrincipal frmMenuPrincipal = new frmMenuPrincipal();
        mdl_CanjeoPuntos canjear = new mdl_CanjeoPuntos(frmMenuPrincipal, true);
        canjear.setVisible(true); // visible ventana del objeto*/       
    }//GEN-LAST:event_CanjearPuntosActionPerformed

    private void jCheckBoxBuscarInactivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxBuscarInactivosActionPerformed
        if(jCheckBoxBuscarInactivos.isSelected()){
            CanjearPuntos.setEnabled(false);
            AsignarPuntos.setEnabled(false);
        }else{
            CanjearPuntos.setEnabled(true);
            AsignarPuntos.setEnabled(true);
            
        }
    }//GEN-LAST:event_jCheckBoxBuscarInactivosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                mdl_ConsultarCliente dialog = new mdl_ConsultarCliente(new java.awt.Frame(), true);
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
    // End of variables declaration//GEN-END:variables

    /**
     * @return the resultado
     */
    public static ResultSet getResultado() {
        return resultado;
    }

    /**
     * @param aResultado the resultado to set
     */
    public static void setResultado(ResultSet aResultado) {
        resultado = aResultado;
    }

    /**
     * @return the resultado1
     */
    public static ResultSet getResultado1() {
        return resultado1;
    }

    /**
     * @param aResultado1 the resultado1 to set
     */
    public static void setResultado1(ResultSet aResultado1) {
        resultado1 = aResultado1;
    }

    /**
     * @return the resultado2
     */
    public static ResultSet getResultado2() {
        return resultado2;
    }

    /**
     * @param aResultado2 the resultado2 to set
     */
    public static void setResultado2(ResultSet aResultado2) {
        resultado2 = aResultado2;
    }

    /**
     * @return the contador1
     */
    public int getContador1() {
        return contador1;
    }

    /**
     * @param contador1 the contador1 to set
     */
    public void setContador1(int contador1) {
        this.contador1 = contador1;
    }

    /**
     * @return the contador2
     */
    public int getContador2() {
        return contador2;
    }

    /**
     * @param contador2 the contador2 to set
     */
    public void setContador2(int contador2) {
        this.contador2 = contador2;
    }

    /**
     * @return the texto
     */
    public static String getTexto() {
        return texto;
    }

    /**
     * @param aTexto the texto to set
     */
    public static void setTexto(String aTexto) {
        texto = aTexto;
    }

    /**
     * @return the valido
     */
    public Validar getValido() {
        return valido;
    }

    /**
     * @param valido the valido to set
     */
    public void setValido(Validar valido) {
        this.valido = valido;
    }

    /**
     * @return the AsignarPuntos
     */
    public javax.swing.JButton getAsignarPuntos() {
        return AsignarPuntos;
    }

    /**
     * @param AsignarPuntos the AsignarPuntos to set
     */
    public void setAsignarPuntos(javax.swing.JButton AsignarPuntos) {
        this.AsignarPuntos = AsignarPuntos;
    }

    /**
     * @return the CanjearPuntos
     */
    public javax.swing.JButton getCanjearPuntos() {
        return CanjearPuntos;
    }

    /**
     * @param CanjearPuntos the CanjearPuntos to set
     */
    public void setCanjearPuntos(javax.swing.JButton CanjearPuntos) {
        this.CanjearPuntos = CanjearPuntos;
    }

    /**
     * @return the btn_agregarCliente
     */
    public javax.swing.JButton getBtn_agregarCliente() {
        return btn_agregarCliente;
    }

    /**
     * @param btn_agregarCliente the btn_agregarCliente to set
     */
    public void setBtn_agregarCliente(javax.swing.JButton btn_agregarCliente) {
        this.btn_agregarCliente = btn_agregarCliente;
    }

    /**
     * @return the btn_buscar
     */
    public javax.swing.JButton getBtn_buscar() {
        return btn_buscar;
    }

    /**
     * @param btn_buscar the btn_buscar to set
     */
    public void setBtn_buscar(javax.swing.JButton btn_buscar) {
        this.btn_buscar = btn_buscar;
    }

    /**
     * @return the btn_clientes
     */
    public javax.swing.JButton getBtn_clientes() {
        return btn_clientes;
    }

    /**
     * @param btn_clientes the btn_clientes to set
     */
    public void setBtn_clientes(javax.swing.JButton btn_clientes) {
        this.btn_clientes = btn_clientes;
    }

    /**
     * @return the jCheckBoxBuscarInactivos
     */
    public javax.swing.JCheckBox getjCheckBoxBuscarInactivos() {
        return jCheckBoxBuscarInactivos;
    }

    /**
     * @param jCheckBoxBuscarInactivos the jCheckBoxBuscarInactivos to set
     */
    public void setjCheckBoxBuscarInactivos(javax.swing.JCheckBox jCheckBoxBuscarInactivos) {
        this.jCheckBoxBuscarInactivos = jCheckBoxBuscarInactivos;
    }

    /**
     * @return the jPanel1
     */
    public javax.swing.JPanel getjPanel1() {
        return jPanel1;
    }

    /**
     * @param jPanel1 the jPanel1 to set
     */
    public void setjPanel1(javax.swing.JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    /**
     * @return the jScrollPane1
     */
    public javax.swing.JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    /**
     * @param jScrollPane1 the jScrollPane1 to set
     */
    public void setjScrollPane1(javax.swing.JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    /**
     * @return the jTable1
     */
    public javax.swing.JTable getjTable1() {
        return jTable1;
    }

    /**
     * @param jTable1 the jTable1 to set
     */
    public void setjTable1(javax.swing.JTable jTable1) {
        this.jTable1 = jTable1;
    }

    /**
     * @return the jTextField1
     */
    public javax.swing.JTextField getjTextField1() {
        return jTextField1;
    }

    /**
     * @param jTextField1 the jTextField1 to set
     */
    public void setjTextField1(javax.swing.JTextField jTextField1) {
        this.jTextField1 = jTextField1;
    }
}
