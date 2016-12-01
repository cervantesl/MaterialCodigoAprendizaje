/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primerosejemplos;

import java.awt.BorderLayout;
import java.awt.List;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 *
 * @author Lucas
 */
public class Gui17 extends JFrame{
    
    JButton boton;
    List list;
    JScrollPane scrollpane;
    String[] elementos;
    
    public Gui17() {
        //setLayout(new FlowLayout());  
        
        list = new List();
        scrollpane = new JScrollPane(list);
        
        list.addMouseMotionListener(new OyenteRatonMotion());
        list.addMouseListener(new OyenteRaton());
        getContentPane().add(scrollpane, BorderLayout.CENTER);
        
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        Gui17 g = new Gui17();
    }
    
    class OyenteRatonMotion implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent me) {
            list.add("arrastrando");
        }

        @Override
        public void mouseMoved(MouseEvent me) {
            //list.add("moviendo");
        }    
    }
    
    class OyenteRaton implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
            list.add("click");
        }

        @Override
        public void mousePressed(MouseEvent me) {
            list.add("pulsar");
        }

        @Override
        public void mouseReleased(MouseEvent me) {
            list.add("soltar");
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            list.add("enter");
        }

        @Override
        public void mouseExited(MouseEvent me) {
            list.add("exit");
        }
        
    }
}
