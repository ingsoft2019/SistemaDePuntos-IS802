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
public class frmConsultarCliente extends javax.swing.JFrame {

    /**
     * Creates new form frmConsultarCliente
     */
    public frmConsultarCliente() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false); //Desactivar botón maximizar de una ventana
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();
        btn_agregarCliente = new javax.swing.JButton();
        btn_clientes = new javax.swing.JButton();
        btn_RegresarAlMenuPrincipal = new javax.swing.JButton();
        chbox_BuscarInactivos = new java.awt.Checkbox();
        jl_Titulo = new javax.swing.JLabel();
        barraMenu = new javax.swing.JMenuBar();
        menu_InicioSistema = new javax.swing.JMenu();
        menu_Cliente = new javax.swing.JMenu();
        menu_Puntos = new javax.swing.JMenu();
        menu_Reportes = new javax.swing.JMenu();
        menu_ayuda = new javax.swing.JMenu();

        jToolBar1.setRollover(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Consultar Cliente");
        setFocusable(false);
        setMaximumSize(new java.awt.Dimension(517, 504));
        setMinimumSize(new java.awt.Dimension(517, 504));
        setName("ConsultaR Cliente"); // NOI18N
        setPreferredSize(new java.awt.Dimension(517, 504));
        getContentPane().setLayout(null);

        jPanel1.setFocusable(false);
        jPanel1.setLayout(null);

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre Cliente", "Telefono", "ID", "Puntos"
            }
        ));
        jTable1.setMaximumSize(new java.awt.Dimension(300, 64));
        jTable1.setMinimumSize(new java.awt.Dimension(300, 64));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 70, 350, 330);

        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jTextField1);
        jTextField1.setBounds(10, 8, 350, 40);

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/buscar.png"))); // NOI18N
        btn_buscar.setText("Buscar");
        btn_buscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_buscar.setPreferredSize(new java.awt.Dimension(35, 30));
        jPanel1.add(btn_buscar);
        btn_buscar.setBounds(380, 10, 100, 40);

        btn_agregarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/agregar.png"))); // NOI18N
        btn_agregarCliente.setText("Agregar");
        btn_agregarCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_agregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarClienteActionPerformed(evt);
            }
        });
        jPanel1.add(btn_agregarCliente);
        btn_agregarCliente.setBounds(370, 270, 120, 40);

        btn_clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/cliente.png"))); // NOI18N
        btn_clientes.setText("Cliente");
        btn_clientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_clientes.setMultiClickThreshhold(30L);
        btn_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clientesActionPerformed(evt);
            }
        });
        jPanel1.add(btn_clientes);
        btn_clientes.setBounds(370, 200, 120, 40);

        btn_RegresarAlMenuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/volverMenu.png"))); // NOI18N
        btn_RegresarAlMenuPrincipal.setText("Regresar");
        btn_RegresarAlMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegresarAlMenuPrincipalActionPerformed(evt);
            }
        });
        jPanel1.add(btn_RegresarAlMenuPrincipal);
        btn_RegresarAlMenuPrincipal.setBounds(370, 340, 120, 40);

        chbox_BuscarInactivos.setLabel("Buscar inactivos");
        chbox_BuscarInactivos.setName("Buscar Inactivos"); // NOI18N
        jPanel1.add(chbox_BuscarInactivos);
        chbox_BuscarInactivos.setBounds(380, 60, 120, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 50, 500, 420);

        jl_Titulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jl_Titulo.setText("Consultar Cliente");
        getContentPane().add(jl_Titulo);
        jl_Titulo.setBounds(170, 10, 220, 30);

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
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton btn_RegresarAlMenuPrincipal;
    private javax.swing.JButton btn_agregarCliente;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_clientes;
    private java.awt.Checkbox chbox_BuscarInactivos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel jl_Titulo;
    private javax.swing.JMenu menu_Cliente;
    private javax.swing.JMenu menu_InicioSistema;
    private javax.swing.JMenu menu_Puntos;
    private javax.swing.JMenu menu_Reportes;
    private javax.swing.JMenu menu_ayuda;
    // End of variables declaration//GEN-END:variables
}
