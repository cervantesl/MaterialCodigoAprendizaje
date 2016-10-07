/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primerosejemplos;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Lucas
 */
public class Gui10 extends JFrame{

    JButton botonCopiar;
    JTextField campoValor, resultado;
    
    public Gui10() {
        setLayout(new FlowLayout());
        //add(new JLabel("Valor: "))
    }
    public static void main(String[] args) {
        Gui10 app = new Gui10();
        
        
        
        
        //add(resultado)
    }
}

class oyenteBoton implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
