/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ditema3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 *
 * @author Lucas
 */
public class Prueba {

    SuperficieDibujoPrueba sd;
    PanelDatosPrueba pd;

    public Prueba() {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());

        pd = new PanelDatosPrueba();
        sd = new SuperficieDibujoPrueba();
        frame.add(sd, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(500, 500);

        if (JOptionPane.showConfirmDialog(frame, pd, "Introduzca Datos",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE)
                == JOptionPane.OK_OPTION) {
            sd.nombre.setText("Nombre: " + pd.campoNombre.getText());
            sd.apellidos.setText("Apellidos: " + pd.campoApellidos.getText());
            sd.numero.setText("Numero Personal: " + pd.campoNP.getText());
            sd.botonSeleccionado.setText("Boton seleccionado: " + pd.seleccionado.getText());
        }
    }

    public static void main(String[] args) {
        Prueba p = new Prueba();
    }

}

class SuperficieDibujoPrueba extends JPanel {

    PanelDatosPrueba pd = new PanelDatosPrueba();

    public JLabel nombre;
    public JLabel apellidos;
    public JLabel numero;
    public JLabel botonSeleccionado;

    public SuperficieDibujoPrueba() {
        setLayout(new GridLayout());
        nombre = new JLabel();
        apellidos = new JLabel();
        numero = new JLabel();
        botonSeleccionado = new JLabel();

        add(nombre);
        add(apellidos);
        add(numero);
        add(botonSeleccionado);
    }
}

class PanelDatosPrueba extends JPanel {

    public JTextField campoNombre;
    public JTextField campoApellidos;
    public JTextField campoNP;
    public JRadioButton seleccionado;

    public PanelDatosPrueba() {
        setLayout(new GridLayout(4, 2));
        JLabel etiquetaNombre = new JLabel("Nombre: ", JLabel.RIGHT);
        campoNombre = new JTextField();
        add(etiquetaNombre);
        add(campoNombre);
        JLabel etiquetaApellidos = new JLabel("Apellidos: ", JLabel.RIGHT);
        campoApellidos = new JTextField();
        add(etiquetaApellidos);
        add(campoApellidos);

        JLabel etiquetaNP = new JLabel("Numero Personal: ", JLabel.RIGHT);
        campoNP = new JTextField();

        add(etiquetaNP);
        add(campoNP);

        ButtonGroup grupoBotones = new ButtonGroup();
        JRadioButton mañana = new JRadioButton("Grupo Mañana");
        JRadioButton tarde = new JRadioButton("Grupo tarde");
        grupoBotones.add(mañana);
        grupoBotones.add(tarde);
        add(mañana);
        add(tarde);

        
    

    }

    public static JRadioButton getSelection(ButtonGroup group) {
        JRadioButton b = null;
        for (Enumeration e = group.getElements(); e.hasMoreElements();) {
            b = (JRadioButton) e.nextElement();
            if (b.getModel() == group.getSelection()) {
                return b;
            }
        }

        return b;
    }

}
