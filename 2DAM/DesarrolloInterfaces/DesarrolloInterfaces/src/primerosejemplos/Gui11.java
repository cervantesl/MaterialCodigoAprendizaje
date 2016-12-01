/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primerosejemplos;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Lucas
 */
public class Gui11 extends JFrame {

    JButton boton1, boton2;
    JLabel label1;
    int contador;

    public Gui11() {
        contador = 0;

        boton1 = new JButton("PULSA");
        boton2 = new JButton("RESTART");

        add(boton1);
        add(boton2);
        boton1.addActionListener(new OyenteBotonPulsaciones());
        boton2.addActionListener(new OyenteBotonPulsaciones());

        label1 = new JLabel("Pulsaciones: " + contador);
        add(label1);

        setLayout(new FlowLayout());
        setVisible(true);
        setSize(400, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Gui11 g = new Gui11();
    }

    class OyenteBotonPulsaciones implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String s = (String) e.getActionCommand();

            if (e.getSource() == boton1) {
                contador++;
                label1.setText("Pulsaciones: " + contador);
            }
            else if(e.getSource() == boton2) {
                contador = 0;
                label1.setText("Pulsaciones: " + contador);
            }

        }
    }
}
