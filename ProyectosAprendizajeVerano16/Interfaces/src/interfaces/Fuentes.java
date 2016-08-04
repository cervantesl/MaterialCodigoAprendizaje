/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Lucas
 */
public class Fuentes {
    public static void main(String[] args) {
        Marco m = new Marco();
    }
}

class Marco extends JFrame{
    public Marco(){
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Lamina lamina = new Lamina();
        add(lamina);
        
        //lamina.setForeground(Color.yellow); Para que se vea todo en ese color
    }
}

class Lamina extends JPanel{
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D) g;
        
        Font fuente = new Font("Arial",Font.BOLD, 36);
        g2.setFont(fuente);
        g2.setColor(Color.yellow);
        g2.drawString("Hola", 100, 100);
        
        
        g2.setFont(new Font("Courier", Font.ITALIC, 33));
        g2.setColor(Color.BLUE);
        g2.drawString("Pepeee", 300, 300);
        
        Rectangle r = new Rectangle();
        
        g.setColor(Color.yellow);
        g.fillRect(100, 100, 200, 200);
    }
}
