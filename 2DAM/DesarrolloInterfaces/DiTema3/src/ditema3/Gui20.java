/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ditema3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Lucas
 */
public class Gui20 extends JFrame {

    PanelDatos pd;
    SuperficieDibujo sd;

    
    public Gui20() {
        setLayout(new BorderLayout());
        setTitle("Titulo");
        setVisible(true);
        setSize(500, 500);
       

        pd = new PanelDatos();
        sd = new SuperficieDibujo();
        add(sd, BorderLayout.CENTER);
        if (JOptionPane.showConfirmDialog(this, pd, "Introduzca Datos",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE)
                == JOptionPane.OK_OPTION) {
        }
    }

    public static void main(String[] args) {
        Gui20 f = new Gui20();
    }
}

class PanelDatos extends JPanel {

    public JTextField campoNombre;
    public JTextField campoApellidos;
    public JTextField campoNP;

    public PanelDatos() {
        setLayout(new GridLayout(4, 2));
        JLabel etiquetaNombre = new JLabel("Nombre: ", JLabel.RIGHT);
        campoNombre = new JTextField();
        add(etiquetaNombre);
        add(campoNombre);

        JLabel etiquetaApellidos = new JLabel("Apellidos: ", JLabel.RIGHT);
        campoApellidos = new JTextField();
        add(etiquetaApellidos);
        add(campoApellidos);

        JLabel etiquetaNP = new JLabel("Numero Personal: ", JLabel.RIGHT);
        campoNP = new JTextField();
        
        add(etiquetaNP);
        add(campoNP);

        ButtonGroup grupoBotones = new ButtonGroup();
        JRadioButton mañana = new JRadioButton("Grupo Mañana");
        JRadioButton tarde = new JRadioButton("Grupo tarde");
        grupoBotones.add(mañana);
        grupoBotones.add(tarde);
        add(mañana);
        add(tarde);
    }
}

class SuperficieDibujo extends JPanel {

    JButton boton;

    public SuperficieDibujo() {
        setLayout(new BorderLayout());
        boton = new JButton();
        add(boton, BorderLayout.CENTER);
    }


}
