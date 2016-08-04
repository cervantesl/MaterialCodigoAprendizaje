/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;

/**
 *
 * @author Lucas
 */
public class EventosRatonII {
    
    public static EventosRatonII eventosRaton;
    
    public RatonII raton;
    
    public EventosRatonII(){
        JFrame jframe = new JFrame();
        raton = new RatonII();
        
        jframe.setSize(800, 800);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
        jframe.setResizable(false);
        
        jframe.addMouseListener(raton);
        jframe.addMouseMotionListener(raton);
    }
    
    public static void main(String[] args) {
        eventosRaton = new EventosRatonII();
    }
}

class RatonII extends MouseAdapter implements MouseMotionListener{

    @Override
    public void mouseClicked(MouseEvent me) {
        System.out.println("WIDTH (X): "+me.getX()+" , HEIGHT (Y): "+me.getY());
        System.out.println("Has clicado: "+me.getClickCount()+" cantidad de veces");      
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (me.getModifiersEx() == MouseEvent.BUTTON1_DOWN_MASK) {
            System.out.println("Has presionado el boton izquierdo");
        }
        else if(me.getModifiersEx() == MouseEvent.BUTTON2_DOWN_MASK){
            System.out.println("Has presionado la rueda del raton");
        }
        else if(me.getModifiersEx() == MouseEvent.BUTTON3_DOWN_MASK){
            System.out.println("Has presionado el boton derecho");
        }
    }

    
    @Override
    public void mouseDragged(MouseEvent me){
        System.out.println("Estas arrastrando!");
    }
    
    @Override
    public void mouseMoved(MouseEvent me){
        System.out.println("Estas moviendo");
    }

}