/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Lucas
 */
public class Eventos {
    public static Eventos eventos;
    public RendererII renderer;
    
    
    public final int WHIDTH = 800, HEIGHT = 800;
    public Eventos(){
        JFrame jframe = new JFrame();
        renderer = new RendererII();
        jframe.setSize(WHIDTH, HEIGHT);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
        jframe.setResizable(false);
        jframe.add(renderer);
    }
    
    public void Paint(Graphics g){
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, WHIDTH, HEIGHT);
        
        g.setColor(Color.ORANGE);
        g.fillRect(0, HEIGHT - 120, WHIDTH,  120);
        
        g.setColor(Color.GREEN);
        g.fillRect(0, HEIGHT - 120, WHIDTH, 20);
        
        g.setColor(Color.GREEN.darker());
        g.fillRect(500, 0, WHIDTH - 720, 400);
        
        g.setColor(Color.GREEN.darker());
        g.fillRect(500, HEIGHT - 250, WHIDTH - 720, 130);
        
        g.setColor(Color.RED);
        g.fillRect(WHIDTH / 2, HEIGHT / 2, 20, 20);
        
    }
    
    
    
    
    public static void main(String[] args) {
        eventos = new Eventos();
    }
}

class RendererII extends JPanel{
      JButton boton = new JButton("Blue");
        
        public RendererII(){
            add(boton);
        }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Eventos.eventos.Paint(g);
        
      
    }
}
