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
import javax.swing.JTextField;

/**
 *
 * @author Lucas
 */
public class Gui10 extends JFrame {

    public JButton botonCopiar;
    public JTextField campoValor, resultado;

    public Gui10() {
        setLayout(new FlowLayout());

        add(new JLabel("Valor: "));

        campoValor = new JTextField(5);
        add(campoValor);

        botonCopiar = new JButton("Copiar");
        add(botonCopiar);
        botonCopiar.addActionListener(new OyenteBoton());

        add(new JLabel("               Copia: "));
        resultado = new JTextField(6);
        add(resultado);

        setSize(400, 100);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Gui10 app = new Gui10();
    }

    public JTextField obtenerCampoValor() {
        return campoValor;
    }

    public JTextField obtenerResultado() {
        return resultado;
    }

    class OyenteBoton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String valor = campoValor.getText();
            resultado.setText(valor);
        }

    }
}
