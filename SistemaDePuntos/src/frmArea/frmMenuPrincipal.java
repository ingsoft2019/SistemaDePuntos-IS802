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
public class frmMenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form frmMenuPrincipal
     */
    public frmMenuPrincipal() {
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

        panel_menuPrincipal = new java.awt.Panel();
        btn_ClienteMenu = new javax.swing.JButton();
        btn_PuntosMenu = new javax.swing.JButton();
        btn_ReportesMenu = new javax.swing.JButton();
        btn_configuracion = new javax.swing.JButton();
        btn_SalirMenuPrincipal = new javax.swing.JButton();
        jl_tituloMenuPrincipal = new javax.swing.JLabel();
        barraMenu = new javax.swing.JMenuBar();
        menu_InicioSistema = new javax.swing.JMenu();
        menuItem_inicio = new javax.swing.JMenuItem();
        menu_Cliente = new javax.swing.JMenu();
        menuItem_SubMenuCliente = new javax.swing.JMenuItem();
        menuItem_agregar = new javax.swing.JMenuItem();
        menuItem_consultar = new javax.swing.JMenuItem();
        menuItem_modificar = new javax.swing.JMenuItem();
        menuItem_deshabilitar_habilitar = new javax.swing.JMenuItem();
        menuItem_imprimir_direccion = new javax.swing.JMenuItem();
        menu_Puntos = new javax.swing.JMenu();
        menuItem_menu_Puntos = new javax.swing.JMenuItem();
        menuItem_asignar = new javax.swing.JMenuItem();
        menuItem_consultar_puntos = new javax.swing.JMenuItem();
        menuItem_canjear = new javax.swing.JMenuItem();
        menu_Reportes = new javax.swing.JMenu();
        MenuItem_menu_reportes = new javax.swing.JMenuItem();
        menuItem_puntos = new javax.swing.JMenuItem();
        menuItem_clientes = new javax.swing.JMenuItem();
        menuItem_graficas = new javax.swing.JMenuItem();
        menu_configuracion = new javax.swing.JMenu();
        menuItem_Menu_Configuracion = new javax.swing.JMenuItem();
        menu_ayuda = new javax.swing.JMenu();
        menuItem_acercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal del Sistema de Puntos");
        setMaximumSize(new java.awt.Dimension(680, 528));
        setMinimumSize(new java.awt.Dimension(680, 528));
        setName("Menu Princial Sistema de Puntos"); // NOI18N
        setPreferredSize(new java.awt.Dimension(680, 528));
        getContentPane().setLayout(null);

        panel_menuPrincipal.setLayout(null);

        btn_ClienteMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/cliente v2.png"))); // NOI18N
        btn_ClienteMenu.setText("Cliente");
        btn_ClienteMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ClienteMenuActionPerformed(evt);
            }
        });
        panel_menuPrincipal.add(btn_ClienteMenu);
        btn_ClienteMenu.setBounds(40, 110, 220, 70);

        btn_PuntosMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/gestion_de_puntos v2.png"))); // NOI18N
        btn_PuntosMenu.setText("Puntos");
        btn_PuntosMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PuntosMenuActionPerformed(evt);
            }
        });
        panel_menuPrincipal.add(btn_PuntosMenu);
        btn_PuntosMenu.setBounds(350, 110, 200, 70);

        btn_ReportesMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/reportes v2.png"))); // NOI18N
        btn_ReportesMenu.setText("Reportes");
        btn_ReportesMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ReportesMenuActionPerformed(evt);
            }
        });
        panel_menuPrincipal.add(btn_ReportesMenu);
        btn_ReportesMenu.setBounds(40, 230, 220, 70);

        btn_configuracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/administrador.png"))); // NOI18N
        btn_configuracion.setText("Configuración");
        btn_configuracion.setToolTipText("");
        btn_configuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_configuracionActionPerformed(evt);
            }
        });
        panel_menuPrincipal.add(btn_configuracion);
        btn_configuracion.setBounds(360, 230, 190, 69);

        btn_SalirMenuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/salirSistema v2.png"))); // NOI18N
        btn_SalirMenuPrincipal.setText("Salir del sistema");
        btn_SalirMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SalirMenuPrincipalActionPerformed(evt);
            }
        });
        panel_menuPrincipal.add(btn_SalirMenuPrincipal);
        btn_SalirMenuPrincipal.setBounds(180, 340, 260, 70);

        jl_tituloMenuPrincipal.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jl_tituloMenuPrincipal.setText("Sistema de Puntos Farmacia ");
        panel_menuPrincipal.add(jl_tituloMenuPrincipal);
        jl_tituloMenuPrincipal.setBounds(80, 20, 459, 40);

        getContentPane().add(panel_menuPrincipal);
        panel_menuPrincipal.setBounds(40, 30, 600, 430);

        menu_InicioSistema.setText("Inicio del Sistema ");
        menu_InicioSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_InicioSistemaActionPerformed(evt);
            }
        });

        menuItem_inicio.setText("Inicio");
        menuItem_inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_inicioActionPerformed(evt);
            }
        });
        menu_InicioSistema.add(menuItem_inicio);

        barraMenu.add(menu_InicioSistema);

        menu_Cliente.setText("Clientes");
        menu_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_ClienteActionPerformed(evt);
            }
        });

        menuItem_SubMenuCliente.setText("Menu Cliente");
        menuItem_SubMenuCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_SubMenuClienteActionPerformed(evt);
            }
        });
        menu_Cliente.add(menuItem_SubMenuCliente);

        menuItem_agregar.setText("Agregar ");
        menu_Cliente.add(menuItem_agregar);

        menuItem_consultar.setText("Consultar ");
        menuItem_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_consultarActionPerformed(evt);
            }
        });
        menu_Cliente.add(menuItem_consultar);

        menuItem_modificar.setText("Modificar ");
        menu_Cliente.add(menuItem_modificar);

        menuItem_deshabilitar_habilitar.setText("Deshabilitar / Habilitar ");
        menu_Cliente.add(menuItem_deshabilitar_habilitar);

        menuItem_imprimir_direccion.setText("Imprimir direccion ");
        menu_Cliente.add(menuItem_imprimir_direccion);

        barraMenu.add(menu_Cliente);

        menu_Puntos.setText("Puntos");

        menuItem_menu_Puntos.setText("Menu Puntos");
        menuItem_menu_Puntos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_menu_PuntosActionPerformed(evt);
            }
        });
        menu_Puntos.add(menuItem_menu_Puntos);

        menuItem_asignar.setText("Asignar ");
        menuItem_asignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_asignarActionPerformed(evt);
            }
        });
        menu_Puntos.add(menuItem_asignar);

        menuItem_consultar_puntos.setText("Consultar ");
        menu_Puntos.add(menuItem_consultar_puntos);

        menuItem_canjear.setText("Canjear");
        menuItem_canjear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_canjearActionPerformed(evt);
            }
        });
        menu_Puntos.add(menuItem_canjear);

        barraMenu.add(menu_Puntos);

        menu_Reportes.setText("Reportes");

        MenuItem_menu_reportes.setText("Menu Reportes");
        MenuItem_menu_reportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItem_menu_reportesActionPerformed(evt);
            }
        });
        menu_Reportes.add(MenuItem_menu_reportes);

        menuItem_puntos.setText("Puntos");
        menu_Reportes.add(menuItem_puntos);

        menuItem_clientes.setText("Clientes");
        menu_Reportes.add(menuItem_clientes);

        menuItem_graficas.setText("Graficas");
        menu_Reportes.add(menuItem_graficas);

        barraMenu.add(menu_Reportes);

        menu_configuracion.setText("Configuración");
        menu_configuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_configuracionActionPerformed(evt);
            }
        });

        menuItem_Menu_Configuracion.setText("Menu Configuración");
        menuItem_Menu_Configuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_Menu_ConfiguracionActionPerformed(evt);
            }
        });
        menu_configuracion.add(menuItem_Menu_Configuracion);

        barraMenu.add(menu_configuracion);

        menu_ayuda.setText("Ayuda");

        menuItem_acercaDe.setText("Información del Sistema de Puntos");
        menuItem_acercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_acercaDeActionPerformed(evt);
            }
        });
        menu_ayuda.add(menuItem_acercaDe);

        barraMenu.add(menu_ayuda);

        setJMenuBar(barraMenu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_SalirMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SalirMenuPrincipalActionPerformed
               System.exit(0); // salir del sistema 
    }//GEN-LAST:event_btn_SalirMenuPrincipalActionPerformed

    private void btn_configuracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_configuracionActionPerformed
         frmLoginModuloConfiguracion ver=new frmLoginModuloConfiguracion();
            ver.setVisible(true); // visible ventana del objeto
            this.setVisible(false); // ocultar
    }//GEN-LAST:event_btn_configuracionActionPerformed

    private void btn_ReportesMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ReportesMenuActionPerformed
         frmSubMenuReporte ver=new frmSubMenuReporte();
            ver.setVisible(true); // visible ventana del objeto
            this.setVisible(false); // ocultar

    }//GEN-LAST:event_btn_ReportesMenuActionPerformed

    private void btn_ClienteMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ClienteMenuActionPerformed
        frmConsultarCliente ver=new frmConsultarCliente();
            ver.setVisible(true); // visible ventana del objeto
            this.setVisible(false); // ocultar
        
    }//GEN-LAST:event_btn_ClienteMenuActionPerformed

    private void btn_PuntosMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PuntosMenuActionPerformed
        frmSubMenuPuntos ver=new frmSubMenuPuntos();
            ver.setVisible(true); // visible ventana del objeto
            this.setVisible(false); // ocultar
        
    }//GEN-LAST:event_btn_PuntosMenuActionPerformed

    private void menu_InicioSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_InicioSistemaActionPerformed

      
    }//GEN-LAST:event_menu_InicioSistemaActionPerformed

    private void menu_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_ClienteActionPerformed
        frmConsultarCliente ver=new frmConsultarCliente();
            ver.setVisible(true); // visible ventana del objeto
            this.setVisible(false); // ocultar
     
    }//GEN-LAST:event_menu_ClienteActionPerformed

    private void menuItem_inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_inicioActionPerformed
        frmMenuPrincipal ver=new frmMenuPrincipal();
            ver.setVisible(true); // visible ventana del objeto
            this.setVisible(false); // ocultar

      
    }//GEN-LAST:event_menuItem_inicioActionPerformed

    private void menuItem_SubMenuClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_SubMenuClienteActionPerformed
        

   
    }//GEN-LAST:event_menuItem_SubMenuClienteActionPerformed

    private void menuItem_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_consultarActionPerformed
        frmSubMenuCliente ver=new frmSubMenuCliente();
        ver.setVisible(true); // visible ventana del objeto
        this.setVisible(false); 
       
    }//GEN-LAST:event_menuItem_consultarActionPerformed

    private void menuItem_menu_PuntosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_menu_PuntosActionPerformed

        frmSubMenuPuntos ver=new frmSubMenuPuntos();
        ver.setVisible(true); // visible ventana del objeto
        this.setVisible(false);

    }//GEN-LAST:event_menuItem_menu_PuntosActionPerformed

    private void menu_configuracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_configuracionActionPerformed
        frmSubMenuPuntos ver=new frmSubMenuPuntos();
        ver.setVisible(true); // visible ventana del objeto
        this.setVisible(false);

    }//GEN-LAST:event_menu_configuracionActionPerformed

    private void menuItem_Menu_ConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_Menu_ConfiguracionActionPerformed
 
        frmLoginModuloConfiguracion ver=new frmLoginModuloConfiguracion();
        ver.setVisible(true); // visible ventana del objeto
        this.setVisible(false);
    }//GEN-LAST:event_menuItem_Menu_ConfiguracionActionPerformed

    private void menuItem_acercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_acercaDeActionPerformed
        frmAcercaDe ver=new frmAcercaDe();
        ver.setVisible(true); // visible ventana del objeto
        this.setVisible(false);
    }//GEN-LAST:event_menuItem_acercaDeActionPerformed

    private void MenuItem_menu_reportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItem_menu_reportesActionPerformed
        frmSubMenuReporte ver=new frmSubMenuReporte();
        ver.setVisible(true); // visible ventana del objeto
        this.setVisible(false);
   
    }//GEN-LAST:event_MenuItem_menu_reportesActionPerformed

    private void menuItem_asignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_asignarActionPerformed
        frmAsignacionPuntos ver=new frmAsignacionPuntos();
        ver.setVisible(true); // visible ventana del objeto
        this.setVisible(false);
    }//GEN-LAST:event_menuItem_asignarActionPerformed

    private void menuItem_canjearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_canjearActionPerformed
        frmCanjeoPuntos ver=new frmCanjeoPuntos();
        ver.setVisible(true); // visible ventana del objeto
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_menuItem_canjearActionPerformed

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
            java.util.logging.Logger.getLogger(frmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuItem_menu_reportes;
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton btn_ClienteMenu;
    private javax.swing.JButton btn_PuntosMenu;
    private javax.swing.JButton btn_ReportesMenu;
    private javax.swing.JButton btn_SalirMenuPrincipal;
    private javax.swing.JButton btn_configuracion;
    private javax.swing.JLabel jl_tituloMenuPrincipal;
    private javax.swing.JMenuItem menuItem_Menu_Configuracion;
    private javax.swing.JMenuItem menuItem_SubMenuCliente;
    private javax.swing.JMenuItem menuItem_acercaDe;
    private javax.swing.JMenuItem menuItem_agregar;
    private javax.swing.JMenuItem menuItem_asignar;
    private javax.swing.JMenuItem menuItem_canjear;
    private javax.swing.JMenuItem menuItem_clientes;
    private javax.swing.JMenuItem menuItem_consultar;
    private javax.swing.JMenuItem menuItem_consultar_puntos;
    private javax.swing.JMenuItem menuItem_deshabilitar_habilitar;
    private javax.swing.JMenuItem menuItem_graficas;
    private javax.swing.JMenuItem menuItem_imprimir_direccion;
    private javax.swing.JMenuItem menuItem_inicio;
    private javax.swing.JMenuItem menuItem_menu_Puntos;
    private javax.swing.JMenuItem menuItem_modificar;
    private javax.swing.JMenuItem menuItem_puntos;
    private javax.swing.JMenu menu_Cliente;
    private javax.swing.JMenu menu_InicioSistema;
    private javax.swing.JMenu menu_Puntos;
    private javax.swing.JMenu menu_Reportes;
    private javax.swing.JMenu menu_ayuda;
    private javax.swing.JMenu menu_configuracion;
    private java.awt.Panel panel_menuPrincipal;
    // End of variables declaration//GEN-END:variables
}
