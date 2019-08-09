/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.TextField;
import java.awt.event.KeyAdapter;
import javax.swing.JTextField;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
/**
 *
 * @author ColindresRivera
 */
public class Validar {
    public void ValidarSoloLetras(JTextField campo){
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();  
                if (Character.isDigit(c)){
                    e.consume();
                    JOptionPane.showMessageDialog(null,"No puedes agregar numeros");
                    campo.setText(null);
                    campo.setCursor(null);
                    
                }else if ((int)e.getKeyChar()>32 && (int)e.getKeyChar()<=47
                        || (int)e.getKeyChar()>=58 && (int)e.getKeyChar()<=64
                        || (int)e.getKeyChar()>=91 && (int)e.getKeyChar()<=96
                        || (int)e.getKeyChar()>=123 && (int)e.getKeyChar()<=126){
                    e.consume();
                    JOptionPane.showMessageDialog(null, "No puedes agregar caracteres ajenos al alfabeto");
                    campo.setText(null);
                    campo.setCursor(null);
                }
            }
});
    }
    
    public void ValidarIdentidad(JTextField campo){
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                
               if((int)e.getKeyChar()>=32 && (int)e.getKeyChar()<=44
                       || (int)e.getKeyChar()>=46 && (int)e.getKeyChar()<=47
                       || (int)e.getKeyChar()>=58 && (int)e.getKeyChar()<=126){
                   e.consume();
                   JOptionPane.showMessageDialog(null, "No puedes agregar letras o caracteres");
                   campo.setText(null);
               }
            }
});
    }
    
    
    public void ValidarTelefono(JTextField campo){
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                
               if((int)e.getKeyChar()>=32 && (int)e.getKeyChar()<=39
                       || (int)e.getKeyChar()>=42 && (int)e.getKeyChar()<=47
                       || (int)e.getKeyChar()>=58 && (int)e.getKeyChar()<=126){
                   e.consume();
                   JOptionPane.showMessageDialog(null, "No puedes agregar letras o caracteres");
                   campo.setText(null);
               }
            }
});
    }
    
     public void limitarCaracteres(JTextField campo, int cantidad){
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                int tamaño =campo.getText().length();
                if (tamaño>=cantidad){
                    e.consume();
                    JOptionPane.showMessageDialog(null,"Estas pasando el limite de caracteres");
                    
                }
            }
});
    }
     
     public boolean validarCorreo(String correo){
         // Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
        Matcher mather = pattern.matcher((CharSequence) correo);
        if (mather.find() == false) {
            JOptionPane.showMessageDialog(null, "Correo invalido");
        } 
        return mather.find();
     }
     
    /* public void validarDetalleDireccion(JTextField campo){
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();  
                if((int)e.getKeyChar()>32 && (int)e.getKeyChar()<=43
                        || (int)e.getKeyChar()>=58 && (int)e.getKeyChar()<=64
                        || (int)e.getKeyChar()>=91 && (int)e.getKeyChar()<=96
                        || (int)e.getKeyChar()>=123 && (int)e.getKeyChar()<=126){
                    e.consume();
                    JOptionPane.showMessageDialog(null,"No puedes agregar caracteres ajenos al alfabeto");
                    campo.setText(null);
                    campo.setCursor(null);
                    
                }
            }
});
    }*/
    
}
