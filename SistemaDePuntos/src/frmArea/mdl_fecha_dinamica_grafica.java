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
import Chats.SistemasVentasPuntos.ClaseControllerGraficoCirculares;
import Clases.Zona;
import static frmArea.mdl_reporte_en_graficos.resultado6;
import java.awt.Dialog;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
//Para la grafica
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;


public class mdl_fecha_dinamica_grafica extends java.awt.Dialog {

    /** Creates new form mdl_fecha_dinamica_grafica */
        static ResultSet resultado6;
    static ResultSet resultado1;
    static ResultSet resultado2;
    
    JFreeChart grafico = null;
    DefaultCategoryDataset datos = new DefaultCategoryDataset();
    Vector v = new Vector();
    int cant_F=0 ;
    int cant_M =0;
    
    public mdl_fecha_dinamica_grafica(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null); //para ponerse en el centro         
        this.setResizable(false); //Desactivar botón maximizar de una ventana
        setIconImage(new ImageIcon(getClass().getResource("../imgSP/icono.png")).getImage()); //cambia el icono del formulario
        cargarZonas();//  Cargar las zonas en el combobox zonas
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblRangoPorEdad = new javax.swing.JLabel();
        jL_fechaNacimiento = new javax.swing.JLabel();
        jDC_fechaNacimiento = new com.toedter.calendar.JDateChooser();
        jL_fechaNacimiento1 = new javax.swing.JLabel();
        jDC_fechaNacimiento1 = new com.toedter.calendar.JDateChooser();
        btn_graficar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jC_zona = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        combox_tipo_grafico = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        combox_datos_graficables = new javax.swing.JComboBox<>();

        setMaximumSize(new java.awt.Dimension(609, 390));
        setMinimumSize(new java.awt.Dimension(609, 390));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });
        setLayout(null);

        jPanel1.setLayout(null);

        lblRangoPorEdad.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblRangoPorEdad.setText("Grafico del sistema de puntos ");
        jPanel1.add(lblRangoPorEdad);
        lblRangoPorEdad.setBounds(150, 40, 380, 30);

        jL_fechaNacimiento.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jL_fechaNacimiento.setText("Fecha inicio dd-mm-yy :");
        jPanel1.add(jL_fechaNacimiento);
        jL_fechaNacimiento.setBounds(50, 180, 230, 24);

        jDC_fechaNacimiento.setMinimumSize(new java.awt.Dimension(27, 24));
        jDC_fechaNacimiento.setPreferredSize(new java.awt.Dimension(95, 24));
        jDC_fechaNacimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jDC_fechaNacimientoKeyPressed(evt);
            }
        });
        jPanel1.add(jDC_fechaNacimiento);
        jDC_fechaNacimiento.setBounds(280, 180, 260, 24);

        jL_fechaNacimiento1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jL_fechaNacimiento1.setText("Fecha final dd-mm-yy :");
        jPanel1.add(jL_fechaNacimiento1);
        jL_fechaNacimiento1.setBounds(50, 230, 230, 24);

        jDC_fechaNacimiento1.setMinimumSize(new java.awt.Dimension(27, 24));
        jDC_fechaNacimiento1.setPreferredSize(new java.awt.Dimension(95, 24));
        jDC_fechaNacimiento1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jDC_fechaNacimiento1KeyPressed(evt);
            }
        });
        jPanel1.add(jDC_fechaNacimiento1);
        jDC_fechaNacimiento1.setBounds(280, 230, 260, 24);

        btn_graficar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/grafica.png"))); // NOI18N
        btn_graficar.setText("GRAFICAR");
        btn_graficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_graficarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_graficar);
        btn_graficar.setBounds(260, 330, 140, 40);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Zona");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 280, 230, 19);

        jC_zona.setMinimumSize(new java.awt.Dimension(28, 24));
        jC_zona.setPreferredSize(new java.awt.Dimension(28, 24));
        jC_zona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jC_zonaMouseClicked(evt);
            }
        });
        jC_zona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jC_zonaActionPerformed(evt);
            }
        });
        jC_zona.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jC_zonaKeyPressed(evt);
            }
        });
        jPanel1.add(jC_zona);
        jC_zona.setBounds(280, 280, 260, 24);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Tipo de grafico:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(50, 80, 230, 20);

        combox_tipo_grafico.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Eliga un tipo de grafico", "Barras", "Lineal", "Pastel" }));
        combox_tipo_grafico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combox_tipo_graficoActionPerformed(evt);
            }
        });
        jPanel1.add(combox_tipo_grafico);
        combox_tipo_grafico.setBounds(280, 80, 260, 26);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Consulta:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(50, 130, 230, 20);

        combox_datos_graficables.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elegia un dato para graficar", "Sexo de los clientes", "Clientes con mayor puntaje", "Cliente por zonas" }));
        jPanel1.add(combox_datos_graficables);
        combox_datos_graficables.setBounds(280, 130, 260, 26);

        add(jPanel1);
        jPanel1.setBounds(-10, 0, 620, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void jDC_fechaNacimientoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDC_fechaNacimientoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jC_zona.requestFocus();
        }
    }//GEN-LAST:event_jDC_fechaNacimientoKeyPressed

    private void jDC_fechaNacimiento1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDC_fechaNacimiento1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jC_zona.requestFocus();
        }
    }//GEN-LAST:event_jDC_fechaNacimiento1KeyPressed

    private void btn_graficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_graficarActionPerformed
        try {
            //Area para consultas
            String tipo_grafica = combox_tipo_grafico.getSelectedItem().toString();
             String tipo_consulta = combox_datos_graficables.getSelectedItem().toString();
            String zona = jC_zona.getSelectedItem().toString();

            if(tipo_consulta.equals("Sexo de los clientes")){
           //     sexoCliente(tipo_grafica);
            }

            if(tipo_consulta.equals("Clientes con mayor puntaje")){
               
            }

            if(tipo_consulta.equals("Cliente por zonas")){
                
            }
        } catch (Exception ex) {
            System.out.println("Error " + ex);
        }
    }//GEN-LAST:event_btn_graficarActionPerformed

    private void jC_zonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jC_zonaMouseClicked
        actualizarZonas();
    }//GEN-LAST:event_jC_zonaMouseClicked

    private void jC_zonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jC_zonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jC_zonaActionPerformed

    private void jC_zonaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jC_zonaKeyPressed

    }//GEN-LAST:event_jC_zonaKeyPressed

    private void combox_tipo_graficoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combox_tipo_graficoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combox_tipo_graficoActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                mdl_fecha_dinamica_grafica dialog = new mdl_fecha_dinamica_grafica(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    
      //Metodo para llenar el combobox zonas
    public void cargarZonas() {
        ResultSet zonas = Zona.mostrarZonas();
        //LLenamos nuestro ComboBox
        jC_zona.addItem("Elija un zona para el grafico");

        try {
            while (zonas.next()) {
                jC_zona.addItem(zonas.getString("zona"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(mdl_RegistroClientes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
         public void actualizarZonas() {
        ResultSet zonas = Zona.mostrarZonas();
        System.out.println();

        //LLenamos nuestro ComboBox
        jC_zona.removeAllItems();
        jC_zona.addItem("Elija un zona para el grafico");
        try {
            while (zonas.next()) {
                jC_zona.addItem(zonas.getString("zona"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(mdl_RegistroClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setZona(String zona) {
        this.jC_zona.addItem(zona);
    }
    
     public  void sexoCliente(String tipo_grafica){
        resultado6 = Conexion.Conexion.consulta("select sexo from Persona");
            try {
                while (resultado6.next()) {
                    Vector v = new Vector();
                   // v.add(resultado.getString(1));
                   // v.add(resultado.getString(2));
                    System.out.println("El Valor dato 1: "+resultado6.getString(1));
                    if("M".equals(resultado6.getString(1).toString())){
                       cant_M++;
                        System.out.println(cant_M);
                    }
                    
                    if("F".equals(resultado6.getString(1).toString())){
                        cant_F++;
                        System.out.println(cant_F);
                    }
               }
        }catch (Exception ex) {
                System.out.println("" + ex);  
        }
            
        int dato1 =cant_M;
        int dato2 =cant_F;
         System.out.println("M = " +cant_M + "  - - " +"F = " +cant_F );
        
   //     int dato3 = Integer.parseInt(jTextField3.getText());
//        int dato4 = Integer.parseInt(jTextField4.getText());
        datos.addValue(dato1,"Grafica Sexo","Masculino");
        datos.addValue(dato2,"Grafica Sexo","Femenino");
     /*  datos.addValue(dato3,"Grafica 1","Tres");
        datos.addValue(dato4,"Grafica 1","Cuatro");*/
        String tipoGrafica = combox_tipo_grafico.getSelectedItem().toString();

        if(tipoGrafica.equals("Barras")){
            grafico = ChartFactory.createBarChart("Grafica sexo de clientes", "Eje X - Tipo", "Eje Y - Cantidad",datos ,PlotOrientation.VERTICAL, true, true, false);
        }
        if(tipoGrafica.equals("Lineal")){
            grafico = ChartFactory.createLineChart("Grafica sexo de clientes", "Eje X - Tipo", "Eje Y- Cantidad",datos ,PlotOrientation.VERTICAL, true, true, false);
        }
        if(tipoGrafica.equals("Pastel")){
            DefaultPieDataset datosPie = new DefaultPieDataset();
            datosPie.setValue("Masculino", dato1);
            datosPie.setValue("Femenino", dato2);

            grafico = ChartFactory.createPieChart("Grafica sexo de clientes", datosPie, true, true, false);
        }

        ChartPanel cPanel = new ChartPanel(grafico);
        frmMenuPrincipal frmMenuPrincipal =  new frmMenuPrincipal();
        Dialog informacion = new Dialog(frmMenuPrincipal,true);
        informacion.add(cPanel);
        informacion.pack();
        informacion.setLocationRelativeTo(null);
        informacion.setResizable(false);
        informacion.setIconImage(new ImageIcon(getClass().getResource("../imgSP/icono.png")).getImage());
        informacion.setTitle("Grafica");  //Se pone el titulo a la ventana
        informacion.setVisible(true);
        informacion.dispose();
       // informacion.setVisible(false);
       // informacion.setDefaultCloseOperation();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_graficar;
    private javax.swing.JComboBox<String> combox_datos_graficables;
    private javax.swing.JComboBox combox_tipo_grafico;
    private javax.swing.JComboBox<String> jC_zona;
    private com.toedter.calendar.JDateChooser jDC_fechaNacimiento;
    private com.toedter.calendar.JDateChooser jDC_fechaNacimiento1;
    private javax.swing.JLabel jL_fechaNacimiento;
    private javax.swing.JLabel jL_fechaNacimiento1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblRangoPorEdad;
    // End of variables declaration//GEN-END:variables

}
