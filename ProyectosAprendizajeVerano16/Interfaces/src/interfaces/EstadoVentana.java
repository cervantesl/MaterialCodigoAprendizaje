/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import javax.swing.JFrame;

/**
 *
 * @author Lucas
 */
public class EstadoVentana {
    public static EstadoVentana ventana;
    public VentanaII v;
    public EstadoVentana(){
        JFrame jframe = new JFrame();
        VentanaII v = new VentanaII();
        jframe.setSize(800, 800);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
        jframe.setResizable(false);
        jframe.addWindowStateListener(v);
    }
    
    
    public static void main(String[] args) {
        ventana = new EstadoVentana();
    }
}

class VentanaII implements WindowStateListener{
    @Override
    public void windowStateChanged(WindowEvent we) {
        if (we.getNewState() == Frame.MAXIMIZED_BOTH) {
            System.out.println("La ventana se ha maximinado");
        }
        else if(we.getNewState() == Frame.NORMAL){
            System.out.println("La ventana esta normal");
        }
        else if(we.getNewState() == Frame.ICONIFIED){
            System.out.println("La ventana esta minimizada");
        }
    }
}
