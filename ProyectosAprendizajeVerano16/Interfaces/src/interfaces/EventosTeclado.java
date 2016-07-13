/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 *
 * @author Lucas
 */
public class EventosTeclado {

    public static EventosTeclado eT;

    public EventosTeclado() {
        JFrame jframe = new JFrame();
        jframe.setSize(800, 800);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
        jframe.setResizable(false);

        Teclado t = new Teclado();
        jframe.addKeyListener(t);

    }

    public static void main(String[] args) {
        eT = new EventosTeclado();
    }
}

class Teclado implements KeyListener {

    @Override
    public void keyTyped(KeyEvent ke) {
        char teclaPulsada = ke.getKeyChar();
        System.out.println("La tecla pulsada es: " + teclaPulsada);
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int codigo = ke.getKeyCode();
        System.out.println("El codigo de teclado es: " + codigo);
    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }
}
