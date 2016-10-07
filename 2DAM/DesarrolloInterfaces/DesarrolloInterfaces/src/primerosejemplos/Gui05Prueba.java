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
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Lucas
 */
public class Gui05Prueba extends JFrame {

    public Gui05Prueba() {
        
        setLayout(new GridBagLayout());
        
        GridBagConstraints constrains = new GridBagConstraints();

        JTextArea areaTexto = new JTextArea("area texto");

        constrains.gridx = 0;
        constrains.gridy = 0;

        constrains.gridwidth = 2;
        constrains.gridheight = 2;

        constrains.weighty = 1.0;
        
        constrains.fill = GridBagConstraints.BOTH;

        add(areaTexto, constrains);

        constrains.weighty = 0.0;

        JButton boton1 = new JButton("boton1");

        constrains.gridx = 2;
        constrains.gridy = 0;

        constrains.gridwidth = 1;
        constrains.gridheight = 1;
        
        constrains.weighty = 1.0;
        
        constrains.fill = GridBagConstraints.NONE;
        
        constrains.anchor = GridBagConstraints.CENTER;

        add(boton1, constrains);
        
        constrains.weighty = 0.0;

        JButton boton2 = new JButton("boton2");

        constrains.gridx = 2;
        constrains.gridy = 1;

        constrains.gridwidth = 1;
        constrains.gridheight = 1;

        constrains.weighty = 1.0;

        add(boton2, constrains);
        
        constrains.weighty = 0.0;

        JButton boton3 = new JButton("boton3");

        constrains.gridx = 0;
        constrains.gridy = 2;

        constrains.gridwidth = 1;
        constrains.gridheight = 1;

        add(boton3, constrains);

        JButton boton4 = new JButton("boton4");

        constrains.gridx = 2;
        constrains.gridy = 2;

        constrains.gridwidth = 1;
        constrains.gridheight = 1;

        add(boton4, constrains);

        JTextField campoTexto = new JTextField("campo texto");

        constrains.gridx = 1;
        constrains.gridy = 2;

        constrains.gridwidth = 1;
        constrains.gridheight = 1;
        
        constrains.weightx = 1.0;
        
        constrains.fill = GridBagConstraints.HORIZONTAL;

        add(campoTexto, constrains);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 300);
    }

    public static void main(String[] args) {
        Gui05Prueba app = new Gui05Prueba();
    }
}
