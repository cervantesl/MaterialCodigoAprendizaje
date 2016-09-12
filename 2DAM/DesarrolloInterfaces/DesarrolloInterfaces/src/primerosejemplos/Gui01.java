package primerosejemplos;

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Gui01 {

    private Container panel;
    private JButton boton;

    public Gui01() {
        JFrame jframe = new JFrame("Ejemplo");
        panel = jframe.getContentPane();
        boton = new JButton("aceptar");
        
        panel.add(boton);
        
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.pack();


    }

    public static void main(String[] args) {
        Gui01 aplicacion = new Gui01();
    }
}
