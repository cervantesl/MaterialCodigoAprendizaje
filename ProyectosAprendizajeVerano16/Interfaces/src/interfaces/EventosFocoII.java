/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import javax.swing.JFrame;


/**
 *
 * @author Lucas
 */
public class EventosFocoII extends JFrame implements WindowFocusListener {
    
    EventosFocoII marco1;
    
    EventosFocoII marco2;
    
    public void iniciar(){
       marco1 = new EventosFocoII();
       marco2 = new EventosFocoII();
       
       marco1.setBounds(200, 300, 500, 500);
       marco1.setVisible(true);
       marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       marco2.setBounds(900, 300, 500, 500);
       marco2.setVisible(true);
       marco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       marco1.addWindowFocusListener(this);
       marco2.addWindowFocusListener(this);
    }
    public static void main(String[] args) {
        EventosFocoII v = new EventosFocoII();
        
        v.iniciar();
    }

    @Override
    public void windowGainedFocus(WindowEvent we) {
        if (we.getSource().equals(marco1)) {
            marco1.setTitle("Tengo el foco");
        }
        else{
            marco2.setTitle("Tengo el foco");
        }
    }

    @Override
    public void windowLostFocus(WindowEvent we) {
        if (we.getSource().equals(marco1)) {
            marco1.setTitle("He perdido el foco");
        }
        else{
            marco2.setTitle("He perdido el foco");
        }
    }
}
