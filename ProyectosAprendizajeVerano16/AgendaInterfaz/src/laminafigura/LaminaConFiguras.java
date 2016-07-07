/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laminafigura;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.SystemColor;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Lucas
 */
public class LaminaConFiguras {

    
    
    public static void main(String[] args) {
        MarconConDibujos m = new MarconConDibujos();
    }
}
    
    class MarconConDibujos extends JFrame{
        public MarconConDibujos(){
            setSize(500, 500);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            Lamina l = new Lamina();
            add(l);
            
            //l.setBackground(Color.yellow.darker());
            l.setBackground(SystemColor.window);
        }
    }
    
     class Lamina extends JPanel{
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            
            
            Graphics2D g2 = (Graphics2D) g;
            
            g2.setPaint(Color.GREEN);
            g2.drawLine(50, 40, 200, 200);
            
            
        }
    }
    
