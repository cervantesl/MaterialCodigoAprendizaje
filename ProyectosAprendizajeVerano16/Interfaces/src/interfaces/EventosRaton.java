/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import org.w3c.dom.events.EventTarget;
import org.w3c.dom.events.MouseEvent;
import org.w3c.dom.views.AbstractView;

/**
 *
 * @author Lucas
 */
public class EventosRaton {

    public static EventosRaton eventosRaton;
    public Raton raton;
    
    public EventosRaton(){
        JFrame jframe = new JFrame();
        raton = new Raton();
        
        jframe.setSize(800, 800);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
        jframe.setResizable(false);
        
        jframe.addMouseListener(raton);
        
    }
    
    public static void main(String[] args) {
        eventosRaton = new EventosRaton();
    }
    
}

class Raton implements MouseListener{ //Para no tener que implementar todas los metodos se puede usar la clase MouseAdapter

    @Override
    public void mouseClicked(java.awt.event.MouseEvent me) {
        System.out.println("Has hecho click");
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent me) {
        System.out.println("Acabas de presionar");
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent me) {
        System.out.println("Acabas de levantar");   
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent me) {
        System.out.println("Acabas de entrar al marco");
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent me) {
        System.out.println("Acabas de salir del marco");
    }

    
}