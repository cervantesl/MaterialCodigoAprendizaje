/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class EventosFuera {
    public static EventosFuera eventosFuera;
    public RendererIII renderer;
    
    public EventosFuera(){
        JFrame jframe = new JFrame();
        renderer = new RendererIII();
        jframe.setSize(800, 800);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
        jframe.setResizable(false);

        jframe.add(renderer);
    }

    
    
    
    
    public static void main(String[] args) {
        eventosFuera = new EventosFuera();
    }
}

class RendererIII extends JPanel{
    JButton botonAzul = new JButton("Azul");
    JButton botonRojo = new JButton("Rojo");
    
    
    public RendererIII(){
        add(botonAzul);
        add(botonRojo);
        
        ColorFondo azul = new ColorFondo(Color.BLUE);
        ColorFondo rojo = new ColorFondo(Color.RED);
        
        botonAzul.addActionListener(azul);
        botonRojo.addActionListener(rojo);
    }
    
    
    
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
    }
    
    class ColorFondo implements ActionListener{ //Clase interna
    private Color colorFondo;
    
    public ColorFondo(Color colorFondo){
        this.colorFondo = colorFondo;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        setBackground(colorFondo);
    }
    
}
}


