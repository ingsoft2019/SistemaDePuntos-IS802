/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frmArea;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class mdl_consultar_por_rango_de_edad extends java.awt.Dialog {

    static ResultSet resultado;
    static ResultSet resultado1;
    static ResultSet resultado2;
    int contador1;
    int contador2;
    public static String texto;
    /**
     * Creates new form mdl_consultar_por_rango_de_edad
     */
    public mdl_consultar_por_rango_de_edad(java.awt.Frame parent, boolean modal) {
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
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtfechainicio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtfechafin = new javax.swing.JTextField();
        btnGenerarConsulta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(659, 403));
        setMinimumSize(new java.awt.Dimension(659, 403));
        setTitle("Reporte de rango de edad de los clientes ");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });
        setLayout(null);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Ingrese el rango de edades");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(180, 40, 340, 31);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Inicio :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(50, 90, 90, 17);

        txtfechainicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfechainicioActionPerformed(evt);
            }
        });
        txtfechainicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfechainicioKeyTyped(evt);
            }
        });
        jPanel1.add(txtfechainicio);
        txtfechainicio.setBounds(141, 90, 90, 24);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Hasta :");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(260, 90, 90, 17);

        txtfechafin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfechafinActionPerformed(evt);
            }
        });
        txtfechafin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfechafinKeyTyped(evt);
            }
        });
        jPanel1.add(txtfechafin);
        txtfechafin.setBounds(350, 90, 90, 24);

        btnGenerarConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/dato puntos.png"))); // NOI18N
        btnGenerarConsulta.setText("Generar Consulta");
        btnGenerarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarConsultaActionPerformed(evt);
            }
        });
        jPanel1.add(btnGenerarConsulta);
        btnGenerarConsulta.setBounds(460, 80, 170, 40);

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre Completo", "Edad", "Fecha Nacimiento", "Zona"
            }
        ));
        jTable1.setMaximumSize(new java.awt.Dimension(300, 64));
        jTable1.setMinimumSize(new java.awt.Dimension(300, 64));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(6, 150, 638, 232);

        add(jPanel1);
        jPanel1.setBounds(0, 0, 660, 410);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void txtfechainicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfechainicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfechainicioActionPerformed

    private void txtfechafinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfechafinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfechafinActionPerformed

    private void btnGenerarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarConsultaActionPerformed
        // TODO add your handling code here:
        if (txtfechainicio.getText().isEmpty() || txtfechafin.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe de Ingresar un Fecha Valida");
        } else {
            if (Integer.parseInt(txtfechainicio.getText()) > Integer.parseInt(txtfechafin.getText())){
                JOptionPane.showMessageDialog(null, "La edad inicial debe ser menor a la edad final");
            }
            try {
                resultado1 = Conexion.Conexion.consulta(" select count (*) from (\n" +
                    "  select  (select (cast(datediff(dd,p.fecha_nacimiento,GETDATE()) / 365.25 as int))) as edad\n" +
                    "  from [PR].[dbo].[Persona] P \n" +
                    "  where  (select (cast(datediff(dd,p.fecha_nacimiento,GETDATE()) / 365.25 as int))) BETWEEN '"+txtfechainicio.getText()+"'  AND '"+txtfechafin.getText()+"' )as fch ;");
                try {
                    while (resultado1.next()) {
                        contador1 = resultado1.getInt(1);
                    }
                    if (contador1 >= 1) {
                        buscarCliente();
                    } else {
                        JOptionPane.showMessageDialog(null, "El registro que busca no existe");
                    }
                } catch (SQLException em) {
                    throw em;
                }

            } catch (Exception e) {
                try {
                    throw e;
                } catch (Exception ex) {
                    Logger.getLogger(mdl_consultar_por_rango_de_edad.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }//GEN-LAST:event_btnGenerarConsultaActionPerformed

    private void txtfechainicioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfechainicioKeyTyped
        char c = evt.getKeyChar();

        if (c< '0'|| c>'9') evt.consume();
    }//GEN-LAST:event_txtfechainicioKeyTyped

    private void txtfechafinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfechafinKeyTyped
        char c = evt.getKeyChar();

        if (c< '0'|| c>'9') evt.consume();
    }//GEN-LAST:event_txtfechafinKeyTyped

    
    public void buscarCliente() throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);
        resultado = Conexion.Conexion.consulta(" select * from(select concat(p.pnombre,' ',p.snombre,' ',p.papellido,' ', p.sapellido ) as nombrecompleto ,(select (cast(datediff(dd,p.fecha_nacimiento,GETDATE()) / 365.25 as int))) as edad, p.fecha_nacimiento,  Z.zona from [PR].[dbo].[Persona] P inner join [PR].[dbo].Zona Z on Z.id_zona = P.id_zona where  (select (cast(datediff(dd,p.fecha_nacimiento,GETDATE()) / 365.25 as int))) > 5) as fch where fch.edad BETWEEN "+txtfechainicio.getText()+"  AND "+txtfechafin.getText()+" order by fch.edad  desc ;");
        try {
            while (resultado.next()) {
                Vector v = new Vector();
                v.add(resultado.getString(1));
                System.out.println("El Valor es: "+resultado.getString(1));
                v.add(resultado.getString(2));
                v.add(resultado.getString(3));
                v.add(resultado.getString(4));
                modelo.addRow(v);
                jTable1.setModel(modelo);
            }
        } catch (SQLException e) {
           throw e;     
        }catch (Exception ex) {
           throw ex;     
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                mdl_consultar_por_rango_de_edad dialog = new mdl_consultar_por_rango_de_edad(new java.awt.Frame(), true);
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
    private javax.swing.JButton btnGenerarConsulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtfechafin;
    private javax.swing.JTextField txtfechainicio;
    // End of variables declaration//GEN-END:variables
}
