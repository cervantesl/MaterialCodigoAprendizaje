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

class MiPanel extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.pink);
        g.fillOval(50, 50, 90, 90); //posX, posY, width (ancho), height (alto)
        g.drawString("Hola", 250, 250);
    }
}

public class Gui06 extends JFrame {
    public Gui06() {
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new MiPanel());
    }
    
    public static void main(String[] args) {
        Gui06 app = new Gui06();
    }
}
