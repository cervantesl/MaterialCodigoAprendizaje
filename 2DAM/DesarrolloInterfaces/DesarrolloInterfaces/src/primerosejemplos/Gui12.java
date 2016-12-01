/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primerosejemplos;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Lucas
 */
public class Gui12 extends JFrame {

    public JButton botonRojo = new JButton("ROJO");
    public JButton botonAzul = new JButton("AZUL");
    public Container p = new Container();
    public Gui12() {
        
        setLayout(new FlowLayout());
        add(botonRojo);
        p = this.getContentPane();
        botonRojo.addActionListener(new ColorFondo());
        setSize(200, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        Gui12 g = new Gui12();
    }

    class ColorFondo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            p.setBackground(Color.red);
        }

    }
}
