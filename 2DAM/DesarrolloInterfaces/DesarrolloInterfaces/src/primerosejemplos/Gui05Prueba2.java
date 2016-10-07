/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primerosejemplos;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Lucas
 */
public class Gui05Prueba2 extends JFrame{
    
    public Gui05Prueba2() {
        setLayout(new GridBagLayout());
        
        GridBagConstraints constraints = new GridBagConstraints();
        
        JTextField campoTexto = new JTextField("campo de texto");
        
        constraints.gridx = 1;
        constraints.gridy = 1;
        
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        
        constraints.weightx = 1.0;
        
        constraints.anchor = GridBagConstraints.SOUTH;
        
        add(campoTexto, constraints);
        
        constraints.weightx = 0.0;
        
        JButton boton1 = new JButton("boton1");
        
        constraints.gridx = 5;
        constraints.gridy = 1;
        
        constraints.gridwidth = 1;
        constraints.gridheight = 1;

        constraints.anchor = GridBagConstraints.SOUTH;
        
        add(boton1, constraints);

        JButton boton2 = new JButton("boton2");
        
        constraints.gridx = 2;
        constraints.gridy = 3;
        
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        
        constraints.weighty = 1.0;
        
        add(boton2, constraints);
        
        JButton boton3 = new JButton("boton3");
        
        constraints.gridx = 3;
        constraints.gridy = 3;
        
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        
        add(boton3, constraints);
        
        JButton boton4 = new JButton("boton4");
        
        constraints.gridx = 5;
        constraints.gridy = 3;
        
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        
        add(boton4, constraints);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450, 450);
    }
    
    public static void main(String[] args) {
        Gui05Prueba2 app = new Gui05Prueba2();
    }
}
