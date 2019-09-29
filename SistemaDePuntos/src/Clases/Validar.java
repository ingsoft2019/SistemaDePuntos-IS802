/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import com.toedter.calendar.JDateChooser;
import groovy.sql.Sql;
import java.awt.Button;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import javax.swing.JTextField;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 *
 * @author ColindresRivera
 */
public class Validar {

    public void ValidarSoloLetras(JTextField campo) {
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isDigit(c)) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "No puedes agregar numeros");
                    //campo.setText(null);
                    campo.setCursor(null);

                } else if ((int) e.getKeyChar() > 32 && (int) e.getKeyChar() <= 47
                        || (int) e.getKeyChar() >= 58 && (int) e.getKeyChar() <= 64
                        || (int) e.getKeyChar() >= 91 && (int) e.getKeyChar() <= 96
                        || (int) e.getKeyChar() >= 123 && (int) e.getKeyChar() <= 126) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "No puedes agregar caracteres ajenos al alfabeto");
                    campo.setText(null);
                    campo.setCursor(null);
                }
            }
        });
    }

    public void ValidarIdentidad(JTextField campo) {
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if ((int) e.getKeyChar() >= 32 && (int) e.getKeyChar() <= 44
                        || (int) e.getKeyChar() >= 46 && (int) e.getKeyChar() <= 47
                        || (int) e.getKeyChar() >= 58 && (int) e.getKeyChar() <= 126) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "No puedes agregar letras o caracteres");
                    //campo.setText(null);
                }
            }
        });
    }
    
    public boolean validarFecha(java.util.Date fechaIngresada){
        boolean fechaValida = true;
        
        java.util.Date fechaActual = new java.util.Date();
        if(fechaActual.before(fechaIngresada)){
            fechaValida = false;
        }
        return fechaValida;
    }

    public void ValidarTelefono(JTextField campo) {
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if ((int) e.getKeyChar() >= 32 && (int) e.getKeyChar() <= 39
                        || (int) e.getKeyChar() >= 42 && (int) e.getKeyChar() <= 47
                        || (int) e.getKeyChar() >= 58 && (int) e.getKeyChar() <= 126) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "No puedes agregar letras o caracteres");
                    //campo.setText(null);
                }
            }
        });
    }

    public void limitarCaracteres(JTextField campo, int cantidad) {
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                int tamaño = campo.getText().length();
                if (tamaño >= cantidad) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Estas pasando el limite de caracteres");
                    campo.requestFocus();
                }
            }
        });
    }

    public boolean validarCorreo(JTextField correo) {
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher((CharSequence) correo.getText());
        return mather.find();

    }

    public void validarEspacios(JTextField campo) {
        //JOptionPane.showMessageDialog(null, "No se permite espacios en blanco", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        campo.setText(campo.getText().trim());
        campo.requestFocus();
    }

    public void ValidarBusqueda(JTextField campo) {
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if ((int) e.getKeyChar() >= 33 && (int) e.getKeyChar() <= 39
                        || (int) e.getKeyChar() >= 42 && (int) e.getKeyChar() <= 44
                        || (int) e.getKeyChar() >= 46 && (int) e.getKeyChar() <= 47
                        || (int) e.getKeyChar() >= 58 && (int) e.getKeyChar() <= 64
                        || (int) e.getKeyChar() >= 91 && (int) e.getKeyChar() <= 96
                        || (int) e.getKeyChar() >= 123 && (int) e.getKeyChar() <= 126) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Solo puedes usar caracteres alfanumericos,-,()");
                    campo.setText(null);
                }
            }
        });
    }

    public void validarModificacionFecha(JDateChooser fecha, JButton editarCliente) {
        fecha.getDateEditor().getUiComponent().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarCliente.setEnabled(true);
            }
        });
    }
    
}
