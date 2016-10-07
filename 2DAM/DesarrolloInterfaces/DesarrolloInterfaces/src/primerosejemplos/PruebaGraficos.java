/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primerosejemplos;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Lucas
 */
class Lamina extends JPanel{
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.black);
        g.drawLine(0, 640, 700, 640);
        
        g.setColor(Color.blue);
        g.drawLine(20, 640, 20, 300);
        
        g.setColor(Color.red);
        g.drawLine(40, 640, 40, 200);
        
        g.setColor(Color.orange);
        g.drawLine(60, 640, 60, 500);
        
        g.setColor(Color.pink);
        g.drawLine(80, 640, 80, 400);
        
        g.setColor(Color.yellow);
        g.fillRect(100, 200, 20, 640 - 200);
        
        g.setColor(Color.green);
        g.fillRect(140, 300, 20, 640 - 300);
        
        g.setColor(Color.red);
        g.fillRect(180, 500, 20, 640 - 500);
        
        g.setColor(Color.pink);
        g.fillRect(220, 100, 20, 640 - 100);
        
        g.setColor(Color.CYAN);
        g.fillRect(260, 200, 20, 640 - 200);
        
        
    }
}
public class PruebaGraficos extends JFrame{
    
    public PruebaGraficos() {
        setSize(700, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        add(new Lamina());
        
    }
    
    public static void main(String[] args) {
        PruebaGraficos app = new PruebaGraficos();
    }
}
