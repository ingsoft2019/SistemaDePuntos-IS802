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
                    JOptionPane.showMessageDialog(null,"No puedes agregar numeros en este campo");
                    
                }
            }
});
    }
    
    public void ValidarSolonumeros(JTextField campo){
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                
                if (!Character.isDigit(c)){
                    e.consume();
                    JOptionPane.showMessageDialog(null,"No puedes agregar letras en este campo");
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
