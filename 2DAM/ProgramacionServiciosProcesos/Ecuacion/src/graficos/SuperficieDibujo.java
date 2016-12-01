/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Lucas
 */
public class SuperficieDibujo extends JPanel {
    
    private int ancho;
    private int alto;
    
    public SuperficieDibujo(final int ancho, final int alto) {
        this.ancho = ancho;
        this.alto = alto;
        
        configurarComponentes();
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

    }
    
        
    private void configurarComponentes() {
        GridBagConstraints constraints = new GridBagConstraints();
        
        JTextField campoTextoA = new JTextField("campo de A");
        
        constraints.gridx = 1;
        constraints.gridy = 1;
        
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        
        constraints.weightx = 1.0;
        
        constraints.anchor = GridBagConstraints.SOUTH;
        
        add(campoTextoA, constraints);
        
        JTextField campoTextoB = new JTextField("campo de B");
        
        constraints.gridx = 1;
        constraints.gridy = 1;
        
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        
        constraints.weightx = 1.0;
        
        constraints.anchor = GridBagConstraints.SOUTH;
        
        add(campoTextoB, constraints);
        
        JTextField campoTextoC = new JTextField("campo de C");
        
        constraints.gridx = 1;
        constraints.gridy = 1;
        
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        
        constraints.weightx = 1.0;
        
        constraints.anchor = GridBagConstraints.SOUTH;
        
        add(campoTextoC, constraints);
        
        JButton boton3 = new JButton("calcular");
        
        constraints.gridx = 3;
        constraints.gridy = 3;
        
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        
        add(boton3, constraints);
    }
    
    public int obtenerAncho() {
        return ancho;
    }
    public int obtenerAlto() {
        return alto;
    }
}
