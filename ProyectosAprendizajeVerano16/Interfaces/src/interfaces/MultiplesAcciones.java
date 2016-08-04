/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Lucas
 */
public class MultiplesAcciones {
    public static void main(String[] args) {
        MarcoAccion marco = new MarcoAccion();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }
}

class MarcoAccion extends JFrame{
    public MarcoAccion(){
        setTitle("Acciones");
        setBounds(600, 350, 600, 300);
        
        PanelAccion lamina = new PanelAccion();
        add(lamina);
    }
}

class PanelAccion extends JPanel{
    public PanelAccion(){
        
        AccionColor accionRojo = new AccionColor("Rojo",new ImageIcon("src/interfaces/Red.png"), Color.red);
        AccionColor botonAmarillo = new AccionColor("Amarillo", new ImageIcon(), Color.YELLOW);
        
        
        add(new JButton(accionRojo));
        add(new JButton(botonAmarillo));

    }
    class AccionColor extends AbstractAction{

        public AccionColor(String nombre, Icon icono, Color color){
            putValue(Action.NAME, nombre);
            putValue(Action.SMALL_ICON, icono);
            putValue(Action.SHORT_DESCRIPTION, "Poner la lamina de color: " + nombre);
            putValue("color_de_fondo", color);
        }
        @Override
        public void actionPerformed(ActionEvent ae) { //Para darle funcionalidad al ser pulsado el boton
            Color c = (Color) getValue("color_de_fondo");

                setBackground(c); //Tiene que extender de JPanel para que funcione (por eso lo hacemos subclase)

        }
    
    }
}

