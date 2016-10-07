/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primerosejemplos;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Lucas
 */

public class Gui09 extends JFrame{
    
    JButton boton;
    
    public Gui09() {
        boton = new JButton("Beep");
        add(boton);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        
        boton.addActionListener(new miOyente());
    }
    
    public static void main(String[] args) {
        Gui09 beep = new Gui09();
    }
}


class miOyente implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Toolkit.getDefaultToolkit().beep();
    }
}
