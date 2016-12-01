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
import javax.swing.JTextField;

/**
 *
 * @author Lucas
 */
public class Gui13 extends JFrame {

    public JTextField cantidad;
    public JButton boton1;
    public JButton boton2;

    public Gui13() {
        boton1 = new JButton("A euros");
        boton2 = new JButton("A pesetas");
        cantidad = new JTextField(10);
        
        add(cantidad);
        add(boton1);
        add(boton2);
        
        
        setLayout(new FlowLayout());
        
        boton1.addActionListener(new OyenteBoton());
        boton2.addActionListener(new OyenteBoton());
        
        setVisible(true);
        setSize(250, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        Gui13 g = new Gui13();
    }

    class OyenteBoton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            Float f = new Float(cantidad.getText());
            float valor = f.floatValue();
            String tipoMonda = "";
            if (e.getSource() == boton1) {
                valor = (float) (valor / 166.312);
                boton1.setEnabled(false);
                boton2.setEnabled(true);
            }     
            else if(e.getSource() == boton2) {
                valor = (float) (valor * 166.321); 
                boton2.setEnabled(false);
                boton1.setEnabled(true);
            }
            
            cantidad.setText(Float.toString(valor));
            
        }

    }
}
