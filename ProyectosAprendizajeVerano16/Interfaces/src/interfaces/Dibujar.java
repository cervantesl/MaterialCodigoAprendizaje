/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Dibujar {
   
    public static Dibujar dibujar;
    public Rendererr renderer;
    
    public final int WIDTH = 800, HEIGHT = 800;
    
    public Dibujar(){
        JFrame jframe = new JFrame("Dibujo");
        
        renderer = new Rendererr();
 
        jframe.add(renderer);
        jframe.setSize(WIDTH, HEIGHT);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
        jframe.setResizable(false);
        jframe.setTitle("Flappy");
       
        
    }
    
    
    
    public void repaint(Graphics g){
        
        //Cielo
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        //Suelo
        g.setColor(Color.ORANGE);
        g.fillRect(0, HEIGHT - 120, WIDTH, 120);
        
        //Cesped
        g.setColor(Color.GREEN);
        g.fillRect(0, HEIGHT - 120, WIDTH, 20);
        
       
    }
    
    
    public static void main(String[] args) {
        dibujar = new Dibujar();
    }
}

class Rendererr extends JPanel{
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Dibujar.dibujar.repaint(g);
        
    }
}
