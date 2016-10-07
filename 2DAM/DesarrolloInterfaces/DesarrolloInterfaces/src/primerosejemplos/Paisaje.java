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

class SuperficieDibujo extends JPanel{
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        //Suelo
        g.setColor(Color.green);
        g.drawLine(0, 640, 700, 640);
        
        //Casa
        g.setColor(Color.darkGray);
        g.fillRect(40, 400, 250, 640 - 400);
        
        //Tejado
        g.setColor(Color.red);
        g.drawLine(40, 400, 150, 200);
        
        g.setColor(Color.red);
        g.drawLine(150, 200, 290, 400);
        
        //Puerta
        g.setColor(Color.gray);
        g.fillRect(120, 450, 100, 640 - 450);
        
        g.setColor(Color.white);
        g.drawLine(120, 450, 185, 500);
        g.drawLine(185,500, 185, 640); 
        
        g.fillOval(150, 550, 20, 20);
        //Arbol
        g.setColor(Color.black);
        g.fillRect(500, 400, 60, 640-400);
        
        g.setColor(Color.green);
        g.fillOval(450, 350, 150, 100);
        
        //Sol
        g.setColor(Color.yellow);
        g.fillOval(450, 100, 100, 100);
        
        //Nubes
        g.setColor(Color.blue);
        g.drawOval(150, 50, 250, 100);
        g.drawOval(120, 90, 250, 100);
        g.drawOval(100, 75, 250, 100);
    }
}
public class Paisaje extends JFrame{
    
    public Paisaje() {
        setSize(700, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        add(new SuperficieDibujo());
    }
    
    public static void main(String[] args) {
        Paisaje paisaje = new Paisaje();
    }
}
