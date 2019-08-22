package frmArea;

import Clases.Persona;
import Clases.Validar;
import Clases.Zona;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * @author bayron
 */
public class frmRegistroClientes extends javax.swing.JFrame {

    Date fecha = new Date(1);
    ResultSet res = null;
    int cont = 0;
    Validar v = new Validar();

    public frmRegistroClientes() {
        initComponents();
        this.setLocationRelativeTo(null); //para ponerse en el centro         
        this.setResizable(false); //Desactivar botón maximizar de una ventana
        setIconImage(new ImageIcon(getClass().getResource("../imgSP/icono.png")).getImage()); //cambia el icono del formulario

        cargarZonas();//  Cargar las zonas en el combobox zonas
        v.ValidarSoloLetras(txt_primerNombre);
        v.ValidarSoloLetras(txt_segundoNombre);
        v.ValidarSoloLetras(txt_primerApellido);
        v.ValidarSoloLetras(txt_segundoApellido);
        v.ValidarTelefono(txt_telefono1);
        v.ValidarTelefono(txt_telefono2);
        v.ValidarTelefono(txt_telefono3);
        v.ValidarIdentidad(txt_noIdentidad);
        v.limitarCaracteres(txt_telefono1, 13);
        v.limitarCaracteres(txt_telefono2, 13);
        v.limitarCaracteres(txt_telefono3, 13);
        v.limitarCaracteres(txt_noIdentidad, 15);
        //v.validarCorreo(txt_correoElectronico.getText());
       
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jP1_DatosCliente = new javax.swing.JPanel();
        SegundoNombre = new javax.swing.JLabel();
        PrimerApellido = new javax.swing.JLabel();
        SegundoApelliido = new javax.swing.JLabel();
        NoIdentidad = new javax.swing.JLabel();
        Telefono2 = new javax.swing.JLabel();
        CorreoElectronico = new javax.swing.JLabel();
        txt_primerNombre = new javax.swing.JTextField();
        txt_segundoNombre = new javax.swing.JTextField();
        txt_primerApellido = new javax.swing.JTextField();
        txt_segundoApellido = new javax.swing.JTextField();
        txt_noIdentidad = new javax.swing.JTextField();
        txt_telefono3 = new javax.swing.JTextField();
        PrimerNombre = new javax.swing.JLabel();
        txt_correoElectronico = new javax.swing.JTextField();
        jP2_DatosCliente = new javax.swing.JPanel();
        jL_Sexo = new javax.swing.JLabel();
        jC_Sexo = new javax.swing.JComboBox<>();
        jL_fechaNacimiento = new javax.swing.JLabel();
        jDC_fechaNacimiento = new com.toedter.calendar.JDateChooser();
        txt_telefono1 = new javax.swing.JTextField();
        txt_telefono2 = new javax.swing.JTextField();
        jP_DatosDireccion = new javax.swing.JPanel();
        jL_TituloDireccion = new javax.swing.JLabel();
        jL_DetalleDirecion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descripcion = new javax.swing.JTextArea();
        jL_Zona = new javax.swing.JLabel();
        jC_zona = new javax.swing.JComboBox<>();
        Telefono1 = new javax.swing.JLabel();
        Telefono3 = new javax.swing.JLabel();
        panel_botonesBasicos = new javax.swing.JPanel();
        btn_guardarCliente = new javax.swing.JButton();
        btn_menuInicio = new javax.swing.JButton();
        btn_limpiarCampos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro Cliente");
        setMaximumSize(new java.awt.Dimension(496, 645));
        setMinimumSize(new java.awt.Dimension(496, 645));
        setName("Registro Cliente"); // NOI18N
        setPreferredSize(new java.awt.Dimension(496, 645));
        getContentPane().setLayout(null);

        jP1_DatosCliente.setLayout(null);

        SegundoNombre.setText("Segundo nombre:");
        SegundoNombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jP1_DatosCliente.add(SegundoNombre);
        SegundoNombre.setBounds(10, 37, 110, 22);

        PrimerApellido.setText("Primer apellido:");
        PrimerApellido.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jP1_DatosCliente.add(PrimerApellido);
        PrimerApellido.setBounds(10, 63, 110, 22);

        SegundoApelliido.setText("Segundo apellido:");
        SegundoApelliido.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jP1_DatosCliente.add(SegundoApelliido);
        SegundoApelliido.setBounds(10, 89, 110, 22);

        NoIdentidad.setText("No. Identidad:");
        NoIdentidad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jP1_DatosCliente.add(NoIdentidad);
        NoIdentidad.setBounds(10, 115, 110, 22);

        Telefono2.setText("Teléfono 3:");
        Telefono2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jP1_DatosCliente.add(Telefono2);
        Telefono2.setBounds(10, 200, 110, 22);

        CorreoElectronico.setText("Correo electrónico:");
        CorreoElectronico.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jP1_DatosCliente.add(CorreoElectronico);
        CorreoElectronico.setBounds(10, 230, 110, 22);

        txt_primerNombre.setMinimumSize(new java.awt.Dimension(8, 22));
        txt_primerNombre.setPreferredSize(new java.awt.Dimension(8, 24));
        txt_primerNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_primerNombreActionPerformed(evt);
            }
        });
        txt_primerNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_primerNombreKeyPressed(evt);
            }
        });
        jP1_DatosCliente.add(txt_primerNombre);
        txt_primerNombre.setBounds(120, 10, 330, 24);

        txt_segundoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_segundoNombreActionPerformed(evt);
            }
        });
        txt_segundoNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_segundoNombreKeyPressed(evt);
            }
        });
        jP1_DatosCliente.add(txt_segundoNombre);
        txt_segundoNombre.setBounds(120, 37, 330, 24);

        txt_primerApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_primerApellidoActionPerformed(evt);
            }
        });
        txt_primerApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_primerApellidoKeyPressed(evt);
            }
        });
        jP1_DatosCliente.add(txt_primerApellido);
        txt_primerApellido.setBounds(120, 63, 330, 24);

        txt_segundoApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_segundoApellidoActionPerformed(evt);
            }
        });
        txt_segundoApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_segundoApellidoKeyPressed(evt);
            }
        });
        jP1_DatosCliente.add(txt_segundoApellido);
        txt_segundoApellido.setBounds(120, 89, 330, 24);

        txt_noIdentidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_noIdentidadActionPerformed(evt);
            }
        });
        txt_noIdentidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_noIdentidadKeyPressed(evt);
            }
        });
        jP1_DatosCliente.add(txt_noIdentidad);
        txt_noIdentidad.setBounds(120, 115, 330, 24);

        txt_telefono3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_telefono3ActionPerformed(evt);
            }
        });
        txt_telefono3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_telefono3KeyPressed(evt);
            }
        });
        jP1_DatosCliente.add(txt_telefono3);
        txt_telefono3.setBounds(120, 200, 330, 24);

        PrimerNombre.setText("Primer nombre:");
        PrimerNombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jP1_DatosCliente.add(PrimerNombre);
        PrimerNombre.setBounds(10, 11, 110, 22);

        txt_correoElectronico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_correoElectronicoKeyPressed(evt);
            }
        });
        jP1_DatosCliente.add(txt_correoElectronico);
        txt_correoElectronico.setBounds(120, 230, 330, 24);

        jP2_DatosCliente.setLayout(null);

        jL_Sexo.setText("Sexo:");
        jL_Sexo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jL_Sexo.setPreferredSize(new java.awt.Dimension(98, 20));
        jP2_DatosCliente.add(jL_Sexo);
        jL_Sexo.setBounds(0, 0, 110, 20);

        jC_Sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));
        jC_Sexo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jC_Sexo.setMinimumSize(new java.awt.Dimension(33, 24));
        jC_Sexo.setPreferredSize(new java.awt.Dimension(33, 24));
        jC_Sexo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jC_SexoKeyPressed(evt);
            }
        });
        jP2_DatosCliente.add(jC_Sexo);
        jC_Sexo.setBounds(110, 0, 330, 24);

        jL_fechaNacimiento.setText("Fecha nacimiento dd-mm-yy :");
        jL_fechaNacimiento.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jP2_DatosCliente.add(jL_fechaNacimiento);
        jL_fechaNacimiento.setBounds(0, 30, 200, 24);

        jDC_fechaNacimiento.setMinimumSize(new java.awt.Dimension(27, 24));
        jDC_fechaNacimiento.setPreferredSize(new java.awt.Dimension(95, 24));
        jDC_fechaNacimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jDC_fechaNacimientoKeyPressed(evt);
            }
        });
        jP2_DatosCliente.add(jDC_fechaNacimiento);
        jDC_fechaNacimiento.setBounds(200, 30, 240, 24);

        jP1_DatosCliente.add(jP2_DatosCliente);
        jP2_DatosCliente.setBounds(10, 260, 450, 69);

        txt_telefono1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_telefono1ActionPerformed(evt);
            }
        });
        txt_telefono1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_telefono1KeyPressed(evt);
            }
        });
        jP1_DatosCliente.add(txt_telefono1);
        txt_telefono1.setBounds(120, 141, 330, 24);

        txt_telefono2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_telefono2ActionPerformed(evt);
            }
        });
        txt_telefono2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_telefono2KeyPressed(evt);
            }
        });
        jP1_DatosCliente.add(txt_telefono2);
        txt_telefono2.setBounds(120, 170, 330, 24);

        jP_DatosDireccion.setLayout(null);

        jL_TituloDireccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jL_TituloDireccion.setText("Dirección");
        jL_TituloDireccion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jL_TituloDireccion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jP_DatosDireccion.add(jL_TituloDireccion);
        jL_TituloDireccion.setBounds(10, 0, 413, 22);

        jL_DetalleDirecion.setText("Detalle:");
        jL_DetalleDirecion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jP_DatosDireccion.add(jL_DetalleDirecion);
        jL_DetalleDirecion.setBounds(10, 52, 76, 22);

        descripcion.setColumns(20);
        descripcion.setRows(5);
        jScrollPane1.setViewportView(descripcion);

        jP_DatosDireccion.add(jScrollPane1);
        jScrollPane1.setBounds(90, 52, 333, 83);

        jL_Zona.setText("Zona:");
        jL_Zona.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jP_DatosDireccion.add(jL_Zona);
        jL_Zona.setBounds(10, 26, 76, 22);

        jC_zona.setMinimumSize(new java.awt.Dimension(28, 24));
        jC_zona.setPreferredSize(new java.awt.Dimension(28, 24));
        jC_zona.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jC_zonaKeyPressed(evt);
            }
        });
        jP_DatosDireccion.add(jC_zona);
        jC_zona.setBounds(90, 24, 180, 24);

        jP1_DatosCliente.add(jP_DatosDireccion);
        jP_DatosDireccion.setBounds(0, 330, 460, 160);

        Telefono1.setText("Teléfono Principal:");
        Telefono1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jP1_DatosCliente.add(Telefono1);
        Telefono1.setBounds(10, 141, 110, 22);

        Telefono3.setText("Teléfono 2:");
        Telefono3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jP1_DatosCliente.add(Telefono3);
        Telefono3.setBounds(10, 170, 110, 22);

        panel_botonesBasicos.setLayout(null);

        btn_guardarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/guardar.png"))); // NOI18N
        btn_guardarCliente.setText("Guardar");
        btn_guardarCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_guardarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarClienteActionPerformed(evt);
            }
        });
        panel_botonesBasicos.add(btn_guardarCliente);
        btn_guardarCliente.setBounds(20, 10, 105, 49);

        btn_menuInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/volverMenu.png"))); // NOI18N
        btn_menuInicio.setText("Atrás");
        btn_menuInicio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_menuInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_menuInicioActionPerformed(evt);
            }
        });
        panel_botonesBasicos.add(btn_menuInicio);
        btn_menuInicio.setBounds(300, 10, 95, 49);

        btn_limpiarCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgSP/limpiar.png"))); // NOI18N
        btn_limpiarCampos.setText("Limpiar");
        btn_limpiarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarCamposActionPerformed(evt);
            }
        });
        panel_botonesBasicos.add(btn_limpiarCampos);
        btn_limpiarCampos.setBounds(160, 10, 110, 50);

        jP1_DatosCliente.add(panel_botonesBasicos);
        panel_botonesBasicos.setBounds(30, 480, 410, 70);

        getContentPane().add(jP1_DatosCliente);
        jP1_DatosCliente.setBounds(20, 40, 470, 570);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Registro de Cliente");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(160, 10, 180, 22);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_segundoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_segundoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_segundoNombreActionPerformed

    private void txt_primerApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_primerApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_primerApellidoActionPerformed

    private void txt_noIdentidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_noIdentidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_noIdentidadActionPerformed

    private void txt_segundoApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_segundoApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_segundoApellidoActionPerformed

    private void txt_telefono3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telefono3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telefono3ActionPerformed

    //Guardar clientes
    private void btn_guardarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarClienteActionPerformed

        String sexo = (String) jC_Sexo.getSelectedItem();
        if (txt_primerNombre.getText().isEmpty() || txt_primerApellido.getText().isEmpty() || txt_noIdentidad.getText().isEmpty()
                || txt_telefono1.getText().isEmpty() || sexo.isEmpty() || jDC_fechaNacimiento.getCalendar() == null
                || jC_zona.getSelectedItem() == null) {

            JOptionPane.showMessageDialog(this, "Se dejaron vacios campos que son obligatorios", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {   //Esta consulta es para validar que no se inserte un registro duplicado
                res = Conexion.Conexion.consulta("SELECT COUNT(identidad) from persona WHERE identidad='" + txt_noIdentidad.getText() + "'");
                try {
                    while (res.next()) {
                        cont = res.getInt(1);
                    }
                } catch (SQLException e) {
                }
                if (cont >= 1) {
                    JOptionPane.showMessageDialog(this, "Esta persona ya está registrada", "Informacion", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    //PREPARO LA FECHA PARA ENVIARLA    
                    java.sql.Date fechaNac = new java.sql.Date(jDC_fechaNacimiento.getDate().getTime());

                    //Consulto el id de la zona que eligio el usuario para registrarla en la tabla clientes
                    ResultSet respuesta = Zona.consultarIdZona((String) jC_zona.getSelectedItem());
                    int idZona = 0;

                    while (respuesta.next()) {
                        idZona = respuesta.getInt(1);
                    }

                    Procedimientos.ProcedimientosCliente.guardarPersona(txt_primerNombre.getText(), txt_segundoNombre.getText(),
                            txt_primerApellido.getText(), txt_segundoApellido.getText(), txt_noIdentidad.getText(), txt_correoElectronico.getText(),
                            sexo, fechaNac, idZona, descripcion.getText(), txt_telefono1.getText(), txt_telefono2.getText(),
                            txt_telefono3.getText());

                    //Limpiar los campos
                    txt_primerNombre.setText("");
                    txt_segundoNombre.setText("");
                    txt_primerApellido.setText("");
                    txt_segundoApellido.setText("");
                    txt_noIdentidad.setText("");
                    txt_correoElectronico.setText("");
                    txt_telefono1.setText("");
                    txt_telefono2.setText("");
                    txt_telefono3.setText("");
                    jC_Sexo.setSelectedIndex(0);
                    jDC_fechaNacimiento.setCalendar(null);
                    jC_zona.setSelectedIndex(0);
                    descripcion.setText("");
                    txt_primerNombre.requestFocus();
                    txt_segundoNombre.requestFocus();
                    txt_primerApellido.requestFocus();
                    txt_segundoApellido.requestFocus();
                    txt_noIdentidad.requestFocus();
                    txt_correoElectronico.requestFocus();
                    txt_telefono1.requestFocus();
                    txt_telefono2.requestFocus();
                    txt_telefono3.requestFocus();
                    jC_Sexo.requestFocus();
                    jDC_fechaNacimiento.requestFocus();
                    jC_zona.requestFocus();
                    descripcion.requestFocus();

                    //Obtener fecha del sistema para agregarla como fecha de registro del cliente
                    java.util.Date fechaActual = new java.util.Date();
                    java.sql.Date fechaRegistro = new java.sql.Date(fechaActual.getTime());//Convertir a fecha compatible con sql

                    //Almancena el id de la persona en la tabla de clientes
                    Procedimientos.ProcedimientosCliente.guardarCliente(fechaRegistro, Persona.UltimoRegistro());

                    JOptionPane.showMessageDialog(this, "Registro guardado");

                }
            } catch (SQLException e) {
            }
        }
    }//GEN-LAST:event_btn_guardarClienteActionPerformed

    private void txt_primerNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_primerNombreActionPerformed

    }//GEN-LAST:event_txt_primerNombreActionPerformed

    private void btn_menuInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_menuInicioActionPerformed
        frmMenuPrincipal ver = new frmMenuPrincipal();
        ver.setVisible(true); // visible ventana del objeto
        this.setVisible(false); // ocultar

    }//GEN-LAST:event_btn_menuInicioActionPerformed

    private void txt_telefono1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telefono1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telefono1ActionPerformed

    private void txt_telefono2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telefono2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telefono2ActionPerformed

    //Limpiar los campos
    private void btn_limpiarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarCamposActionPerformed

        txt_primerNombre.setText("");
        txt_segundoNombre.setText("");
        txt_primerApellido.setText("");
        txt_segundoApellido.setText("");
        txt_noIdentidad.setText("");
        txt_correoElectronico.setText("");
        txt_telefono1.setText("");
        txt_telefono2.setText("");
        txt_telefono3.setText("");
        jC_Sexo.setSelectedIndex(0);
        jDC_fechaNacimiento.setCalendar(null);
        jC_zona.setSelectedIndex(0);
        descripcion.setText("");
    }//GEN-LAST:event_btn_limpiarCamposActionPerformed

    private void txt_primerNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_primerNombreKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_segundoNombre.requestFocus();
        }
    }//GEN-LAST:event_txt_primerNombreKeyPressed

    private void txt_segundoNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_segundoNombreKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_primerApellido.requestFocus();
        }
    }//GEN-LAST:event_txt_segundoNombreKeyPressed

    private void txt_primerApellidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_primerApellidoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_segundoApellido.requestFocus();
        }
    }//GEN-LAST:event_txt_primerApellidoKeyPressed

    private void txt_segundoApellidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_segundoApellidoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_noIdentidad.requestFocus();
        }
    }//GEN-LAST:event_txt_segundoApellidoKeyPressed

    private void txt_noIdentidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_noIdentidadKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_telefono1.requestFocus();
        }
    }//GEN-LAST:event_txt_noIdentidadKeyPressed

    private void txt_telefono1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telefono1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_telefono2.requestFocus();
        }
    }//GEN-LAST:event_txt_telefono1KeyPressed

    private void txt_telefono2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telefono2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_telefono3.requestFocus();
        }
    }//GEN-LAST:event_txt_telefono2KeyPressed

    private void txt_telefono3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telefono3KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_correoElectronico.requestFocus();
        }
    }//GEN-LAST:event_txt_telefono3KeyPressed

    private void txt_correoElectronicoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_correoElectronicoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Pattern pattern = Pattern
                    .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

            Matcher mather = pattern.matcher((CharSequence) txt_correoElectronico.getText());
            if (mather.find() == false) {
                JOptionPane.showMessageDialog(null, "Correo invalido");
            }else{
                jC_Sexo.requestFocus();
            }
        }

    }//GEN-LAST:event_txt_correoElectronicoKeyPressed

    private void jC_SexoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jC_SexoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jDC_fechaNacimiento.requestFocus();
        }
    }//GEN-LAST:event_jC_SexoKeyPressed

    private void jDC_fechaNacimientoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDC_fechaNacimientoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jC_zona.requestFocus();
        }
    }//GEN-LAST:event_jDC_fechaNacimientoKeyPressed

    private void jC_zonaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jC_zonaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            descripcion.requestFocus();
        }
    }//GEN-LAST:event_jC_zonaKeyPressed

    //Metodo para llenar el combobox zonas
    public void cargarZonas() {
        ResultSet zonas = Zona.mostrarZonas();
        //LLenamos nuestro ComboBox
        jC_zona.addItem("--Seleccione una zona--");

        try {
            while (zonas.next()) {
                jC_zona.addItem(zonas.getString("zona"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(frmRegistroClientes.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(frmRegistroClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmRegistroClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmRegistroClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmRegistroClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmRegistroClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CorreoElectronico;
    private javax.swing.JLabel NoIdentidad;
    private javax.swing.JLabel PrimerApellido;
    private javax.swing.JLabel PrimerNombre;
    private javax.swing.JLabel SegundoApelliido;
    private javax.swing.JLabel SegundoNombre;
    private javax.swing.JLabel Telefono1;
    private javax.swing.JLabel Telefono2;
    private javax.swing.JLabel Telefono3;
    private javax.swing.JButton btn_guardarCliente;
    private javax.swing.JButton btn_limpiarCampos;
    private javax.swing.JButton btn_menuInicio;
    private javax.swing.JTextArea descripcion;
    private javax.swing.JComboBox<String> jC_Sexo;
    private javax.swing.JComboBox<String> jC_zona;
    private com.toedter.calendar.JDateChooser jDC_fechaNacimiento;
    private javax.swing.JLabel jL_DetalleDirecion;
    private javax.swing.JLabel jL_Sexo;
    private javax.swing.JLabel jL_TituloDireccion;
    private javax.swing.JLabel jL_Zona;
    private javax.swing.JLabel jL_fechaNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jP1_DatosCliente;
    private javax.swing.JPanel jP2_DatosCliente;
    private javax.swing.JPanel jP_DatosDireccion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel_botonesBasicos;
    private javax.swing.JTextField txt_correoElectronico;
    private javax.swing.JTextField txt_noIdentidad;
    private javax.swing.JTextField txt_primerApellido;
    private javax.swing.JTextField txt_primerNombre;
    private javax.swing.JTextField txt_segundoApellido;
    private javax.swing.JTextField txt_segundoNombre;
    private javax.swing.JTextField txt_telefono1;
    private javax.swing.JTextField txt_telefono2;
    private javax.swing.JTextField txt_telefono3;
    // End of variables declaration//GEN-END:variables
}
