/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ditema3;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class DiTema3 extends JFrame {

    public DiTema3() {
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        String[] sexo = {"hetero", "homo", "bi", "auto"};
        int opcion2 = JOptionPane.showOptionDialog(this, "Tu que eres?","Peticion", 
                -1, JOptionPane.QUESTION_MESSAGE, null, sexo, sexo[0]); //EL null es icono

        //OPCIONES
        String[] colores = {"rojo", "negro", "azul"};
        Object opcion = JOptionPane.showInputDialog(this, //Peticion es el nombre de la ventana
                "Selecciona un color", "Peticion", JOptionPane.QUESTION_MESSAGE,
                null, colores, colores[0]);

        //RECOGER INFO
        String nombre = JOptionPane.showInputDialog(this, "Como te llamas?",
                JOptionPane.QUESTION_MESSAGE);
        
        //---
        int seleccionada = JOptionPane.showConfirmDialog(this, "Lo aceptas?", "Aviso",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        
        switch(seleccionada) {
            case JOptionPane.YES_OPTION:
                System.out.println("si"); break;
            case JOptionPane.NO_OPTION:
                System.out.println("no");break;
            case JOptionPane.CLOSED_OPTION:
                System.out.println("Se ha cerrado la ventana");
        }

        //MENSAJES VENTANA
        /*
        JOptionPane.showMessageDialog(this,
                "Error desconocido!", "Error",
                JOptionPane.ERROR_MESSAGE);
        
        JOptionPane.showMessageDialog(this,
                "Error desconocido!", "Error",
                JOptionPane.INFORMATION_MESSAGE);
        
        JOptionPane.showMessageDialog(this,
                "Error desconocido!", "Error",
                JOptionPane.WARNING_MESSAGE);
        
        JOptionPane.showMessageDialog(this,
                "Error desconocido!", "Error",
                JOptionPane.PLAIN_MESSAGE);
         */
    }

    public static void main(String[] args) {
        DiTema3 d = new DiTema3();
    }

}
