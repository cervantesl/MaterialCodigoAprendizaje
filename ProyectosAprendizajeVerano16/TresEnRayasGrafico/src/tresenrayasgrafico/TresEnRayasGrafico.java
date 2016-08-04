/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tresenrayasgrafico;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

/**
 *
 * @author Lucas
 */
public class TresEnRayasGrafico implements ActionListener, MouseListener{

    public final int WIDTH = 500, HEIGTH = 500;
    
    public static TresEnRayasGrafico tenrg;
    
    public Renderer renderer;
    
    public int gameStatus = 2;
    
    public TresEnRayasGrafico() {
        
        JFrame jframe = new JFrame("Tres en Rayas");
        
        renderer = new Renderer();
        
        jframe.setVisible(true);
        jframe.setResizable(false);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(WIDTH, HEIGTH);
        jframe.add(renderer);
        jframe.addMouseListener(this);
        
    }
            
    public static void main(String[] args) {
        
        tenrg = new TresEnRayasGrafico();
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        renderer.repaint();
        
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
        //WIDTH (X): 4 , HEIGHT (Y): 33
        //WIDTH (X): 150 , HEIGHT (Y): 181
        System.out.println("WIDTH (X): "+me.getX()+" , HEIGHT (Y): "+me.getY());
        
        if (me.getX() >= 4 ) {
            
            gameStatus = 1;
            
            System.out.println(gameStatus);
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {  }

    @Override
    public void mouseReleased(MouseEvent me) {    }

    @Override
    public void mouseEntered(MouseEvent me) {    }

    @Override
    public void mouseExited(MouseEvent me) {    }

    public void render(Graphics2D g) {

        if (gameStatus == 0) {
            
        
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, WIDTH, WIDTH);

            g.setColor(Color.WHITE);
            g.setStroke(new BasicStroke(5f));
            g.drawLine(WIDTH / 2 - 100, 50, WIDTH / 2 - 100, HEIGTH - 50);

            g.setColor(Color.WHITE);
            g.drawLine(WIDTH / 2 + 100, 50, WIDTH / 2 + 100, HEIGTH - 50);

            g.setColor(Color.WHITE);
            g.drawLine(WIDTH - 50, HEIGTH / 2 - 100, 50, HEIGTH / 2 - 100);

            g.setColor(Color.WHITE);
            g.drawLine(WIDTH - 50 , HEIGTH / 2 + 50, 50, HEIGTH / 2 + 50);
            
        }
        
        else if (gameStatus == 1) {
            
             g.setColor(Color.BLACK);
            g.fillRect(0, 0, WIDTH, WIDTH);

            g.setColor(Color.WHITE);
            g.setStroke(new BasicStroke(5f));
            g.drawLine(WIDTH / 2 - 100, 50, WIDTH / 2 - 100, HEIGTH - 50);

            g.setColor(Color.WHITE);
            g.drawLine(WIDTH / 2 + 100, 50, WIDTH / 2 + 100, HEIGTH - 50);

            g.setColor(Color.WHITE);
            g.drawLine(WIDTH - 50, HEIGTH / 2 - 100, 50, HEIGTH / 2 - 100);

            g.setColor(Color.WHITE);
            g.drawLine(WIDTH - 50 , HEIGTH / 2 + 50, 50, HEIGTH / 2 + 50);

        }
    }
    
}
