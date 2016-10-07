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
public class Gui05 extends JFrame {

    public Gui05() {
        setTitle("GridBagLayout");
        setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();

        //Area texto
        JTextArea areaTexto = new JTextArea("Area texto");

        constraints.gridx = 0; //Columna
        constraints.gridy = 0; //Fila
        
        constraints.gridwidth = 2; //Celdas que ocupara horizontal
        constraints.gridheight = 2; //Celdas que ocupara vertical
        
        constraints.weighty = 1.0; //Estirar celda fila
        
        constraints.fill = GridBagConstraints.BOTH; //Estirar el componente H y V
        
        add(areaTexto, constraints);
        
        constraints.weighty = 0.0; //Volvemos a restaurar para no afectar demas componetnes.
        
        //Campo texto
        JTextField campoTexto = new JTextField("Campo texto");

        constraints.gridx = 1; //Columna
        constraints.gridy = 2; //Fila
        
        constraints.gridwidth = 1; //Celdas que ocupara horizontal
        constraints.gridheight = 1; //Celdas que ocupara vertical
        
        constraints.weightx = 1.0; //estirar celda columna
        
        constraints.fill = GridBagConstraints.HORIZONTAL; //Estiar componente horizontal
        
        add(campoTexto, constraints);
        
        constraints.weightx = 0.0;

        //Boton1
        JButton boton1 = new JButton("Boton 1");

        constraints.gridx = 2; //Columna
        constraints.gridy = 0; //Fila
        
        constraints.gridwidth = 1; //Celdas que ocupara horizontal
        constraints.gridheight = 1; //Celdas que ocupara vertical
        
        constraints.weighty = 1.0; //Ya lo hemos hecho en areaTexto asi que aqui tambien
        
        constraints.anchor = GridBagConstraints.NORTH; //Componente en el norte !!ANCHOR
        
        add(boton1, constraints);
        
        constraints.weighty = 0.0;

        //Boton2
        JButton boton2 = new JButton("Boton 2");

        constraints.gridx = 2; //Columnas
        constraints.gridy = 1; //Filas
        
        constraints.gridwidth = 1; //Celdas que ocupara horizontal
        constraints.gridheight = 1; //Celdas que ocupara vertical
        
        constraints.weighty = 1.0; //estiar celda fila
        
        constraints.anchor = GridBagConstraints.NORTH; //Componente en el centro
        
        add(boton2, constraints);
        
        constraints.weighty = 0.0;

        //Boton3
        JButton boton3 = new JButton("Boton 3");

        constraints.gridx = 0; //Columnas
        constraints.gridy = 2; //Filas
        
        constraints.gridwidth = 1; //Celdas que ocupara horizontal
        constraints.gridheight = 1; //Celdas que ocupara vertical
        
        add(boton3, constraints);

        //Boton4
        JButton boton4 = new JButton("Boton 4");

        constraints.gridx = 2; //Columnas
        constraints.gridy = 2; //Filas
        
        constraints.gridwidth = 1; //Celdas que ocupara horizontal
        constraints.gridheight = 1; //Celdas que ocupara vertical
        
        add(boton4, constraints);

        setVisible(true);
        setSize(500, 500);
    }

    public static void main(String[] args) {
        Gui05 app = new Gui05();
    }
}
