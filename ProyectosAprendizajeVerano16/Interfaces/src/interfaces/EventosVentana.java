/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;


public class EventosVentana {
    public static EventosVentana eventosVentana;
    public static EventosVentana ventana2;
    
    public EventosVentana(){
        JFrame jframe = new JFrame();
        jframe.setSize(800, 800);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
        jframe.setResizable(false);
        
        Ventana v = new Ventana();
        
        jframe.addWindowListener(v);
        
    }
    
    public static void main(String[] args) {
        eventosVentana = new EventosVentana();
        ventana2 = new EventosVentana();
    }
}

//class Ventana implements WindowListener{ //Como es interfaz se pone implements
//
//    @Override
//    public void windowOpened(WindowEvent we) {
//        System.out.println("Ventana abierta");
//    }
//
//    @Override
//    public void windowClosing(WindowEvent we) {
//        System.out.println("Cerrando ventana");
//    }
//
//    @Override
//    public void windowClosed(WindowEvent we) {
//        
//    }
//
//    @Override
//    public void windowIconified(WindowEvent we) {
//        System.out.println("Ventana minimizada");
//    }
//
//    @Override
//    public void windowDeiconified(WindowEvent we) {
//        System.out.println("Ventana restaurada (de nuevo abierta)");
//    }
//
//    @Override
//    public void windowActivated(WindowEvent we) {
//        System.out.println("Ventana activada");
//    }
//
//    @Override
//    public void windowDeactivated(WindowEvent we) {
//        System.out.println("Ventana desactivada");
//    }
//
//}


class Ventana extends WindowAdapter{ //Igual que el anterior pero sin tener que usar todos los metodos
     @Override
    public void windowClosed(WindowEvent we) {
        
    }
}
