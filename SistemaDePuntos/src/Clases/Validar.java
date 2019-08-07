/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.event.KeyAdapter;
import javax.swing.JTextField;
import java.awt.event.KeyEvent;
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
    
    public void ValidarSolonumeros(JTextField campo){
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
    
     public void limitarCaracteres(JTextField campo, int cantidad){
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                int tamaño =campo.getText().length();
                if (tamaño>=cantidad){
                    e.consume();
                    JOptionPane.showMessageDialog(null,"Estas introducuiendo caracteres de mas");
                    
                }
            }
});
    }
    
}
